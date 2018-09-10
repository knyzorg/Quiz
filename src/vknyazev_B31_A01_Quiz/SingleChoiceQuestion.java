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
    private ArrayList<QuestionOption> options;
    private String question;

    public SingleChoiceQuestion() {

    }

    public SingleChoiceQuestion(String question, ArrayList<QuestionOption> options) {

    }

    public boolean checkAnswer(String input) {
        return false;
    }
}
