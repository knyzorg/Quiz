package vknyazev_B31_A01_Quiz;

public class InvalidQuestionDataException extends RuntimeException {
	public InvalidQuestionDataException() {
        super("Invalid Question Data");
    }

    public InvalidQuestionDataException(String text) {
        super(text);
    }
}
