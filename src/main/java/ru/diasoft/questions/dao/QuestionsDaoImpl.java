package ru.diasoft.questions.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;
import ru.diasoft.questions.domain.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "questions")
@Repository
public class QuestionsDaoImpl implements QuestionsDao {

    @Value("${external.fileName}")
    private String fileName;

    @Override
    public List<Question> getQuestions() {
        String questionPath = getClass().getClassLoader().getResource(fileName).getPath();
        List<Question> questions = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(questionPath));
            while (reader.ready()) {
                String str = reader.readLine();
                if (str.trim().equals("")) {
                    continue;
                }
                String[] lines = str.split(",");
                if (lines.length < 3) {
                    continue;
                }
                String id = lines[0];
                String question = lines[1];
                String answer = lines[2];
                if (question != null && answer != null && id != null) {
                    questions.add(new Question(question, answer, Integer.parseInt(id)));
                }
            }
        } catch (Exception e) {
            return null;
        }

        return questions;
    }
}
