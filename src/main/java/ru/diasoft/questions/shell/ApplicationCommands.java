package ru.diasoft.questions.shell;


import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.diasoft.questions.service.QuestionService;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationCommands {

    private final QuestionService questionService;
    private String userName;

    @ShellMethod(value = "login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "AnyUser") String userName) {
        this.userName = userName;
        return String.format("Welcome, %s", userName);
    }

    @ShellMethod(value = "start quiz", key = {"s", "start"})
    @ShellMethodAvailability(value = "isLogin")
    public String start() {
        questionService.printResult(questionService.quizStart());
        return "quiz is end";
    }

    private Availability isLogin() {
        return userName == null? Availability.unavailable("U aren't login in system"): Availability.available();
    }

}
