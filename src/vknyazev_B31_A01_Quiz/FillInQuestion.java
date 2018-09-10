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
    private String question;

    public FillInQuestion() {

    }
    public FillInQuestion(String question, String answer) {
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
    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }
    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPrompt() {
        return question;
    }

    public boolean checkAnswer(String input) {
        return input.equalsIgnoreCase(this.answer);
    }
}
