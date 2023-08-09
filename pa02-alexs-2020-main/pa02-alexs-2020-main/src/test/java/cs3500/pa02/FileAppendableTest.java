package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa02.writer.FileAppendable;
import cs3500.pa02.writer.Writer;
import cs3500.pa02.writer.WriterImp;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test for FileAppendable
 */

public class FileAppendableTest {
  private FileAppendable fileApp;
  private File testFile;
  /**
   * Create new instances
   */

  @BeforeEach
  public void setUp() throws IOException {
    testFile = new File("src/test/testFiles/test.txt");
    testFile.setWritable(true);
    fileApp = new FileAppendable(testFile);
  }
  /**
   * Test write method
   */

  @Test
  public void testWrite() throws IOException {

    // Invoke the write method with a test value
    String testValue = "hi";
    fileApp.write(testValue);

    // Read contents of  file
    try (FileReader reader = new FileReader(testFile)) {
      Scanner fileInfo = new Scanner(testFile);
      String data = fileInfo.nextLine().substring(0, 2);
      assertEquals(testValue, data);
    }
    testFile.setReadOnly(); //trigger exception
    assertThrows(IllegalArgumentException.class,  () -> fileApp.write("hi"));
  }
  /**
   * Test appending
   */

  @Test
  public void testAppend() throws IOException {
    FileAppendable testFa = new FileAppendable(testFile);
    CharSequence csq = "hello";
    //test append
    Appendable result = testFa.append(csq);
    Appendable result2 = testFa.append(csq, 1, 2);
    Appendable result3 = testFa.append('#');
    assertSame(FileAppendable.class, result.getClass());
    assertSame(FileAppendable.class, result2.getClass());
    assertSame(FileAppendable.class, result3.getClass());
  }
}
