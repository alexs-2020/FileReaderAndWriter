package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.fileVisit.FileInfo;
import cs3500.pa02.reader.Questions;
import cs3500.pa02.reader.Reader;
import cs3500.pa02.reader.ReaderImp;
import cs3500.pa02.reader.Texts;
import java.io.StringReader;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
/**
 * Testing for ReaderImp class
 */

public class ReaderImpTest {
  @Test
  void testFileReader() {
    FileInfo file2 = new FileInfo("C:\\Users\\alexs\\IdeaProjects\\pa02-alexs-2020\\src\\test\\testFiles\\testInput.md",
        "2023-5-15", "2023-5-14");
    Texts testText = new Texts("# Hello", "\n - There");
    ArrayList<FileInfo> sampleArr = new ArrayList<>();
    sampleArr.add(file2);
    ArrayList<Texts> listTexts = new ArrayList<>();
    listTexts.add(testText);

    ReaderImp fr = new ReaderImp(sampleArr); //start file storage
    fr.readFile();

    assertEquals(testText.toString(), fr.getTexts().get(0).toString());
    testText = new Texts("# Sir", "\n - two or more lines");
    assertEquals(testText.toString(), fr.getTexts().get(1).toString());
    Questions testQuestion = new Questions("this is", "a question", true);
    assertEquals(testQuestion.toString(), fr.getListQuestions().get(0).toString());
  }

  @Test
  void testSrReader() {
    ReaderImp srTest = new ReaderImp("C:\\Users\\alexs\\IdeaProjects\\pa02-alexs-2020\\src\\test\\testFiles\\sampleSr.sr");
    srTest.readSrFile();
    ArrayList<Questions> questionsFromTestFile = srTest.getListQuestions();
    Questions comparator = new Questions("Question", " Answer", false);
    assertEquals(comparator.toString(), questionsFromTestFile.get(0).toString());
  }
}


