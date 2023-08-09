package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.reader.Questions;
import cs3500.pa02.reader.Texts;
import cs3500.pa02.study.MakeNotes;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * TTest for MakeNotes class
 */

public class MakeNotesTest {
  @Mock
  private Appendable mockAppendable;

  /**
   * Testing the MakeMdNotes method
   */

  @Test
  public void testMakeMdNotes() throws IOException {
    // Create an ArrayList of Texts objects
    ArrayList<Texts> notesToAdd = new ArrayList<>();
    notesToAdd.add(new Texts("First", "info"));
    notesToAdd.add(new Texts("Second", "More info"));
    StringWriter outDir = new StringWriter();
    MakeNotes yourClass = new MakeNotes();
    yourClass.makeMdNotes(notesToAdd, outDir);
    String expectedOutput = "First\ninfo\nSecond\nMore info\n";
    assertEquals(expectedOutput, outDir.toString());
  }

  /**
   * Testing the MakeSrNotes method
   */

  @Test
  public void testMakeSrNotes() {
    ArrayList<Questions> questionsToAdd = new ArrayList<>();
    questionsToAdd.add(new Questions("who founded america", "Micheal Jackson", true));
    StringWriter outDir = new StringWriter();
    MakeNotes yourClass = new MakeNotes();
    yourClass.makeSrNotes(questionsToAdd, outDir);

    String expectedOutput = "who founded america # Micheal Jackson\ntrue\n";
    assertEquals(expectedOutput, outDir.toString());

  }
}
