package cs3500.pa02.controller;

import cs3500.pa02.display.Display;
import cs3500.pa02.display.DisplayImp;
import cs3500.pa02.reader.Questions;
import cs3500.pa02.reader.Reader;
import cs3500.pa02.reader.ReaderImp;
import cs3500.pa02.study.MakeNotes;
import cs3500.pa02.study.StudyGuideImp;
import cs3500.pa02.writer.FileAppendable;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Controller for Study session
 */

public class ControlStudy implements Controller {
  /**
   * Runs the controller
   */
  public void run() {
    Display view = new DisplayImp();
    view.displayPreface();
    String filePath = view.getInputFile("Please type the path of the .sr file to study -"
        + " for example Study\\myStudyGuide.sr");
    if (!filePath.endsWith(".sr")) {
      throw new IllegalArgumentException("please provided a sr file");
    }
    //start study session
    Reader fileReader = new ReaderImp(filePath);
    fileReader.readSrFile();
    ArrayList<Questions> questionsFromFile = fileReader.getListQuestions();
    int numQ = view.getUserInput("how many questions woudl you like to study?");
    StudyGuideImp practice = new StudyGuideImp(numQ, questionsFromFile);
    // start studying
    practice.generateStudyArray();
    // get implement changes from the study
    // update sr file
    ArrayList<Questions> test = practice.getAllQuestions();
    try {
      Files.delete(Path.of(filePath));
    } catch (Exception e) {
      System.err.println("File did not delete" + e);
    }
    Appendable srFile = new FileAppendable(new File(filePath));
    MakeNotes notes = new MakeNotes();
    notes.makeSrNotes(test, srFile);
  }
}

