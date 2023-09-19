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


/**
 * The main class that handles the getContents, getDeepContents, lookupByName, lookupByKey and
 * lookupBySize method.
 */
public class FolderExplorer {

  /**
   * This method takes the given File object and gets the names of all the folders and files inside
   * it without going deeper, returning them in an ArrayList.
   *
   * @param currentDirectory give a current Directory
   * @return Returns a list of the names of all files and folders in the given folder
   *         currentDirectory
   * @throws NotDirectoryException Throws NotDirectoryException with a description error message if
   *         the provided currentDirectory does not exist or if it is not a directory
   */
  public static ArrayList<String> getContents(File currentDirectory) throws NotDirectoryException {

    ArrayList<String> content = new ArrayList<String>();
    String[] file = currentDirectory.list();

    // Throws NotDirectoryException with a description error message if the provided
    // currentDirectory does not exist or if it is not a directory
    if (file == null) {
      throw new NotDirectoryException(
          "The directory provided is not a directory or does not exist.");
    }

    // Add all the file names and folder names to the ArrayList content
    for (int i = 0; i < file.length; i++) {
      content.add(file[i]);
    }

    // Returns a list of the names of all files and directories in the given folder
    // currentDirectory.
    return content;
  }

  /**
   * This method takes the given File object and gets the names of all files in the given folder
   * currentDirectory and its all sub-directories.
   * 
   * @param currentDirectory give a current Directory
   * @return Returns a list of the names of all files in the given folder currentDirectory and its
   *         all sub-directories.
   * @throws NotDirectoryException Throws NotDirectoryException with a description error message if
   *         the provided currentDirectory does not exist or if it is not a directory
   */
  public static ArrayList<String> getDeepContents(File currentDirectory)
      throws NotDirectoryException {

    ArrayList<String> content = new ArrayList<String>();
    File[] file = currentDirectory.listFiles();
    String[] fileName = currentDirectory.list();

    // Throws NotDirectoryException with a description error message if the provided
    // currentDirectory does not exist or if it is not a directory
    if (file == null) {
      throw new NotDirectoryException(
          "The directory provided is not a directory or does not exist.");
    }

    // Add all the file names and folder names to the ArrayList content
    for (int i = 0; i < file.length; i++) {
      if (file[i].isFile()) {
        content.add(fileName[i]);
      }

      // Once find a directory, do the recursive search.
      if (file[i].isDirectory()) {
        ArrayList<String> memo = getDeepContents(file[i]);
        for (int j = 0; j < memo.size(); j++) {
          content.add(memo.get(j));
        }
      }
    }

    // Recursive method that lists the names of all the files (not directories)
    // in the given directory and its sub-directories.
    return content;
  }

  /**
   * This method searches the given directory and all of its sub-directories for an exact match to
   * the provided fileName.
   * 
   * @param currentDirectory give a current Directory
   * @param fileName give a fileName that user want to find
   * @return returns a path to the file, if it exists.
   * @throws NoSuchElementException Throws NoSuchElementException with a descriptive error message
   *         if the search operation returns with no results found (including the case if fileName
   *         is null or currentDirectory does not exist, or was not a directory)
   */
  public static String lookupByName(File currentDirectory, String fileName)
      throws NoSuchElementException {

    File[] files = currentDirectory.listFiles();
    String answer = null;

    // Throws NoSuchElementException if the search operation returns with no results found
    // (including the case if fileName is null or currentDirectory does not exist, or was not a
    // directory)
    if (fileName == null) {
      throw new NoSuchElementException("The file name is null");
    } else if (files == null) {
      throw new NoSuchElementException(
          "the file path provided does not exist or was not a directory.");
    }

    // Call the helper method lookupByNameHelper
    answer = lookupByNameHelper(currentDirectory, fileName);

    if (answer == null) {
      throw new NoSuchElementException("***No results found***");
    }

    // Returns a path to the file if it exists.
    return answer;
  }

  /**
   * The helper method of lookupByName. This helper method will do all the recursive.
   *
   * @param currentDirectory give a current Directory
   * @param fileName give a fileName that user want to find
   * @return returns a path to the file, if it exists. If the file not found, return null.
   */
  private static String lookupByNameHelper(File currentDirectory, String fileName) {

    File[] files = currentDirectory.listFiles();
    String answer = null;
    String memo;

    // Compare all the files' name with given fileName. Once found, return this file's path.
    for (int i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
        if (files[i].getName().equals(fileName)) {
          answer = files[i].getPath();
          return answer;
        }
      } else if (files[i].isDirectory()) { // Once find a directory, do the recursive.
        memo = lookupByNameHelper(files[i], fileName);
        if (memo != null) {
          answer = memo;
        }
      }
    }
    return answer;
  }

  /**
   * This method searches the given folder and its sub-directories for ALL files that contain the
   * given key in part of their name.
   * 
   * @param currentDirectory give a current Directory
   * @param key give a key that user want to find
   * @return Returns An arraylist of all the names of files that match and an empty arraylist when
   *         the operation returns with no results found (including the case where currentDirectory
   *         is not a directory).
   */
  public static ArrayList<String> lookupByKey(File currentDirectory, String key) {

    File[] files = currentDirectory.listFiles();
    ArrayList<String> answer = new ArrayList<String>();


    if (files == null) {
      return answer;
    }

    // Compare all the files' name with given key. Once found, return this file's full name.
    for (int i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
        if (files[i].getName().contains(key)) {
          answer.add(files[i].getName());
        }
      } else if (files[i].isDirectory()) { // Once find a directory, do the recursive.
        ArrayList<String> memo = lookupByKey(files[i], key);
        for (int j = 0; j < memo.size(); j++) {
          answer.add(memo.get(j));
        }
      }
    }
    // Returns An arraylist of all the names of files that match and an empty arraylist when the
    // operation returns with no results found (including the case where currentDirectory is not a
    // directory).
    return answer;
  }

  /**
   * This method searches the given folder and its sub-directories for ALL files whose size is
   * within the given max and min values, inclusive.
   * 
   * @param currentDirectory give a current Directory
   * @param sizeMin give a wanted minimum file size
   * @param sizeMax give a wanted maximum file size
   * @return Returns an array list of the names of all files whose size are within the boundaries
   *         and an empty arraylist if the search operation returns with no results found (including
   *         the case where currentDirectory is not a directory).
   */
  public static ArrayList<String> lookupBySize(File currentDirectory, long sizeMin, long sizeMax) {

    File[] files = currentDirectory.listFiles();
    ArrayList<String> answer = new ArrayList<String>();

    if (files == null) {
      return answer;
    }

    // Compare all the files' size with given wanted size range. Once this file's size is in the
    // range, return this file's full name.
    for (int i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
        if (files[i].length() > sizeMin && files[i].length() < sizeMax) {
          answer.add(files[i].getName());
        }
      } else if (files[i].isDirectory()) { // Once find a directory, do the recursive.
        ArrayList<String> memo = lookupBySize(files[i], sizeMin, sizeMax);
        for (int j = 0; j < memo.size(); j++) {
          answer.add(memo.get(j));
        }
      }
    }

    // Returns an array list of the names of all files whose size are within
    // the boundaries and an empty arraylist if the search operation returns
    // with no results found (including the case where currentDirectory
    // is not a directory).
    return answer;
  }

}
