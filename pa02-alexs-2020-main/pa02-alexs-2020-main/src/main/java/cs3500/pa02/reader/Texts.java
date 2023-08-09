package cs3500.pa02.reader;

/**
 * Creates object for important data from file
 *
 */

public class Texts {
  private final String line;
  private final String data;
  /**
   * Stores important information
   *
   * @param title - Title/ heading of important data
   * @param subData - buillet points according to the header
   */

  public Texts(String title, String subData) {
    this.line = title;
    this.data = subData;
  }

  public String toString() {
    return this.line + "\n" + this.data + "\n";
  }
}
