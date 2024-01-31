package ua.javarush;


import java.util.List;

import static java.util.Objects.isNull;

public class Question {
    private final List<AnswerOption> options;
    private final String description;

    public Question(String description, List<AnswerOption> options) {
        if (isNull(description) || isNull(options) || options.isEmpty()) {
            throw new IllegalArgumentException("Invalid question parameters.");
        }
        this.description = description;
        this.options = options;
    }

    public List<AnswerOption> getOptions() {
        return options;
    }

    public String getDescription() {
        return description;
    }
}