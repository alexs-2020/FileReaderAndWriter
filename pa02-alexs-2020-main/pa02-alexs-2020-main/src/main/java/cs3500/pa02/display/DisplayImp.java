package cs3500.pa02.display;

import java.util.Scanner;

/**
 * Implementation of the display interface
 */
public class DisplayImp implements Display {
  private Scanner input;
  /**
   * Displays begin session
   */

  public void displayPreface() {
    System.out.println("Welcome");
  }
  /**
   * Displays a provided string
   * @param prompt The string to be displayed
   */

  public void displayPrompt(String prompt) {
    System.out.println(prompt);
  }
  /**
   * Prints provided string and saves user input
   * @param prompt Sttring provided
   * @return string user input
   */

  public String getInputFile(String prompt) {
    System.out.println(prompt);
    input = new Scanner(System.in);
    String response = input.nextLine();
    return response;
  }
  /**
   * Prints provided string and saves user input as int
   * @param prompt Sttring provided
   * @return int Given by user
   */

  public int getUserInput(String prompt) {
    System.out.println(prompt);
    input = new Scanner(System.in);
    return input.nextInt();
  }
  /**
   * Prints out the concluding message after studying
   * @param numQ Number of questions
   * @param ezToHard  Number of questions changed from easy to hard
   * @param hardToEz Number of questions changed from hard to easy
   * @param numHard Number of hard questions
   * @param numEasy Number of easy questions
   */

  public void displayStudyResults(int numQ, int ezToHard, int hardToEz, int numHard, int numEasy) {
    System.out.println("You answered " + numQ + " question with \n"
        + ezToHard + " question changed from easy to hard \n" + hardToEz + " changed "
        + "from hard to eazy \n" + "there are " + numHard + " total hard questions and \n" + numEasy
        + " total easy questions \n");
  }
}
