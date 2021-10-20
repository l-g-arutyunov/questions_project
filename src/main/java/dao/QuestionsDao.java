package dao;

import domain.Question;

import java.util.List;

public interface QuestionsDao {
    List<Question> getQuestions();
}
