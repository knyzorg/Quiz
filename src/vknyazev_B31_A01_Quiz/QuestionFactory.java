/**
 * 
 */
package vknyazev_B31_A01_Quiz;

import java.util.*;

/**
 * @author slava
 *
 */
public class QuestionFactory {
    public static Question getQuestion(String questionData) {
        // Must use Scanner instead of StringTokenizer as multiple characters in
        // sequence are used
        Scanner st = new Scanner(questionData);
        st.useDelimiter(", ");
    
        // Identify question type
        char questionType = st.next().toUpperCase().charAt(0);
        Question q = null;
        switch (questionType) {
        case 'F':
            q = makeFillInQuestion(st);
            break;
        case 'N':
            q = makeNumericQuestion(st);
            break;
        case 'S':
            q = makeSingleChoiceQuestion(st);
            break;
        case 'M':
            q = makeMultiChoiceQuestion(st);
            break;
        default:
            st.close();
            throw new InvalidQuestionDataException(questionType + " is not a valid question type.");
        }
        return q;
    }

    private static NumericQuestion makeNumericQuestion(Scanner st) {
        try {

            String question = st.next();
            double answer = st.nextDouble();
            return new NumericQuestion(question, answer);
        } catch (NoSuchElementException e) {
            throw new InvalidQuestionDataException();
        }
    }

    private static SingleChoiceQuestion makeSingleChoiceQuestion(Scanner st) {
        return makeChoiceQuestion(st, false);
    }

    private static MultiChoiceQuestion makeMultiChoiceQuestion(Scanner st) {
        // Can safely cast
        return (MultiChoiceQuestion) makeChoiceQuestion(st, true);
    }

    private static SingleChoiceQuestion makeChoiceQuestion(Scanner st, boolean multiple) {

        try {

            String question = st.next();
            int optionCount = st.nextInt();
            ArrayList<QuestionOption> options = new ArrayList<QuestionOption>();

            for (int i = 0; i < optionCount; i++)
                options.add(new QuestionOption(st.next(), st.next().equals("correct")));

            return multiple ? new MultiChoiceQuestion(question, options) : new SingleChoiceQuestion(question, options);

        } catch (NoSuchElementException e) {
            throw new InvalidQuestionDataException();
        }
    }

    private static FillInQuestion makeFillInQuestion(Scanner st) {
        try {

            String rawQuestionText = st.next();
            int answerStart = rawQuestionText.indexOf('*');
            int answerEnd = rawQuestionText.lastIndexOf('*');

            // < 0 means there are no *, == means that there is only one, +1 == means that
            // the answer is empty
            if (answerStart < 0 || answerStart == answerEnd || answerStart + 1 == answerEnd)
                throw new InvalidQuestionDataException(
                        "A Fill-In-The-Blanks Question must contain an answer surrounded by *");

            String answer = rawQuestionText.substring(answerStart + 1, answerEnd);
            String question = rawQuestionText.replace("*" + answer + "*", "__________");

            return new FillInQuestion(question, answer);

        } catch (NoSuchElementException e) {
            throw new InvalidQuestionDataException();
        }

    }
}
