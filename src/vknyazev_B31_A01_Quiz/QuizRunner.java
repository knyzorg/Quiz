/**
 * 
 */
package vknyazev_B31_A01_Quiz;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;;

/**
 * @author slava
 *
 */
public class QuizRunner {

	ArrayList<Question> questions = new ArrayList<Question>();
	ArrayList<String> answers = new ArrayList<String>();
	String username;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new QuizRunner(new File("quizQuestions.txt"));
	}

	public QuizRunner(File questionsFile) {
		try {
			Scanner reader = new Scanner(questionsFile);
			while (reader.hasNext()) {
				Question q = QuestionFactory.getQuestion(reader.nextLine());
				questions.add(q);
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
		begin();
		end();
	}

	private void begin() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to Heritage’s Quiz Program.  Reading in questions from the file quizQuestions.txt");
		System.out.println("Please enter your name: ");
		this.username = kb.nextLine();
		for (Question question: this.questions) {
			System.out.println("Question: ");
			System.out.println(question.getPrompt());
			System.out.print("Answer => ");
			String answer = kb.nextLine();
			if (question.checkAnswer(answer)) {
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect");
			}
		}
		kb.close();
	}

	private void end() {

	}


}
