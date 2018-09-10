/**
 * 
 */
package vknyazev_B31_A01_Quiz;

/**
 * @author slava
 *
 */
public class QuestionOption {
    private String text;
    private boolean isCorrect;

    public QuestionOption(String text, boolean isCorrect){ 
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public QuestionOption() {

    }
    
    /**
     * @param isCorrect the isCorrect to set
     */
    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    /**
     * @return the isCorrect
     */
    public boolean getIsCorrect() {
        return isCorrect;
    }
    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
}
