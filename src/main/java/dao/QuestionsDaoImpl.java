package dao;

import au.com.bytecode.opencsv.CSVReader;
import domain.Question;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoImpl implements QuestionsDao {
    private static final String QUESTIONS_CSV = "questions.csv";

    @Override
    public List<Question> getQuestions() {
        String questionPath = getClass().getClassLoader().getResource(QUESTIONS_CSV).getPath();
        List<Question> questions = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(questionPath));
            List<String[]> lines = reader.readAll();
            for (int i = 0; i+4 <= lines.size(); i+=4) {
                String id = lines.get(i)[0];
                String question = lines.get(i+1)[0];
                String answer = lines.get(i+2)[0];
                if (question != null && answer != null && id != null) {
                    questions.add(new Question(question, answer, Integer.parseInt(id)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return questions;
    }
}
