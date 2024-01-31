package ua.javarush;
import java.util.List;

import static java.util.Objects.isNull;

public class Step {
    private final int id;
    private final String description;
    private final List<AnswerOption> options;
    private final int nextStepId;

    public Step(int id, String description, List<AnswerOption> options, int nextStepId) {
        if (isNull(description) || isNull(options) || options.isEmpty()) {
            throw new IllegalArgumentException("Invalid step parameters.");
        }

        this.id = id;
        this.description = description;
        this.options = options;
        this.nextStepId = nextStepId;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<AnswerOption> getOptions() {
        return options;
    }

    public int getNextStepId() {
        return nextStepId;
    }

    public AnswerOption getAnswerOptionById(int optionId) {
        return this.options.stream()
                .filter(option -> option.getId() == optionId)
                .findFirst()
                .orElse(null);
    }
}