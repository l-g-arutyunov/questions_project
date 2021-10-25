package ru.diasoft.questions.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.questions.dao.QuestionsDao;
import ru.diasoft.questions.domain.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionsDao questionsDao;

    @Override
    public Map<Question, Boolean> quizStart() {

        Scanner scanner = new Scanner(System.in);
        Map<Question,Boolean> result = new HashMap<>();
        List<Question> questions = questionsDao.getQuestions();

        for (Question question : questions) {
            System.out.println(question.getText());
            String answer = scanner.nextLine();
            if (question.getAnswer().equals(answer)) {
                System.out.println("Yes!" + '\n');
                result.put(question, true);
            } else {
                System.out.println("No!!!" + '\n');
                result.put(question, false);
            }
        }
        return result;
    }

    public void printResult(Map<Question, Boolean> result) {
        System.out.println("Result of game:");
        for (Map.Entry<Question, Boolean> entry : result.entrySet()) {
            System.out.println("Question №" + entry.getKey().getId() + " result - " + (entry.getValue() ? "good" : "terrible"));
        }
    }

}
