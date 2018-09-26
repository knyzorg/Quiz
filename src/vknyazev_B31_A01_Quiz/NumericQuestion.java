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

    public NumericQuestion() {

    }
    
    public NumericQuestion(String question, double answer) {
        super(question);
        this.answer = answer;
    }

    public boolean checkAnswer(String input) {
        try {
            double inputDouble = Double.parseDouble(input);
            return (inputDouble + 0.01 >= answer && inputDouble - 0.01 <= answer);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @return the answer
     */
    public double getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(double answer) {
        this.answer = answer;
    }
}
