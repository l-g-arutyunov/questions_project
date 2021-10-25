package ru.diasoft.questions.service;

import ru.diasoft.questions.domain.Question;

import java.util.Map;

public interface QuestionService {
    void printResult(Map<Question, Boolean> result);
    Map<Question, Boolean> quizStart();
}
