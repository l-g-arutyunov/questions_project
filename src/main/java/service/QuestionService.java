package service;

import domain.Question;

import java.util.Map;

public interface QuestionService {
    void printResult(Map<Question, Boolean> result);
    Map<Question, Boolean> quizStart();
}
