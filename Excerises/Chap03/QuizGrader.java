/**
* @author Tommy
* Chapter 3
*
* <p>
* Student quiz grader from Chapt 3.
* Also did some JavaDoc practice
* </p>
*
* @param QuizGrader C A C C B C C X
*/

public class QuizGrader {

  // Static - Answer Key
  static private final String[] answerKey = {"C", "A", "B", "D", "B", "C", "C", "A"};
  static private final int minPassingGrade = 5;


  // Instance Variables - Submission
  private int numberOfCorrectAnswers;
  private int numberOfUnanswered;


  // Entry Point
  public static void main(String[] args) {

    // Safety Checks
    if (args.length < answerKey.length) {
      System.out.println("Too Few Inputs... Aborting...");
      return;
    }
    else if (args.length > answerKey.length) {
      System.out.println("Too Many Inputs... Aborting...");
      return;
    }

    // Make new Quiz Object
    QuizGrader myQuiz = new QuizGrader();

    // Print Headers
    System.out.printf("%1s", "Question");
    System.out.printf("%16s", "Submitted Ans.");
    System.out.printf("%16s", "Correct Ans.");
    System.out.printf("%16s", "Result");
    System.out.println("");


    // Iterate Over args / answer key
    for (int i=0; i < answerKey.length; i++) {

      // Print Questions / Answers
      System.out.printf("%4s", (i + 1));
      System.out.printf("%16s", args[i]);
      System.out.printf("%16s", answerKey[i]);

      // Grade Current Question
      if (args[i].equals("X")) {
        System.out.printf("%20s", ResultKey.UNANSWERED);
        myQuiz.numberOfUnanswered++;
      }
      else if ( args[i].equals(answerKey[i]) ) {
        System.out.printf("%20s", ResultKey.CORRECT);
        myQuiz.numberOfCorrectAnswers++;
      }
      else {
        System.out.printf("%20s", ResultKey.WRONG);
      }

      System.out.println("");

    }

    // Provide Results
    System.out.println("No. of correct answers: " + myQuiz.numberOfCorrectAnswers);
    System.out.println("No. of wrong answers: " + (answerKey.length -  myQuiz.numberOfCorrectAnswers - myQuiz.numberOfUnanswered) );
    System.out.println("No. of questions unanswered: " + myQuiz.numberOfUnanswered);

    // Passed or Failed
    if (myQuiz.numberOfCorrectAnswers >= minPassingGrade) {
      System.out.println("The candidate PASSED.");
    }
    else {
      System.out.println("The candidate FAILED.");
    }

  }

}