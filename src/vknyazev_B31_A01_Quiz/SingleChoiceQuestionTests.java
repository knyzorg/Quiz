package vknyazev_B31_A01_Quiz;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SingleChoiceQuestionTests {

    @Test
        public void testCheckAnswerCorrect() {
                QuestionOption correct = new QuestionOption("Correct Answer", true);
                QuestionOption incorrect = new QuestionOption("Incorrect Answer", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct);
                options.add(incorrect);

                SingleChoiceQuestion q = new SingleChoiceQuestion("Question", options);
                assertTrue("Identifies incorrect answer", q.checkAnswer("1"));
        }

        @Test
            public void testCheckAnswerIncorrect() {
                    QuestionOption correct = new QuestionOption("Correct Answer", true);
                    QuestionOption incorrect = new QuestionOption("Incorrect Answer", false);
                    ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                    options.add(correct);
                    options.add(incorrect);
    
                    SingleChoiceQuestion q = new SingleChoiceQuestion("Question", options);
                    assertTrue("Identifies incorrect answer", !q.checkAnswer("2"));
            }

        @Test
        public void testCheckAnswerOutOfBounds() {
                QuestionOption correct = new QuestionOption("Correct Answer", true);
                QuestionOption incorrect = new QuestionOption("Incorrect Answer", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct);
                options.add(incorrect);

                SingleChoiceQuestion q = new SingleChoiceQuestion("Question", options);
                assertTrue("Out of Bound answer", !q.checkAnswer("10"));
                assertTrue("Negative answer", !q.checkAnswer("-1"));
        }

        @Test
        public void testCheckAnswerNoAnswer() {
                SingleChoiceQuestion q = new SingleChoiceQuestion();
                assertTrue("No options", !q.checkAnswer("1"));
        }

        @Test
        public void testCheckAnswerMalformedAnswer() {
                QuestionOption correct1 = new QuestionOption("Correct Answer 1", true);
                QuestionOption correct2 = new QuestionOption("Correct Answer 2", true);
                QuestionOption incorrect1 = new QuestionOption("Incorrect Answer 1", false);
                QuestionOption incorrect2 = new QuestionOption("Incorrect Answer 2", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct1);
                options.add(correct2);
                options.add(incorrect1);
                options.add(incorrect2);

                SingleChoiceQuestion q = new SingleChoiceQuestion("Question", options);
                assertTrue("Malformed answer", !q.checkAnswer("abc"));
        }

}
