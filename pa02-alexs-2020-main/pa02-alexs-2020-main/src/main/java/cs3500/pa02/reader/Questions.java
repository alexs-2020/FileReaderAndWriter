package cs3500.pa02.reader;

/**
 * Object to represent question and answer
 */

public class Questions {
  private final String question;
  private final String answer;
  private boolean hard;

  /**
   * COnstructor for object
   * @param q question
   * @param a  answer
   * @param hard boolean representing if the question is hard or not
   */

  public Questions(String q, String a, boolean hard) {
    this.question = q;
    this.answer = a;
    this.hard = hard;
  }
  /**
   * method to represent object as string
   * @return objects as string format
   */

  public String toString() {
    return this.question + " # " + this.answer + "\n" + this.hard + "\n";
  }
  /**
   * Getter for question
   * @return question
   */

  public String getQuestion() {
    return this.question;
  }
  /**
   * Getter for answer
   * @return answer
   */

  public String getAnswer() {
    return this.answer;
  }
  /**
   * Getter for hard
   * @return this.hard
   */

  public boolean getHard() {
    return this.hard;
  }
  /**
   * Setter for hard
   * @param in boolean to change hard to
   */

  public void setDif(boolean in) {
    this.hard = in;
  }
}
