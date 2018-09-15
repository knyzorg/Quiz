/**
 * 
 */
package vknyazev_B31_A01_Quiz;

/**
 * @author slava
 *
 */
public class NumericQuestion extends Question {
    private double answer;
    public NumericQuestion(String question, double answer) {
        super(question);
        this.answer = answer;
    }

    public String getPrompt() {
        return question;
    }
    public boolean checkAnswer(String input) {
        double inputDouble = Double.parseDouble(input);
        return (inputDouble + 0.05 > answer && inputDouble - 0.05 < answer);
    }
}
