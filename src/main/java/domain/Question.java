package domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Question {
    private final String text;
    private final String answer;
    private final int id;
}
