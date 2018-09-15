/**
 * 
 */
package vknyazev_B31_A01_Quiz;

/**
 * @author slava
 *
 */
public abstract class Question {
    public String question;
    public abstract boolean checkAnswer(String input);
    public abstract String getPrompt();

    public Question() {

    }

    public Question(String question) {
        this.question = question;
    }
    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }
}
