package cs3500.pa02.fileVisit;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class FileVisitImp implements FileVisitor<Path>, FileVisit  {
  private final ArrayList<FileInfo> fileList = new ArrayList<>();
  //list of File info objects containing path, creation date, and last accessed date

  public ArrayList<FileInfo> getFileList() {
    return fileList;
  } //getter

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
    if (file.toString().endsWith(".md") && attrs.isRegularFile()) {
      FileInfo fileToAdd = new FileInfo(file.toString(),
          attrs.creationTime().toString(), attrs.lastAccessTime().toString());
      fileList.add(fileToAdd);
    }
    return CONTINUE;
  }

  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    System.out.println("Starting Directory " + dir);
    return CONTINUE;
  }

  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
    System.out.println("Ending Directory " + dir);
    return CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    System.err.println(exc);
    return CONTINUE;
  }


}
