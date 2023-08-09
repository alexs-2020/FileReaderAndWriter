package cs3500.pa02.controller;

import cs3500.pa02.fileVisit.FileInfo;
import cs3500.pa02.fileVisit.FileVisit;
import cs3500.pa02.fileVisit.FileVisitImp;
import cs3500.pa02.reader.Questions;
import cs3500.pa02.reader.Reader;
import cs3500.pa02.reader.ReaderImp;
import cs3500.pa02.study.MakeNotes;
import cs3500.pa02.writer.FileAppendable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import cs3500.pa02.reader.Texts;
import java.util.Objects;
import java.util.Scanner;

/**
 * this class controls the generation of md and sr files
 */
public class ControlGenerateFiles implements Controller {
  private Readable input;
  private String order;
  private Appendable output;
  private ArrayList<Texts> listTexts = new ArrayList<>();
  /**
   * Constructor for class
   * @param input This is the search directory
   * @param order  This is the sort order
   * @param output This is the output directory
   */

  public ControlGenerateFiles(Readable input, String order, Appendable output) {
    this.input = Objects.requireNonNull(input);
    this.output = Objects.requireNonNull(output);
    this.order = order;
    // Objects.requireNonNull will handle throwing an Exception
    // if the provided Appendable is null.
  }
  /**
   * Runs the program
   */

  public void run() {
    //got to get string from input
    Scanner inFile = new Scanner(input);
    String inFileString = inFile.nextLine();
    FileVisit fw = new FileVisitImp();
    Path searchDir = Path.of(inFileString);
    try {
      Files.walkFileTree(searchDir, fw); //get files
    } catch (IOException e) {
      System.err.println(e);
    }
    ArrayList<FileInfo> allFiles = fw.getFileList(); //store files in arrayList
    //END OF GETTING MD FILES
    //BEGIN SORT
    Sort tempList = new Sort(this.order, allFiles);
    allFiles = tempList.sort(); //sort files
    //END SORT
    //Start file READ
    Reader fileReader = new ReaderImp(allFiles);
    fileReader.readFile();
    listTexts = fileReader.getTexts();
    ArrayList<Questions> allQuestions = new ArrayList<>(); //temporary
    allQuestions = fileReader.getListQuestions();
    //end file read
    // Write notes
    String mdOutput = this.output + ".md";
    String srOutput = this.output + ".sr";
    Path pathmd = Paths.get(mdOutput);
    Path pathsr = Paths.get(srOutput);
    if (Files.exists(pathmd)) {
      try {
        Files.delete(pathmd);
      } catch (Exception e) {
        System.err.println("File did not delete" + e);
      }
    }
    if (Files.exists(pathsr)) {
      try {
        Files.delete(pathsr);
      } catch (Exception e) {
        System.err.println("File did not delete" + e);
      }
    }
    Appendable mdFile = new FileAppendable(new File(mdOutput));
    MakeNotes writeToNotes = new MakeNotes();
    writeToNotes.makeMdNotes(listTexts, mdFile);
    Appendable srFile = new FileAppendable(new File(srOutput));
    writeToNotes.makeSrNotes(allQuestions, srFile);
  }
}
