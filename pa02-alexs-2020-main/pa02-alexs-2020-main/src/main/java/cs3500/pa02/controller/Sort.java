package cs3500.pa02.controller;

import cs3500.pa02.fileVisit.FileInfo;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Sorts ArrayList by chosen manner
 *
 */

public class Sort {

  private String method; //sort method
  private final ArrayList<FileInfo> files; // arraylist to sort
  /**
   * Sorts arraylist by given method
   *
   * @param sortMethod - Method of how to sort
   * @param inFiles - ArrayList of files data
   */

  public Sort(String sortMethod, ArrayList<FileInfo> inFiles) {
    method = sortMethod.toLowerCase();
    files = inFiles;
  }
  /**
   * Sorts arraylist accordingly
   *
   * @returns files - ArrayList of files data sorted
   */

  public ArrayList<FileInfo> sort() {
    String fileName1 = " ";
    String fileName2 = " ";
    FileInfo temp;
    for (int i = 0; i < files.size(); i++) {
      for (int j = i + 1; j < files.size(); j++) {
        if (Objects.equals(method, "filename")) {
          fileName1 = files.get(i).getFileName()
              .substring(files.get(i).getFileName().lastIndexOf('\\') + 1);
          fileName2 = files.get(j).getFileName()
              .substring(files.get(j).getFileName().lastIndexOf('\\') + 1);
          if (fileName1.compareTo(fileName2) > 0) {
            temp = files.get(i);
            files.set(i, files.get(j));
            files.set(j, temp);
          }
        } else if (Objects.equals(method, "created")) {
          fileName1 = files.get(i).getDateCreated();
          fileName2 = files.get(j).getDateCreated();
          if (fileName2.compareTo(fileName1) > 0) {
            temp = files.get(i);
            files.set(i, files.get(j));
            files.set(j, temp);
          }
        } else if (Objects.equals(method, "modified")) {
          fileName1 = files.get(i).getLastAccessed();
          fileName2 = files.get(j).getLastAccessed();
          if (fileName2.compareTo(fileName1) > 0) {
            temp = files.get(i);
            files.set(i, files.get(j));
            files.set(j, temp);
          }
        }
      }
    }
    return files;
  }
}