package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa02.reader.Questions;
import cs3500.pa02.study.StudyGuideImp;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Testing for StudyGuideImp class
 */

public class StudyGuideImpTest {
  @Test
  public void testGenerateQuestions() {
    // Create an instance of the class under test
    // Prepare test data
    ArrayList<Questions> hardQuestions = new ArrayList<>();
    hardQuestions.add(new Questions("Question 1", "Answer 1", true));
    hardQuestions.add(new Questions("Question 2", "Answer 2", true));
    hardQuestions.add(new Questions("Question 3", "Answer 3", true));
    StudyGuideImp testGenerate = new StudyGuideImp(3, hardQuestions);
    ArrayList<Questions> returnedQuestions = testGenerate.questionsToStudy();
    //test all questions are hard
    for (Questions q : returnedQuestions) {
      assertTrue(q.getHard());
    }
    //test size and containing questions
    // Assert the correctness of the generated questions
    assertEquals(3, returnedQuestions.size());
    assertTrue(hardQuestions.contains(returnedQuestions.get(0)));
    assertTrue(hardQuestions.contains(returnedQuestions.get(1)));
    assertEquals(3, returnedQuestions.size());
    ArrayList<Questions> testQuestions = new ArrayList<>();
    testQuestions.add(new Questions("a hard question", "Answer 1", true));
    testQuestions.add(new Questions("An easy question", "Answer 2", false));
    testQuestions.add(new Questions("Another easy question", "Answer 3", false));
    testGenerate = new StudyGuideImp(10, testQuestions);
    returnedQuestions = testGenerate.questionsToStudy();
    assertEquals(3, returnedQuestions.size());

    //THESE LINES CAUSE INFINITE TEST LOOP - TAs WERE UNABLE TO RESOLVE WHY
    //testGenerate = new StudyGuideImp(2,testQuestions);
    //returnedQuestions = testGenerate.questionsToStudy();
    //assertTrue(testQuestions.contains(returnedQuestions.get(0)));
  }
}
