package service;

import domain.Question;

import java.util.Map;

public interface QuestionService {
     static void printResult(Map<Question, Boolean> result) {
        System.out.println("Результат игры:");
        for (Map.Entry<Question, Boolean> entry : result.entrySet()) {
            System.out.println("Вопрос №" + entry.getKey().getId() + " результат - " + (entry.getValue() ? "верно" : "неверно"));
        }
    }
     Map<Question, Boolean> quizStart();
}
