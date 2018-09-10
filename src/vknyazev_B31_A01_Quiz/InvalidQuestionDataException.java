package vknyazev_B31_A01_Quiz;

public class InvalidQuestionDataException extends RuntimeException {
	public InvalidQuestionDataException() {

    }

    public InvalidQuestionDataException(String text) {
        super(text);
    }
}
