package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class DriverTest {
  /**
   * Testing inpout for driver
   */
  @Test
  void testDriver() throws IOException {
    String[] args = {};
    assertThrows(NoSuchElementException.class, () -> Driver.main(args));
    String [] args2 = {"sampleInput\\", "filename", "output\\output"};
    Driver.main(args2);
    String [] args3 = {"something"};
    assertThrows(IllegalArgumentException.class, () -> Driver.main(args3));
  }
}