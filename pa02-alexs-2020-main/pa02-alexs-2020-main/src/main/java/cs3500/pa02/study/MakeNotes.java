package cs3500.pa02.study;

import cs3500.pa02.reader.Questions;
import cs3500.pa02.reader.Texts;
import cs3500.pa02.writer.Writer;
import cs3500.pa02.writer.WriterImp;
import java.util.ArrayList;

/**
 * class to write to the file accordingly
 */
public class MakeNotes {
  /**
   * Writes to .md file
   * @param notesToAdd list of notes to write
   * @param outDir directory to write to
   */
  public void makeMdNotes(ArrayList<Texts> notesToAdd, Appendable outDir) {
    Writer writer = new WriterImp(outDir);
    for (Texts extractedText : notesToAdd) {  //write stored data to file
      writer.write(extractedText.toString());
    }
  }
  /**
   * Writes to .sr file
   * @param questions list of questions to write
   * @param outDir directory to write to
   */

  public void makeSrNotes(ArrayList<Questions> questions, Appendable outDir) {
    Writer writer = new WriterImp(outDir);
    for (Questions question : questions) {  //write stored data to file
      writer.write(question.toString());
    }
  }
}
