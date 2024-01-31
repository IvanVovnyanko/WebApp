package ua.javarush;

import java.util.HashMap;
import java.util.Arrays;

public class StepsConfig {
    private final HashMap<Integer, Step> stepsConfig = new HashMap<>();
    private static int globalId = 0;

    public StepsConfig() {
        initializeStepsConfig();
    }

    private void initializeStepsConfig() {
        // Здесь вы можете добавить свои шаги и варианты ответов
        addStep(new Step(
                getNextGlobalId(),
                "Ты потерял память. Принять вызов НЛО?",
                Arrays.asList(
                        new AnswerOption("Принять вызов", true),
                        new AnswerOption("Отклонить вызов", false, "Ты отклонил вызов. Поражение.")),
                getNextGlobalId()
        ));

        addStep(new Step(
                getNextGlobalId(),
                "Ты принял вызов. Поднимаешься на мостик к капитану?",
                Arrays.asList(
                        new AnswerOption("Подняться на мостик", true),
                        new AnswerOption("Отказаться подниматься на мостик", false, "Ты не пошёл на переговоры. Поражение.")),
                getNextGlobalId()
        ));

        addStep(new Step(
                getNextGlobalId(),
                "Ты поднялся на мостик. Ты кто?",
                Arrays.asList(
                        new AnswerOption("Рассказать правду о себе", true),
                        new AnswerOption("Солгать о себе", false, "Твою ложь разоблачили. Поражение.")),
                0
        ));
    }

    private void addStep(Step step) {
        stepsConfig.put(step.getId(), step);
    }

    private int getNextGlobalId() {
        return ++globalId;
    }

    public HashMap<Integer, Step> getStepsConfig() {
        return stepsConfig;
    }

    public int getInitialStepId() {
        return 1;
    }
}