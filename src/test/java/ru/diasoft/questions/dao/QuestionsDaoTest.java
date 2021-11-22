package ru.diasoft.questions.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Класс QuestionsDao")
public class QuestionsDaoTest {

    private final static String QUESTION_FILE_NAME = "questionsEn_en.csv";

    @DisplayName("должен возвращать список всех вопросов")
    @Test
    void shouldReturnListOfQuestion() {
        QuestionsDaoImpl dao = new QuestionsDaoImpl(QUESTION_FILE_NAME);

        assertTrue(dao.getQuestions().size() > 0);
    }
}
