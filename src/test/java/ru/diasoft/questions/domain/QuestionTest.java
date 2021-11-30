package ru.diasoft.questions.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс Question")
public class QuestionTest {

    @DisplayName("корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Question question = new Question("something question", "something answer", 0);

        assertEquals("something question", question.getText());
        assertEquals("something answer", question.getAnswer());
    }
}
