package cs3500.pa02.fileVisit;

/**
 * Represents the important info about a file
 *
 */

public class FileInfo {
  private String fileName;
  private String dateCreated;
  private String lastAccessed;
  /**
   * Project entry point
   *
   * @param fileName - name of file
   * @param dateCreated - file creation date
   * @param lastAccessed - date of last time file was modified
   */

  public FileInfo(String name, String created, String access) {
    fileName = name;
    dateCreated = created;
    lastAccessed = access;
  }

  /**
   * Getter for name of file
   *
   * @return fileName - name of file
   */

  public String getFileName() {
    return fileName;
  }
  /**
   * Getter for date created of file
   *
   * @return dateCreated - file creation date
   */

  public String getDateCreated() {
    return dateCreated;
  }
  /**
   * Getter for name of lastAccessed
   *
   * @return lastAccessed - file last modified date
   */

  public String getLastAccessed() {
    return lastAccessed;
  }
}
