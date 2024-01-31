package ua.javarush;

public class AnswerResult {
    private boolean success;
    private int nextStepId;
    private String message;

    public AnswerResult(boolean success, int nextStepId, String message) {
        this.success = success;
        this.nextStepId = nextStepId;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getNextStepId() {
        return nextStepId;
    }

    public String getMessage() {
        return message;
    }
}
