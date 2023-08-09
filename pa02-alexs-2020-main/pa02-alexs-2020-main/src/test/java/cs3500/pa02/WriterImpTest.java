package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa02.writer.Writer;
import cs3500.pa02.writer.WriterImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing for WriterImpt class
 */
public class WriterImpTest {
  private Appendable appendable;
  private Writer writer;

  // this is a constant whicb will not be changed (static and written in UPPER_SNAKE_CASE)
  private static final String VALUE = "input";

  @BeforeEach
  public void setUp() {
    this.appendable = new StringBuilder();
    this.writer = new WriterImp(this.appendable);
  }

  @Test
  public void testSuccess() {
    // check empty StringBuilder
    assertEquals("", this.appendable.toString());

    // write to it
    this.writer.write(VALUE);

    // check only that value appears in the StringBuilder
    assertEquals(VALUE, this.appendable.toString());
  }

  @Test
  public void testFailure() {
    this.writer = new WriterImp(new MockAppendable());
    Exception exc = assertThrows(RuntimeException.class,
        () -> this.writer.write(VALUE), "Mock throwing an error");
    assertEquals("Mock throwing an error", exc.getMessage());
  }
}
