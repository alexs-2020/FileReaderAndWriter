package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa02.controller.ControlStudy;
import cs3500.pa02.controller.Controller;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

/**
 * Test for ControlStudy Class
 */
public class ControlStudyTest {
  /**
   * Test for controller study session
   */
  @Test
  public void testControl() {
    Controller controller = new ControlStudy();
    String testInput =  "notSRfile.txt";
    ByteArrayInputStream testIn;
    testIn = new ByteArrayInputStream(testInput.getBytes());
    System.setIn(testIn);
    assertThrows(IllegalArgumentException.class, () -> controller.run());
  }
}
