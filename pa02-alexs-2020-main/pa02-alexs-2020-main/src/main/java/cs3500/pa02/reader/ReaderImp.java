package cs3500.pa02.reader;

import cs3500.pa02.fileVisit.FileInfo;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Implements the Reader interface
 */

public class ReaderImp implements Reader {
  private String tempFile;
  private final ArrayList<FileInfo> files;
  private final ArrayList<Texts> listTexts = new ArrayList<>();
  private final ArrayList<Questions> listQuestions = new ArrayList<>();
  /**
   * Constructor for reading list of files
   * @param file ArrayList of files
   */

  public ReaderImp(ArrayList<FileInfo> file) {
    this.files = file;
  }
  /**
   * Constructor for reading single file
   * @param file file to read
   */

  public ReaderImp(String file) {
    this.tempFile = file;
    this.files = null;

  }
  /**
   * Reads the provided files in the array list
   */

  public void readFile() {
    assert files != null;
    for (FileInfo file : files) {
      StringBuilder subData = new StringBuilder();
      Path theFile = Path.of(file.getFileName());
      Scanner fileInfo = null;
      try {
        fileInfo = new Scanner(theFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
      assert fileInfo != null;
      String title = fileInfo.nextLine();
      while (fileInfo.hasNext()) {
        String curLine = fileInfo.nextLine();
        if (curLine.contains("#")) {
          Texts singleLine = new Texts(title, subData.toString());
          listTexts.add(singleLine);
          subData = new StringBuilder(); //reset stringbuilder
          title = curLine;
        } else {
          if (curLine.contains("[[")) {
            if (curLine.contains("]]")) {
              subData.append("\n - " + curLine.substring(curLine.indexOf("[[") + 2, curLine.indexOf("]]")));
            } else {
              subData.append("\n - " + curLine.substring(curLine.indexOf("[[") + 2));
              curLine = fileInfo.nextLine();
              while (!curLine.contains("]]")) {
                subData.append(curLine);
                curLine = fileInfo.nextLine();
              }
              subData.append(" " + curLine, 0, curLine.indexOf("]]") + 1);
            }
          }
          if (subData.toString().contains(":::")) {
            String question = subData.substring(subData.lastIndexOf("-") + 2,
                subData.indexOf(":::"));
            String answer = subData.substring(subData.indexOf(":::") + 3, subData.length());
            Questions questionToAdd = new Questions(question, answer, true);
            listQuestions.add(questionToAdd);
            subData.delete(subData.lastIndexOf(" - ") - 1, subData.length());
          }
        }
      }
      Texts singleLine = new Texts(title, subData.toString());
      listTexts.add(singleLine);
    }
  }
  /**
   * Reads sr file
   */

  public void readSrFile() { //MAYBE CONFIRM SR FILE
    assert this.tempFile != null;
    Path theFile = Path.of(this.tempFile);
    Scanner fileInfo = null;
    try {
      fileInfo = new Scanner(theFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
    String question = "";
    String answer = "";
    boolean hard;
    while (fileInfo.hasNext()) {
      String curLine = fileInfo.nextLine();
      if (curLine.contains("#")) {
        question = curLine.substring(0, curLine.indexOf('#') - 1);
        answer = curLine.substring(curLine.indexOf("#") + 1);
      } else {
        hard = Boolean.parseBoolean(curLine);
        Questions questionFromFile = new Questions(question, answer, hard);
        listQuestions.add(questionFromFile);
      }

    }
  }

  /**
   * Getter for list of texts
   * @return listTexts list of texts stored after reading
   */

  public ArrayList<Texts> getTexts() {
    return listTexts;
  }

  /**
   * Getter for list of questions
   * @return listQuestions list of questions stored after reading
   */

  public ArrayList<Questions> getListQuestions() {
    return listQuestions;
  }
}
