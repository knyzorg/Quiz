/**
 * 
 */
package vknyazev_B31_A01_Quiz;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author slava
 *
 */
public class MultiChoiceQuestion extends SingleChoiceQuestion {
    public MultiChoiceQuestion() {
        
    }

    public MultiChoiceQuestion(String question, QuestionOption options[]) {
        super(question, options);
    }

    public int getCorrectAnswerCount() {
        int n = 0;
        for (QuestionOption option: getOptions()) {
            if (option.getIsCorrect()) n++;
        }

        return n;
    }

    public boolean checkAnswer(String input) {
        int correctCount = getCorrectAnswerCount();

        // Will hold unique answers
        ArrayList<Integer> answers = new ArrayList<Integer>();

        // Parse inputs
        StringTokenizer s = new StringTokenizer(input, ",");

        // Different amount of answers
        if (correctCount != s.countTokens())
            return false;

        while (s.hasMoreTokens()) {
            int index = Integer.parseInt(s.nextToken());
            boolean exists = false;
            for (int a: answers)
                if (a == index)
                    exists = true;

            if (exists)
                // Duplicate answer, bail
                return false;
            
            if (!super.checkAnswer(index + ""))
                // Incorrect answer, bail
                return false;

            // All checks passed, add to answers
            answers.add(index);
        }

        return true;
    }
}
