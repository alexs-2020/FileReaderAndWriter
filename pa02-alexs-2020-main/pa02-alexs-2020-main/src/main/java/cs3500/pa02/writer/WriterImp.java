package cs3500.pa02.writer;

import java.io.IOException;
import java.util.Objects;

public class WriterImp implements Writer {
  private final Appendable appendable;

  public WriterImp(Appendable appendable) {
    this.appendable = Objects.requireNonNull(appendable);
  }

  @Override // @Override since it's from the interface
  public void write(String phrase) {
    try {
      appendable.append(phrase); // this may fail, hence the try-catch
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }


}
