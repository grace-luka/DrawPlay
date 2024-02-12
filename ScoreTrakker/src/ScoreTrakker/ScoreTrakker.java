/*
 * 
 * Authors; Grace Luka and Caoline Schreier
 * Class: The Scoretrakker class is where we are checking the files and the formatting
 * to make sure they are all valid. The processFiles() method is checking to
 * make sure that we are going to process a file that exists, if it doesn'tt exist
 * then we will throw and exception. The loadDataFile() method checks if the 
 * score of a student is an integer, if it is not it throws an error and doesn't
 * add the student to the final array list to print. The printInOrder() method sorts
 * and prints our array list after all exeptions may or may not have been thrown.
 * Date: 2-11-2024
 * Sources: https://www.geeksforgeeks.org/collections-sort-java-examples/
 * 			https://www.geeksforgeeks.org/file-length-method-in-java-with-examples/
 * 			https://www.tutorialspoint.com/java/util/arraylist_add_index.htm
			https://stackoverflow.com/questions/24975167/java-how-to-use-compareto-to-sort-an-arraylist
			https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/
			
*/

package ScoreTrakker;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class ScoreTrakker {
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	// sets the string name of an input file
	//private String inputFile;
	/*public void setinputFile(String inputFile) {
		this.inputFile = inputFile;
	}*/
	
	// private String outputFile
	// public void setoutputFile(String outputFile){
	// 		this.output = outputFile; }

	// reads in a students name and score, stores information in a new student object, puts 
	// object in studentList, and handles errors if the score for a student is not a number
	public void loadDataFile(String fileName) throws FileNotFoundException{ 
		FileReader reader = new FileReader(fileName); // reads student data from a file 
		String scoreNum = null;
		Scanner in = null;
		in = new Scanner(reader);
		for (int i = 0; i < fileName.length(); i = i + 2) { //Put your try/catch block inside your loop that reads the file. 
			String name = in.nextLine();
			try { 									// Include a try/catch block
				scoreNum = in.nextLine();
				int num = Integer.parseInt(scoreNum);
				Student student = new Student(name, num);
				studentList.add(student); // and stores student objects in ArrayList
			} 
			catch (NumberFormatException e) { //handle a NumberFormatException
				System.out.println("\nIncorrect format for " + name + " not a valid score: " + scoreNum + "\n"); // throws clause to loadDataFile, Your error message should include the student's name and offending value
			}
		}
	}

    // Sort and print studentList in order
    public void printInOrder(){
    	System.out.println("Student Score List");
        Collections.sort(studentList);
		for (int i = 0; i < studentList.size(); i++){
			System.out.println(studentList.get(i));
		}
    }
    
	// load each file in files, check whether each file exists and handle errors if it does not
    public void processFiles(){
		for (int i = 0; i < files.length; i++) { //Loop through all the files in the files array. Use an iterated for loop (for each).
			FileReader reader = null;
			String inputFile = files[i];
			try {//Within the loop, put a try/catch block around the calls to loadDataFile() and printInOrder() (even though printInOrder() doesn't throw an exception we'll put it inside the try/catch so that if an error is thrown from loadDataFile(), we won't do the print)
				reader = new FileReader(inputFile);
				loadDataFile(files[i]);
				printInOrder();
			} catch (FileNotFoundException e){ //Handle a FileNotFoundException with an appropriate message
				System.out.println("\nCan't open file: " + inputFile + "\n");
			}
		}

    }
    // creates a new object of type ScoreTrakker and calls processFiles
    public static void main(String[] args){
    	ScoreTrakker tally = new ScoreTrakker();
		tally.processFiles();
    }
}