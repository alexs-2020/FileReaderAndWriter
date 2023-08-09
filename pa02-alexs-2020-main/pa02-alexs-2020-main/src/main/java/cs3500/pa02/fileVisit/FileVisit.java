package cs3500.pa02.fileVisit;

import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.util.ArrayList;

public interface FileVisit extends FileVisitor<Path> {

  ArrayList<FileInfo> getFileList();
}
