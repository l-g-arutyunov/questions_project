package ru.diasoft.questions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.diasoft.questions.service.QuestionService;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);
        QuestionService service = context.getBean(QuestionService.class);
        service.printResult(service.quizStart());
    }

}
