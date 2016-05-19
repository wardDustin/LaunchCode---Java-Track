package pset9;

import java.util.ArrayList;

public class Course {

	private String name;
	private int credits;
	private int remainingSeats;
	private ArrayList<Student> roster = new ArrayList<Student>();
	
	public Course (String name, int credits, int remainingSeats){
		this.name = name;
		this.credits = credits;
		this.remainingSeats = remainingSeats;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public int getRemainingSeats(){
		return this.remainingSeats;
	}
	
	public ArrayList<Student> getRoster(){
		return this.roster;
	}
	
	public void setCourseName(String newCourseName){
		this.name = newCourseName;
	}
	
	public void setCredits(int newCredits){
		this.credits = newCredits;
	}
	
	public void setRemainingSeats(int newRemainingSeats){
		if (newRemainingSeats>0){
			this.remainingSeats = newRemainingSeats;
		}
	}
	
	/**
	 * This method adds a student to the course, making sure
	 * to subtract the number of seats available in the class
	 * @param a is a Student needing to be added to the course
	 * @return true or false depending on if the student was added
	 */
	public boolean addStudent(Student a){
		if (roster.contains(a.getName())){
			return false;
		}
		else{
			if (this.remainingSeats>0){
				roster.add(a);
				this.remainingSeats--;
				return true;
			}
			return false;
		}
	}
	
	/**
	 * Converts the roster (an ArrayList<OBJ>) to a string
	 * which allows the Students inside to be read easily
	 * @return the roster in String form
	 */
	public String generateRoster(){
		return roster.toString();
	}
	
	/**
	 * gets each Student from the roster of this class and
	 * calculates the average GPA of the Students
	 * @return the average GPA
	 */
	public double averageGPA(){
		double avGPA = 0.0;
		int i = 0;
		for (; i<this.roster.size(); i++){
			Student a = this.roster.get(i);
			avGPA += a.getGPA();
		}
		avGPA /= i;
		return avGPA;
	}
	
	@Override
	public String toString() {
		return "Course [name = " + name + ", credits = " + credits + ", remainingSeats = " + remainingSeats + "]";
	}
}
