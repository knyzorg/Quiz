/**
 * 
 */
package vknyazev_B31_A01_Quiz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author slava
 *
 */
public class QuizRunner {

	ArrayList<Question> questions = new ArrayList<Question>();
	int correctCount = 0;
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
				try {
					Question q = QuestionFactory.getQuestion(reader.nextLine());
					questions.add(q);
				} catch (InvalidQuestionDataException e) {
					System.err.println("Corrupt question. Skipping.");
				}
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			System.exit(1);
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
				this.correctCount++;
			} else {
				System.out.println("Incorrect");
			}
		}
		kb.close();
	}

	private void end() {
		System.out.println(username + ", you score was " + correctCount + " out of " + questions.size() + ", or " +  Math.floor((double) correctCount/questions.size()*100) + "%");
		System.out.println("Goodbye.");
		try {
			FileWriter fw = new FileWriter(new File("quizScores.txt"), true);
			fw.write(String.format("%-30s%3d%%\n", username, Math.floor((double) correctCount/questions.size()*100)));
			fw.close();
		} catch (IOException e) {
			System.err.println("Failed to write to file: " + e);
		}
		
	}


}
