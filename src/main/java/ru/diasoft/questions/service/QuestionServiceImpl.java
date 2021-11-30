package ru.diasoft.questions.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.diasoft.questions.dao.QuestionsDao;
import ru.diasoft.questions.domain.Question;

import java.util.*;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionsDao questionsDao;
    private final MessageSource messageSource;
    @Value("${external.locale}")
    private String locale;

    @Override
    public Map<Question, Boolean> quizStart() {

        Scanner scanner = new Scanner(System.in);
        Map<Question,Boolean> result = new HashMap<>();
        List<Question> questions = questionsDao.getQuestions();

        for (Question question : questions) {
            System.out.println(question.getText());
            String answer = scanner.nextLine();
            if (question.getAnswer().equals(answer)) {
                System.out.println(getMessage("yes") + '\n');
                result.put(question, true);
            } else {
                System.out.println(getMessage("no") + '\n');
                result.put(question, false);
            }
        }
        return result;
    }

    public void printResult(Map<Question, Boolean> result) {
        System.out.println(getMessage("resultOfGame"));
        for (Map.Entry<Question, Boolean> entry : result.entrySet()) {
            System.out.println(getMessage("question") + entry.getKey().getId() + " " +
                    getMessage("result") + " " + (entry.getValue() ? getMessage("good") : getMessage("terrible")));
        }
    }

    private String getMessage(String word) {
        return messageSource.getMessage("service." + word + ".string", null, Locale.forLanguageTag(locale));
    }

}
