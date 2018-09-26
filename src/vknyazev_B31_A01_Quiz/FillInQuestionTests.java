package vknyazev_B31_A01_Quiz;

import static org.junit.Assert.*;

import org.junit.Test;

public class FillInQuestionTests {

	@Test
	public void testCheckAnswerCorrect() {
		FillInQuestion q = new FillInQuestion();
		q.setAnswer("test");
		boolean correct = q.checkAnswer("test");
		assertTrue("Identifies correct answer", correct);
	}

	@Test
	public void testCheckAnswerIncorrect() {
		FillInQuestion q = new FillInQuestion();
		q.setAnswer("test");
		boolean incorrect = q.checkAnswer("wrong");
		assertTrue("Identifies incorrect answer", !incorrect);
	}

	@Test
	public void testCheckAnswerEmptyIncorrect() {
		FillInQuestion q = new FillInQuestion();
		q.setAnswer("test");
		boolean incorrect = q.checkAnswer("");
		assertTrue("Empty answer", !incorrect);
	}

	@Test
	public void testCheckAnswerEmptyCorrect() {
		FillInQuestion q = new FillInQuestion();
		q.setAnswer("");
		boolean correct = q.checkAnswer("");
		assertTrue("Empty answer", correct);
	}

}
