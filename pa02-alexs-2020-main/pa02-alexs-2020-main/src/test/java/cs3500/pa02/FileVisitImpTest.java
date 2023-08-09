package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import cs3500.pa02.fileVisit.FileInfo;
import cs3500.pa02.fileVisit.FileVisitImp;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Testing for FileVisitImp class
 */

public class FileVisitImpTest {
  /**
   * Testing file visitor
   */
  @Test
  void testFileWalker() {
    Path startDir = Path.of("sampleInput/");
    FileVisitImp fw = new FileVisitImp(); //start file storage
    try {
      Files.walkFileTree(startDir, fw);
      ArrayList<FileInfo> allFiles = fw.getFileList(); //store files in arrayList
      assertEquals(2, allFiles.size(), "Incorrect number of files");
      Path another = Path.of("notRealDirectory/");
      assertEquals("notRealDirectory", Files.walkFileTree(another, fw).toString());
    } catch (IOException e) {
      fail("Failed to walk file tree.");
    }
  }
}
