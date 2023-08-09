package cs3500.pa02.display;

public interface Display {

  public void displayPreface();

  public String getInputFile(String prompt);

  public int getUserInput(String prompt);

  public void displayPrompt(String prompt);

  public void displayStudyResults(int numQ, int ezToHard, int hardToEz, int numHard, int numEasy);
}
