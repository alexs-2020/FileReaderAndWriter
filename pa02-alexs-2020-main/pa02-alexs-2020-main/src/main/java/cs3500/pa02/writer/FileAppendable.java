package cs3500.pa02.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class FileAppendable implements Appendable {
  File file;

  //creates a new file to write to
  public FileAppendable(File file) {
    this.file = Objects.requireNonNull(file);
  }

  //write string to given file
  public void write(String value) {
    try (FileWriter writer = new FileWriter(this.file, true)) {
      writer.write(value);
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    write(String.valueOf(csq));
    return this;
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    write(String.valueOf(csq).substring(start, end));
    return this;
  }

  @Override
  public Appendable append(char c) throws IOException {
    write(String.valueOf(c));
    return this;
  }

}
