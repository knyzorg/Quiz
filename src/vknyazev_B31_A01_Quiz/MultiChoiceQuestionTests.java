package vknyazev_B31_A01_Quiz;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MultiChoiceQuestionTests {

        @Test
        public void testCheckAnswerCorrect() {
                QuestionOption correct = new QuestionOption("Correct Answer", true);
                QuestionOption incorrect = new QuestionOption("Incorrect Answer", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct);
                options.add(incorrect);

                MultiChoiceQuestion q = new MultiChoiceQuestion("Question", options);
                assertTrue("Identifies correct answer", q.checkAnswer("1"));
        }

        @Test
        public void testCheckAnswerIncorrect() {
                QuestionOption correct = new QuestionOption("Correct Answer", true);
                QuestionOption incorrect = new QuestionOption("Incorrect Answer", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct);
                options.add(incorrect);

                MultiChoiceQuestion q = new MultiChoiceQuestion("Question", options);
                assertTrue("Identifies incorrect answer", !q.checkAnswer("2"));
        }

        @Test
        public void testCheckAnswerOutOfBounds() {
                QuestionOption correct = new QuestionOption("Correct Answer", true);
                QuestionOption incorrect = new QuestionOption("Incorrect Answer", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct);
                options.add(incorrect);

                MultiChoiceQuestion q = new MultiChoiceQuestion("Question", options);
                assertTrue("Out of Bound answer", !q.checkAnswer("10"));
                assertTrue("Negative answer", !q.checkAnswer("-1"));
        }

        @Test
        public void testCheckAnswerNoAnswer() {
                MultiChoiceQuestion q = new MultiChoiceQuestion();
                assertTrue("No options", !q.checkAnswer("1"));
        }
        @Test
        public void testCheckAnswerMultipleCorrect() {
                QuestionOption correct1 = new QuestionOption("Correct Answer 1", true);
                QuestionOption correct2 = new QuestionOption("Correct Answer 2", true);
                QuestionOption incorrect1 = new QuestionOption("Incorrect Answer 1", false);
                QuestionOption incorrect2 = new QuestionOption("Incorrect Answer 2", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct1);
                options.add(correct2);
                options.add(incorrect1);
                options.add(incorrect2);

                MultiChoiceQuestion q = new MultiChoiceQuestion("Question", options);
                assertTrue("Identifies correct answers", q.checkAnswer("1,2"));
        }
        
        @Test
        public void testCheckAnswerMultipleIncorrect() {
                QuestionOption correct1 = new QuestionOption("Correct Answer 1", true);
                QuestionOption correct2 = new QuestionOption("Correct Answer 2", true);
                QuestionOption incorrect1 = new QuestionOption("Incorrect Answer 1", false);
                QuestionOption incorrect2 = new QuestionOption("Incorrect Answer 2", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct1);
                options.add(correct2);
                options.add(incorrect1);
                options.add(incorrect2);

                MultiChoiceQuestion q = new MultiChoiceQuestion("Question", options);
                assertTrue("Identifies incorrect answers", !q.checkAnswer("3, 4"));
        }

        
        @Test
        public void testCheckAnswerMultiplePartial() {
                QuestionOption correct1 = new QuestionOption("Correct Answer 1", true);
                QuestionOption correct2 = new QuestionOption("Correct Answer 2", true);
                QuestionOption incorrect1 = new QuestionOption("Incorrect Answer 1", false);
                QuestionOption incorrect2 = new QuestionOption("Incorrect Answer 2", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct1);
                options.add(correct2);
                options.add(incorrect1);
                options.add(incorrect2);

                MultiChoiceQuestion q = new MultiChoiceQuestion("Question", options);
                assertTrue("Partial answer", !q.checkAnswer("1,3"));
        }

        
        @Test
        public void testCheckAnswerRepeated() {
                QuestionOption correct1 = new QuestionOption("Correct Answer 1", true);
                QuestionOption correct2 = new QuestionOption("Correct Answer 2", true);
                QuestionOption incorrect1 = new QuestionOption("Incorrect Answer 1", false);
                QuestionOption incorrect2 = new QuestionOption("Incorrect Answer 2", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct1);
                options.add(correct2);
                options.add(incorrect1);
                options.add(incorrect2);

                MultiChoiceQuestion q = new MultiChoiceQuestion("Question", options);
                assertTrue("Partial answer", !q.checkAnswer("1,1"));
        }
        
        @Test
        public void testCheckAnswerMissingAnswer() {
                QuestionOption correct1 = new QuestionOption("Correct Answer 1", true);
                QuestionOption correct2 = new QuestionOption("Correct Answer 2", true);
                QuestionOption incorrect1 = new QuestionOption("Incorrect Answer 1", false);
                QuestionOption incorrect2 = new QuestionOption("Incorrect Answer 2", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct1);
                options.add(correct2);
                options.add(incorrect1);
                options.add(incorrect2);

                MultiChoiceQuestion q = new MultiChoiceQuestion("Question", options);
                assertTrue("Partial answer", !q.checkAnswer("1"));
        }

        @Test
        public void testCheckAnswerExtraAnswer() {
                QuestionOption correct1 = new QuestionOption("Correct Answer 1", true);
                QuestionOption correct2 = new QuestionOption("Correct Answer 2", true);
                QuestionOption incorrect1 = new QuestionOption("Incorrect Answer 1", false);
                QuestionOption incorrect2 = new QuestionOption("Incorrect Answer 2", false);
                ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();
                options.add(correct1);
                options.add(correct2);
                options.add(incorrect1);
                options.add(incorrect2);

                MultiChoiceQuestion q = new MultiChoiceQuestion("Question", options);
                assertTrue("Partial answer", !q.checkAnswer("1,2,1"));
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

                MultiChoiceQuestion q = new MultiChoiceQuestion("Question", options);
                assertTrue("Malformed answer", !q.checkAnswer("abc"));
        }

}
