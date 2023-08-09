package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.controller.Sort;
import cs3500.pa02.fileVisit.FileInfo;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Testing for Sort class
 */

public class SortTest {
  @Test
  public void sort() {
    ArrayList<FileInfo> files = new ArrayList<>();
    FileInfo file1 = new FileInfo("atbeg", "2023-5-13", "2023-5-15");
    FileInfo file2 = new FileInfo("inMid", "2023-5-15", "2023-5-14");
    FileInfo file3 = new FileInfo("third", "2023-5-12", "2023-5-13");
    files.add(file1);
    files.add(file3);
    files.add(file2);
    Sort byName = new Sort("filename", files);
    Sort byCreated = new Sort("created", files);
    Sort byAccessed = new Sort("modified", files);
    ArrayList<FileInfo> sortedByName = new ArrayList<>();
    sortedByName.add(file1);
    sortedByName.add(file2);
    sortedByName.add(file3);
    ArrayList<FileInfo> sortedByCreated = new ArrayList<>();
    sortedByCreated.add(file2);
    sortedByCreated.add(file1);
    sortedByCreated.add(file3);
    ArrayList<FileInfo> sortedByModified = new ArrayList<>();
    assertEquals(sortedByName, byName.sort());
    assertEquals(byCreated.sort(), sortedByCreated);
    assertEquals(byAccessed.sort(), files);
  }
}
