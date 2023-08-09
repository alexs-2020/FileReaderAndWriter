package cs3500.pa02;

import java.io.IOException;

/**
 * Makes sure inputs are read and failures handled correctly
 *
 */

public class MockAppendable implements Appendable {

  private void throwInOut() throws IOException {
    throw new IOException("Mock throwing an error");
  }

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throwInOut();
    return null;
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throwInOut();
    return null;
  }

  @Override
  public Appendable append(char c) throws IOException {
    throwInOut();
    return null;
  }

}
