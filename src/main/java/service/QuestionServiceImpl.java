package service;

import dao.QuestionsDao;
import domain.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionsDao questionsDao;

    public QuestionServiceImpl(QuestionsDao questionsDao) {
        this.questionsDao = questionsDao;
    }

    @Override
    public Map<Question, Boolean> quizStart() {

        Scanner scanner = new Scanner(System.in);
        Map<Question,Boolean> result = new HashMap<>();
        List<Question> questions = questionsDao.getQuestions();

        for (Question question : questions) {
            System.out.println(question.getText());
            String answer = scanner.nextLine();
            if (question.getAnswer().equals(answer)) {
                System.out.println("Верно!" + '\n');
                result.put(question, true);
            } else {
                System.out.println("Ошибка!!!" + '\n');
                result.put(question, false);
            }
        }
        return result;
    }

    public void printResult(Map<Question, Boolean> result) {
        System.out.println("Результат игры:");
        for (Map.Entry<Question, Boolean> entry : result.entrySet()) {
            System.out.println("Вопрос №" + entry.getKey().getId() + " результат - " + (entry.getValue() ? "верно" : "неверно"));
        }
    }

}
