/**
 * 
 */
package vknyazev_B31_A01_Quiz;

/**
 * @author slava
 *
 */
public class FillInQuestion extends Question {
    private String answer;

    public FillInQuestion() {

    }
    public FillInQuestion(String question, String answer) {
        super(question);
        this.answer = answer;
        this.question = question;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }
    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean checkAnswer(String input) {
        return input.equalsIgnoreCase(this.answer);
    }
}
