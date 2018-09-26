/**
 * 
 */
package vknyazev_B31_A01_Quiz;
import java.util.ArrayList;
/**
 * @author slava
 *
 */
public class SingleChoiceQuestion extends Question {
    private ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();

    public SingleChoiceQuestion() {

    }

    public SingleChoiceQuestion(String question, ArrayList<QuestionOption> options) {
        super(question);
        this.options = options;
    }

    public boolean checkAnswer(String input) {
        int n = -1;
        try {
            // -1 to adjust for 1-indexing
            n = Integer.parseInt(input) - 1;
        } catch (NumberFormatException e) {
            return false;
        }
        
        if (n > options.size()-1 || n < 0)
            return false;

        return options.get(n).getIsCorrect();
    }
    
    public String getPrompt() {
        String prompt = super.getPrompt();
        int n = 0;
        for (QuestionOption option: this.options)
            prompt += "\n" +  (++n) + ". " + option.getText();

        return prompt;
    }

    /**
     * @return the options
     */
    public ArrayList<QuestionOption> getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(ArrayList<QuestionOption> options) {
        this.options = options;
    }
}
