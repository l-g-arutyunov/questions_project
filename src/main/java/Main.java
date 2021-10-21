import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuestionService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuestionService service = context.getBean(QuestionService.class);
        service.printResult(service.quizStart());
    }
}
