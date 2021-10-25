package ru.diasoft.questions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import ru.diasoft.questions.service.QuestionService;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuestionService service = context.getBean(QuestionService.class);
        service.printResult(service.quizStart());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
            final var configurer = new PropertySourcesPlaceholderConfigurer();
            configurer.setLocation(new ClassPathResource("application.properties"));
            return configurer;
    }


}
