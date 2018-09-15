/**
 * 
 */
package vknyazev_B31_A01_Quiz;

/**
 * @author slava
 *
 */
public class SingleChoiceQuestion extends Question {
    private QuestionOption options[];

    public SingleChoiceQuestion() {

    }

    public SingleChoiceQuestion(String question, QuestionOption options[]) {
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
        
        if (n > options.length || n < 0)
            return false;

        return options[n].getIsCorrect();
    }
    
    public String getPrompt() {
        String prompt = this.question;
        int n = 0;
        for (QuestionOption option: this.options)
            prompt += "\n" +  (++n) + ". " + option.getText();

        return prompt;
    }

    /**
     * @return the options
     */
    public QuestionOption[] getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(QuestionOption[] options) {
        this.options = options;
    }
}
