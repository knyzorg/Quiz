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
    private QuestionOption options[];
    private String question;

    public SingleChoiceQuestion() {

    }

    public SingleChoiceQuestion(String question, QuestionOption options[]) {

    }

    public boolean checkAnswer(String input) {
        int n = -1;
        try {
            n = Integer.parseInt(input);
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
            prompt += "\n" +  (++n) + " ." + option.getText();
        return prompt;
    }
}
