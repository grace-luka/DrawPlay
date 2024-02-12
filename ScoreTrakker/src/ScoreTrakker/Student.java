/*
 * Authors; Grace Luka and Caoline Schreier
 * Class: This student class creates is called everytime a new student is called in 
 * ScoreTrakker, it keeps track of the name and score of each student as 
 * private variables and also handles the compare method. It also has a to string
 * method for proper printing format. 
 * Date: 2-11-2024
 * Sources: https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/		
*/

package ScoreTrakker;

public class Student implements Comparable<Student>{
    private String name;
    private int score;

    // constructor sets values for name and score private variables
    public Student(String studentName, int studentScore){
        this.name = studentName;
        this.score = studentScore; 
    }

    // Used in the sort function for arraylists, orders values based on name
	@Override
	public int compareTo(Student o) {
		/*if (this.name.compareTo(o.name) != 0) {
            return this.name.compareTo(o.name);
		}
        else{
            return this.score - o.score;
        }*/
        return Integer.compare(this.score, o.score);
	}

    // prints values of each student object with their name listed first and then their score
    public String toString(){
        return name + " " + score;  
 }  
}