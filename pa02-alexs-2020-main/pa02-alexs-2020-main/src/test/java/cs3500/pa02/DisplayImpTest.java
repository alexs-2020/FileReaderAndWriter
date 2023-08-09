package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.display.Display;
import cs3500.pa02.display.DisplayImp;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

/**
 * Test for DisplayImp class
 */

public class DisplayImpTest {
  /**
   * Test for Display
   */
  @Test
  public void testinput() {
    String testInput = "1";
    ByteArrayInputStream testIn;
    testIn = new ByteArrayInputStream(testInput.getBytes());
    System.setIn(testIn);
    Display view = new DisplayImp();
    assertEquals(1, view.getUserInput(" "));
  }

}
