package ua.javarush;

import lombok.Getter;

import static java.util.Objects.isNull;

public class AnswerOption {
    private static int globalId = 0;

    @Getter
    private final int id;
    @Getter
    private final String description;
    private final boolean isTrueAnswer;
    @Getter
    private final String failedMessage;

    public AnswerOption(String description, boolean isTrueAnswer) {
        if (isNull(description)) {
            throw new IllegalArgumentException("description cannot be null.");
        }

        this.id = ++globalId;
        this.description = description;
        this.isTrueAnswer = isTrueAnswer;
        this.failedMessage = null;
    }

    public AnswerOption(String description, boolean isTrueAnswer, String failedMessage) {
        if (isNull(description)) {
            throw new IllegalArgumentException("description cannot be null.");
        }

        this.id = ++globalId;
        this.description = description;
        this.isTrueAnswer = isTrueAnswer;
        this.failedMessage = failedMessage;
    }

    public boolean isTrueAnswer() {
        return isTrueAnswer;
    }
}