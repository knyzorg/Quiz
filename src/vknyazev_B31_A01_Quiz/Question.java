/**
 * 
 */
package vknyazev_B31_A01_Quiz;

/**
 * @author slava
 *
 */
public abstract class Question {
    public abstract boolean checkAnswer(String input);
    public abstract String getPrompt();
}
