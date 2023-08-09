package cs3500.pa02.reader;

import cs3500.pa02.fileVisit.FileInfo;
import java.util.ArrayList;

public interface Reader {
  //  String read();

  void readFile();

  ArrayList<Texts> getTexts();

  ArrayList<Questions> getListQuestions();

  void readSrFile();
}
