package cs3500.pa02.study;

import cs3500.pa02.display.Display;
import cs3500.pa02.display.DisplayImp;
import cs3500.pa02.reader.Questions;
import java.util.ArrayList;
/**
 * Class ot start study session
 */

public class StudyGuideImp {
  private int numQuestions;
  private ArrayList<Questions> allQuestions;
  private ArrayList<Questions> hardQuestions = new ArrayList<>();
  private ArrayList<Questions> easyQuestions = new ArrayList<>();
  private ArrayList<Questions> studyQuestions = new ArrayList<>();

  /**
   * Constructor for class
   * @param numQs number of questions to study
   * @param questions list of all questions
   */

  public StudyGuideImp(int numQs, ArrayList<Questions> questions) {
    this.numQuestions = numQs;
    this.allQuestions = questions;
    organizeQuestions();
    this.studyQuestions = questionsToStudy();
  }
  /**
   * Method to seperate questions int hard and easy lists
   */

  public void organizeQuestions() {
    hardQuestions = new ArrayList<>();
    easyQuestions = new ArrayList<>();
    for (Questions question : this.allQuestions) {
      if (question.getHard()) {
        hardQuestions.add(question);
      } else {
        easyQuestions.add(question);
      }
    }
  }

  /**
   * Method to create list of the questions to study accordingly
   * @return questionToStudy arraylist of questions
   */

  public ArrayList<Questions> questionsToStudy() {
    ArrayList<Questions> generatedQuestions = new ArrayList<>();
    if (this.numQuestions <= hardQuestions.size()) {
      for (int i = 0; i < numQuestions; i++) {
        int index = (int) (Math.random() * hardQuestions.size()); //add in random order
        generatedQuestions.add(hardQuestions.get(index));
      }
    } else if (this.numQuestions >= this.allQuestions.size()) {
      for (int i = 0; i < this.allQuestions.size(); i++) {
        int index = (int) (Math.random() * hardQuestions.size());
        generatedQuestions.add(this.allQuestions.get(index));
      }
    } else {
      for (int i = 0; i < numQuestions; i++) {
        while (i < hardQuestions.size()) {
          int index = (int) (Math.random() * hardQuestions.size());
          generatedQuestions.add(hardQuestions.get(index));
        }
        int index = (int) (Math.random() * easyQuestions.size()); //add in random order
        generatedQuestions.add(easyQuestions.get(index));
      }
    }
    return generatedQuestions;
  }


  /**
   * method to start the study session
   */

  public void generateStudyArray() {
    int newIn = 0;
    int ezToHard = 0;
    int hardToEz = 0;
    Display view = new DisplayImp();
    for (Questions question : this.questionsToStudy()) {
      view.displayPrompt(question.getQuestion()); //display question
      newIn = view.getUserInput("Type 1 to display answer");
      if (newIn == 1) {
        System.out.println("The answer is " + question.getAnswer());
      }
      newIn = view.getUserInput("Type 1 if you would like to change the difficulty from "
          + question.getHard() + " to " + !question.getHard());
      if (newIn == 1) {
        if (question.getHard()) {
          hardToEz++;
        } else {
          ezToHard++;
        }
        question.setDif(!question.getHard());
      }
    }
    organizeQuestions();
    view.displayStudyResults(this.numQuestions, ezToHard, hardToEz,
        hardQuestions.size(), easyQuestions.size());
  }

  /**
   * Method to retrive updated list of questions
   * @return getAllQuestions list of all the questions updated after studying
   */
  public ArrayList<Questions> getAllQuestions() {
    return this.allQuestions;
  }
}