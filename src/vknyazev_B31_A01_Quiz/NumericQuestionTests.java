package vknyazev_B31_A01_Quiz;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class NumericQuestionTests {

    @Test
    public void testCheckAnswerCorrect() {

        NumericQuestion q = new NumericQuestion("Question", 5);
        assertTrue("Identifies correct answer", q.checkAnswer("5"));
    }

    @Test
    public void testCheckAnswerUpperInRange() {

        NumericQuestion q = new NumericQuestion("Question", 5);
        assertTrue("Identifies correct answer", q.checkAnswer("5.01"));
    }
    @Test
    public void testCheckAnswerLowerInRange() {

        NumericQuestion q = new NumericQuestion("Question", 5);
        assertTrue("Identifies correct answer", q.checkAnswer("4.99"));
    }
    @Test
    public void testCheckAnswerUpperOutRange() {

        NumericQuestion q = new NumericQuestion("Question", 5);
        assertTrue("Identifies incorrect answer", !q.checkAnswer("5.011"));
    }
    @Test
    public void testCheckAnswerLowerOutRange() {

        NumericQuestion q = new NumericQuestion("Question", 5);
        assertTrue("Identifies incorrect answer", !q.checkAnswer("4.989"));
    }

    @Test
    public void testCheckAnswerIncorrect() {

        NumericQuestion q = new NumericQuestion("Question", 5);
        assertTrue("Identifies incorrect answer", !q.checkAnswer("1"));
    }

    @Test
    public void testCheckAnswerNoAnswer() {
        NumericQuestion q = new NumericQuestion();
        assertTrue("Empty answer", !q.checkAnswer(""));
    }

    @Test
    public void testCheckAnswerMalformedAnswer() {
        NumericQuestion q = new NumericQuestion("Question", 5);
        assertTrue("Malformed answer", !q.checkAnswer("abc"));
    }

}
