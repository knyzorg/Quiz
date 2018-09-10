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
            //TODO: handle exception
        }
        
        if (n > options.length || n < 0)
            return false;

        return options[n].getIsCorrect();
    }
}
