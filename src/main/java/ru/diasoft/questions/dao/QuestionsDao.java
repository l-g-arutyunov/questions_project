package ru.diasoft.questions.dao;

import ru.diasoft.questions.domain.Question;

import java.util.List;


public interface QuestionsDao {
    List<Question> getQuestions();
}
