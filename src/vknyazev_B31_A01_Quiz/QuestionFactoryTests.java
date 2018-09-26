package vknyazev_B31_A01_Quiz;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.junit.Test;

public class QuestionFactoryTests {

	@Test
	public void testGetQuestionFillIn() {
        String questionData = "F, *Penny oleksiak* was the Canadian flag bearer at the closing ceremonies in Rio.";
        Question q = QuestionFactory.getQuestion(questionData);
        assertTrue("Is FillInQuestion", q instanceof FillInQuestion);
        assertEquals("Correct question text", ((FillInQuestion) q).getQuestion(), "__________ was the Canadian flag bearer at the closing ceremonies in Rio.");
        assertEquals("Correct answer text", ((FillInQuestion) q).getAnswer(), "Penny oleksiak");
    }
    
	@Test
	public void testGetQuestionFillCorrupt1() {
        String questionData = "F, Penny oleksiak was the Canadian flag bearer at the closing ceremonies in Rio.";
        try {
            QuestionFactory.getQuestion(questionData);
            fail("Fail invalid fill in question");
        } catch (InvalidQuestionDataException e) {
            assertTrue(true);
        }
        
	}
	@Test
	public void testGetQuestionFillCorrupt2() {
        String questionData = "F, Penny oleksiak* was the Canadian flag bearer at the closing ceremonies in Rio.";
        try {
            QuestionFactory.getQuestion(questionData);
            fail("Fail invalid fill in question");
        } catch (InvalidQuestionDataException e) {
            assertTrue(true);
        }
        
	}
	@Test
	public void testGetQuestionFillCorrupt3() {
        String questionData = "F";
        try {
            QuestionFactory.getQuestion(questionData);
            fail("Fail invalid fill in question");
        } catch (InvalidQuestionDataException e) {
            assertTrue(true);
        }
        
	}


	@Test
	public void testGetQuestionNumeric() {
        String questionData = "N, How fast did Usain Bolt run the men’s 100m final in Rio?, 9.81";
        Question q = QuestionFactory.getQuestion(questionData);
        assertTrue("Is NumericQuestion", q instanceof NumericQuestion);
        assertEquals("Correct question text", ((NumericQuestion) q).getQuestion(), "How fast did Usain Bolt run the men’s 100m final in Rio?");
        assertEquals("Correct answer text", ((NumericQuestion) q).getAnswer(), 9.81, 0.01);
    }

	@Test
	public void testGetQuestionNumericCorrupt1() {
        String questionData = "N, How fast did Usain Bolt run the men’s 100m final in Rio?, abc";
        try {
            QuestionFactory.getQuestion(questionData);
            fail("Fail invalid numeric in question");
        } catch (InvalidQuestionDataException e) {
            assertTrue(true);
        }
	}

	@Test
	public void testGetQuestionNumericCorrupt2() {
        String questionData = "N";
        try {
            QuestionFactory.getQuestion(questionData);
            fail("Fail invalid numeric in question");
        } catch (InvalidQuestionDataException e) {
            
        }
    }


	@Test
	public void testGetQuestionChoice() {
        String questionData = "S, Canada met its goal for number of medals at the Rio Olympics., 2, True, correct, False, incorrect";
        Question q = QuestionFactory.getQuestion(questionData);
        assertTrue("Is SingleChoiceQuestion", q instanceof SingleChoiceQuestion);
        assertEquals("Correct question text", ((SingleChoiceQuestion) q).getQuestion(), "Canada met its goal for number of medals at the Rio Olympics.");
        assertEquals("Correct answer text", ((SingleChoiceQuestion) q).getOptions().get(0).getText(), "True");
        assertEquals("Correct answer text", ((SingleChoiceQuestion) q).getOptions().get(1).getText(), "False");
    }

    @Test
	public void testGetQuestionChoiceCorrupt1() {
        String questionData = "S";
        try {
            QuestionFactory.getQuestion(questionData);
            fail("Fail invalid data in question");
        } catch (InvalidQuestionDataException e) {
            
        }
    }

    @Test
	public void testGetQuestionChoiceCorrupt2() {
        String questionData = "S, Canada met its goal for number of medals at the Rio Olympics., 2, True, correct, False";
        try {
            QuestionFactory.getQuestion(questionData);
            fail("Fail invalid data in question");
        } catch (InvalidQuestionDataException e) {
            
        }
    }

    @Test
	public void testGetQuestionChoiceCorrupt3() {
        String questionData = "S, Canada met its goal for number of medals at the Rio Olympics.";
        try {
            QuestionFactory.getQuestion(questionData);
            fail("Fail invalid data in question");
        } catch (InvalidQuestionDataException e) {
            
        }
    }
}
