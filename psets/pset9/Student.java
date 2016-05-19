package pset9;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * This class represents students in a certain school
 * It provides them with names, ID's, grades and credit hours
 * @author drawnitsud
 *
 */

public class Student {

	//fields
	private String name;
	private String firstName;
	private String lastName;
	private int studentID;
	private int credits = 0;
	private double gpa = 0.0;
	private int semester = 1;
	
	
	public Student (String firstName, String lastName, int studentID){
		this.firstName = firstName;
		this.lastName =  lastName;
		this.studentID = studentID;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public String getName(){
		this.name = this.firstName + " " + this.lastName;
		return this.name;
	}
	
	public int getStudentID(){
		return this.studentID;
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public double getGPA(){
		return this.gpa;
	}
	
	public void setFirstName(String first){
		this.firstName = first;
	}
	
	public void setLastName(String last){
		this.lastName = last;
	}
	
	public void setStudentID(int newID){
		this.studentID = newID;
	}
	
	public void setCredits(int newCredits){
		this.credits = newCredits;
	}
	
	public void setGPA(double newGPA){
		this.gpa = newGPA;
	}
	
	/**
	 * This method finds out what year the student is considered
	 * @return is the year in String form
	 */
	public String getClassStanding(){
		if (this.credits>=0 && this.credits<30){
			return "Freshman";
		}
		else if(this.credits>=30 && this.credits<60){
			return "Sophomore";
		}
		else if(this.credits>=60 && this.credits<90){
			return "Junior";
		}
		else if(this.credits>=90){
			return "Senior";
		}
		return "";
	}
	
	/**
	 * This method takes two parameters, returns nothing
	 * but sets the Student's GPA by calculating all the
	 * grades from all of their classes
	 * @param classGrade is the grade in the class
	 * @param classCredit is how many credits the class represents
	 */
	public void submitGrade(double classGrade, int classCredit){
		double qualityScore = classGrade * classCredit;
		double totalQS = this.gpa * this.credits;
		totalQS += qualityScore;
		this.credits += classCredit;
		this.gpa = totalQS / this.credits;
		this.gpa = round(this.gpa, 3);
	}
	
	/**
	 * Created a round method to properly round a value to a certain
	 * number of decimal points because of the imprecision in floating
	 * point arithmetic
	 * @param value the number you want rounded
	 * @param places how many places after the decimal needed
	 * @return the rounded value
	 */
	public static double round(double value, int places) {
	    if (places < 0){
	    	throw new IllegalArgumentException();
	    }

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	/**
	 * This method computes tuition fees based on how many semesters taken
	 * not the number of hours. So if a Student starts a new semester (i.e.
	 * a new block of 15 hours) then they are charged a full 20k
	 * @return the tuition cost
	 */
	public double computeTuition(){
		//credits need to be offset by one because the for loop starts at zero, while 
		//credits needs to start at one because 0%15 == 0
		//this also forces the need to decrement semester at the outset
		if ((this.credits-1) % 15 == 0){
			if ((this.credits-1) == 0){
				semester--;
			}
			semester++;
		}
		
		double tuition = semester * (20000);
		return tuition;
	}
	
	/**
	 * This method creates a new Student legacy born of two existing
	 * Students... takes one "parents" first and last name as its own
	 * first name and the other "parent" first and last name as its 
	 * last name... uses the sum of their student IDs, the average
	 * of their GPA and whichever "parent" had the most credits, their
	 * credit hours are inherited
	 * @param parent a Student object to be the "parent" with this
	 * @return a new Student
	 */
	public Student createLegacy(Student parent){
		Student babyStudent = new Student (firstName, lastName, studentID);
		babyStudent.setFirstName(this.getFirstName() + " " + this.getLastName());
		babyStudent.setLastName(parent.getFirstName() + " " + parent.getLastName());
		babyStudent.setStudentID(this.getStudentID() + parent.getStudentID());
		babyStudent.setGPA((this.getGPA() + parent.getGPA()) / 2);
		int babyCredits = 0;
		int p1 = this.getCredits();
		int p2 = parent.getCredits();
		if (p1 >= p2){
			babyCredits = p1;
		}
		else{
			babyCredits = p2;
		}
		babyStudent.setCredits(babyCredits);
		return babyStudent;
	}
	
	public String toString(){
		return firstName + " " + lastName + " " + studentID;
	}
}
