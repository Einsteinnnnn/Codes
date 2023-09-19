package FolderExplorer;
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Folder Explorer
// Course: CS 300 Fall 2021
//
// Author: Haozhe Wu
// Email: hwu435@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NA
// Online Sources: NA
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Arrays;

/**
 * The test method to test all the method in FolderExplorer class
 */
public class FolderExplorerTester {

  /**
   * The test method to test getContents().
   *
   * @param folder give a current Directory
   * @return return true if all the Scenario are correct
   */
  public static boolean testGetContents(File folder) {
    try {
      // Scenario 1
      // list the basic contents of the cs300 folder
      ArrayList<String> listContent = FolderExplorer.getContents(folder);
      // expected output must contain "exams preparation", "grades",
      // "lecture notes", "programs", "reading notes", "syllabus.txt",list
      // and "todo.txt" only.
      String[] contents = new String[] {"exams preparation", "grades", "lecture notes", "programs",
          "reading notes", "syllabus.txt", "todo.txt"};
      List<String> expectedList = Arrays.asList(contents);
      // check the size and the contents of the output
      if (listContent.size() != 7) {
        System.out.println("Problem detected: cs300 folder must contain 7 elements.");
        return false;
      }
      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of cs300 folder.");
          return false;
        }
      }
      // Scenario 2 - list the contents of the grades folder
      File f = new File(folder.getPath() + File.separator + "grades");
      listContent = FolderExplorer.getContents(f);
      if (listContent.size() != 0) {
        System.out.println("Problem detected: grades folder must be empty.");
        return false;
      }
      // Scenario 3 - list the contents of the p02 folder
      f = new File(folder.getPath() + File.separator + "programs" + File.separator + "p02");
      listContent = FolderExplorer.getContents(f);
      if (listContent.size() != 1 || !listContent.contains("FishTank.java")) {
        System.out.println(
            "Problem detected: p02 folder must contain only " + "one file named FishTank.java.");
        return false;
      }

      // Scenario 4 - List the contents of a file
      f = new File(folder.getPath() + File.separator + "todo.txt");
      try {
        listContent = FolderExplorer.getContents(f);
        System.out.println("Problem detected: Your FolderExplorer.getContents() must "
            + "throw a NotDirectoryException if it is provided an input which is not"
            + "a directory.");
        return false;
      } catch (NotDirectoryException e) { // catch only the expected exception
        // no problem detected
      }
      // Scenario 5 - List the contents of not found directory/file
      f = new File(folder.getPath() + File.separator + "music.txt");
      try {
        listContent = FolderExplorer.getContents(f);
        System.out.println("Problem detected: Your FolderExplorer.getContents() must "
            + "throw a NotDirectoryException if the provided File does not exist.");
        return false;
      } catch (NotDirectoryException e) {
        // behavior expected
      }
    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * The test method to test the base case of getDeepContents().
   *
   * @param folder give a current Directory
   * @return return true if all the Scenario are correct
   */
  public static boolean testDeepGetContentsBaseCase(File folder) {
    try {
      // Scenario 1
      // list the basic contents of the unit1 folder
      File f =
          new File(folder.getPath() + File.separator + "lecture notes" + File.separator + "unit1");
      ArrayList<String> listContent = FolderExplorer.getDeepContents(f);
      // expected output must contain "ExceptionHandling.txt", "proceduralProgramming.txt",
      // and "UsingObjects.txt" only.
      String[] contents =
          new String[] {"ExceptionHandling.txt", "proceduralProgramming.txt", "UsingObjects.txt"};
      List<String> expectedList = Arrays.asList(contents);
      // check the size and the contents of the output
      if (listContent.size() != 3) {
        System.out.println("Problem detected: unit1 folder must contain 3 elements.");
        return false;
      }
      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of unit1 folder.");
          return false;
        }
      }
    } catch (NotDirectoryException e) {
      // behavior expected
    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * The test method to test the recursive algorithm of getDeepContents().
   *
   * @param folder give a current Directory
   * @return return true if all the Scenario are correct
   */
  public static boolean testDeepListRecursiveCase(File folder) {
    try {
      // Scenario 1
      // list all the contents of the exams preparation folder
      File f = new File(folder.getPath() + File.separator + "exams preparation");
      ArrayList<String> listContent = FolderExplorer.getDeepContents(f);
      // expected output must contain "codeSamples.java" and "outline.txt".
      String[] contents = new String[] {"codeSamples.java", "outline.txt"};
      List<String> expectedList = Arrays.asList(contents);
      // check the size and the contents of the output
      if (listContent.size() != 2) {
        System.out.println("Problem detected: unit1 folder must contain 2 elements.");
        return false;
      }
      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of exams preparation folder.");
          return false;
        }
      }

      // Scenario 2
      // list all the contents of the programs folder
      f = new File(folder.getPath() + File.separator + "programs");
      listContent = FolderExplorer.getDeepContents(f);
      // expected output must contain "Program01.pdf", "Program02.pdf", "Program03.pdf",
      // "FishTank.java", "ExceptionalClimbing.java", "ExceptionalClimbingTester.java",
      // "ClimbingTracker.java", and "ClimbingTrackerTester.java".
      contents = new String[] {"Program01.pdf", "Program02.pdf", "Program03.pdf", "FishTank.java",
          "ExceptionalClimbing.java", "ExceptionalClimbingTester.java", "ClimbingTracker.java",
          "ClimbingTrackerTester.java"};
      expectedList = Arrays.asList(contents);
      // check the size and the contents of the output
      if (listContent.size() != 8) {
        System.out.println(
            "Problem detected: program folder and its sub-folders must contain 8 elements.");
        return false;
      }
      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of programs folder.");
          return false;
        }
      }
    } catch (NotDirectoryException e) {
      // behavior expected
    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * The test method to test lookupByFileName().
   *
   * @param folder give a current Directory
   * @return return true if all the Scenario are correct
   */
  public static boolean testLookupByFileName(File folder) {
    try {
      // Scenario 1 (with recursive)
      // list the path of the outline.txt with the start of cs300/
      String answer = FolderExplorer.lookupByName(folder, "outline.txt");
      // expected output must be "cs300/exams preparation/exam1/outline.txt".
      String expect = "cs300/exams preparation/exam1/outline.txt";

      if (!answer.equals(expect)) {
        System.out.println("Problem detected: The path is wrong");
        return false;
      }

      // Scenario 2 (without recursive -- base case)
      // list the path of the todo.txt with the start of cs300/
      answer = FolderExplorer.lookupByName(folder, "todo.txt");
      // expected output must be "cs300/todo.txt".
      expect = "cs300/todo.txt";

      if (!answer.equals(expect)) {
        System.out.println("Problem detected: The base case's path is wrong");
        return false;
      }
    } catch (NoSuchElementException e) {
      // behavior expected
    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * The test method to test the base case of lookupByKey().
   *
   * @param folder give a current Directory
   * @return return true if all the Scenario are correct
   */
  public static boolean testLookupByKeyBaseCase(File folder) {
    try {
      // Scenario 1 (without recursive -- base case)
      // list all the file that contain ".pdf"
      File f =
          new File(folder.getPath() + File.separator + "programs" + File.separator + "writeUps");
      ArrayList<String> listContent = FolderExplorer.lookupByKey(f, ".pdf");
      // expected output must contain "Program01.pdf", "Program02.pdf" and "Program03.pdf".
      String[] contents = new String[] {"Program01.pdf", "Program02.pdf", "Program03.pdf"};
      List<String> expectedList = Arrays.asList(contents);
      // check the size and the contents of the output
      if (listContent.size() != 3) {
        System.out
            .println("Problem detected: There should be only 3 .pdf files in writeUps folder.");
        return false;
      }
      for (int i = 0; i < expectedList.size(); i++) {
        if (!listContent.contains(expectedList.get(i))) {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of writeUps folder.");
          return false;
        }
      }
    } catch (Exception e) {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * The main method to run all the testers.
   */
  public static void main(String[] args) {
    System.out.println("testGetContents: " + testGetContents(new File("cs300")));
    System.out
        .println("testDeepGetContentsBaseCase: " + testDeepGetContentsBaseCase(new File("cs300")));
    System.out
        .println("testDeepListRecursiveCase: " + testDeepListRecursiveCase(new File("cs300")));
    System.out.println("testLookupByFileName: " + testLookupByFileName(new File("cs300")));
    System.out.println("testLookupByKeyBaseCase: " + testLookupByKeyBaseCase(new File("cs300")));
  }

}
