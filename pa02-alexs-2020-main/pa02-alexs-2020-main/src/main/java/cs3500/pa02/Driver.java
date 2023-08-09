package cs3500.pa02;

import cs3500.pa02.controller.ControlGenerateFiles;
import cs3500.pa02.controller.ControlStudy;
import cs3500.pa02.controller.Controller;
import java.io.IOException;
import java.io.StringReader;


/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Main of program
   * @param args three string inputs representing search directory,
   * sort keyword and output directory. OUTPUT DIRECTORY MUST NOT CONTAIN THE FILE TYPE EXTENSION (ex. directory/filename)
   * @param null  No arguments means user wants to start study session
   */
  public static void main(String[] args) throws IOException {
    if (args.length == 0) {
      Controller controller = new ControlStudy();
      controller.run();
    } else if (args.length == 3) {
      Readable input = new StringReader(args[0]);
      String order = args[1];
      Appendable output = new StringBuilder();
      output.append(args[2]); //change to 2
      Controller controller = new ControlGenerateFiles(input, order, output);
      controller.run();
    } else {
      throw new IllegalArgumentException("Invalid number of args");
    }

  }
}