package domain;

public class Question {
    private final String text;
    private final String answer;
    private final int id;

    public Question(String text, String answer, int id) {
        this.text = text;
        this.answer = answer;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public String getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }
}
