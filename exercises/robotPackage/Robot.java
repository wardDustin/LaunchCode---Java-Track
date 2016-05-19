package robotPackage;

//import java.util.Arrays;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import java.util.Arrays;

public class Robot {
	//fields
	private String name;
	private int[] position= new int[2];
	private int speed;
	private int direction;
	
	public Robot(String name, int[] position, int speed, int direction){
		this.name = name;
		this.position = position;
		this.speed = speed;
		this.direction = direction;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int[] getPosition(){
		return this.position;
	}
	
	public int getSpeed(){
		return this.speed;
	}
	
	public int getDirection(){
		return this.direction;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public void setPosition(int[] newPosition){
		this.position = newPosition;
	}
	
	public void setSpeed(int newSpeed){
		if (newSpeed<0){
			return;
		}
		this.speed = newSpeed;
	}
	
	public void setDirection(int newDirection){
		if (newDirection == 0 || newDirection == 90 || newDirection == 180 || newDirection == 270){
			this.direction = newDirection;
		}
	}
	
	public int[] move(){
		if (this.direction == 0){
			this.position[1] = this.position[1] + this.speed;
		}
		else if (this.direction == 180){
			this.position[1] = this.position[1] - this.speed;
		}
		else if (this.direction == 90){
			this.position[0] = this.position[0] + this.speed;
		}
		else{
			this.position[0] = this.position[0] - this.speed;
		}
		return position;
	}
	
	public int rotate(boolean leftOrRight){
		if (leftOrRight == true){
			this.direction = (this.direction + 90) % 360;
			return this.direction;
		}
		else{
			this.direction = (360 + (this.direction - 90)) % 360;
			return this.direction;
		}
	}
	
	public double distanceFromOther(Robot otherRobot){
		double distanceFrom = pow((otherRobot.position[1] - this.position[1]), 2) + pow((otherRobot.position[0] - this.position[0]), 2);
		distanceFrom = sqrt(distanceFrom);
		return distanceFrom;
	}
	
	public String toString(){
		return "Name: " + name + "| Position: " + Arrays.toString(position) + "| Speed: " + speed + "| Direction: " + direction + " degrees";
	}
	
	public static void main (String args[]){
		Robot myRobot = new Robot("Dustin", new int[]{2, 2}, 10, 180);
		Robot otherRobot = new Robot("Justin", new int[]{3,3}, 8, 0);
		Robot thirdRobot = new Robot ("Bustin", new int[]{7, 6}, 17, 270);
		System.out.println(myRobot);
		System.out.println(otherRobot);
		myRobot.move();
		otherRobot.move();
		System.out.println("------------------------------------------------------------------------");
		System.out.println(myRobot);
		System.out.println(otherRobot);
		System.out.println(myRobot.rotate(true));
		System.out.println(otherRobot.rotate(false));
		System.out.println("------------------------------------------------------------------------");
		System.out.println(myRobot);
		System.out.println(otherRobot);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("The position from Dustin to Justin is " + myRobot.distanceFromOther(otherRobot));
		System.out.println("The position from Dustin to Bustin is " + myRobot.distanceFromOther(thirdRobot));
	}
}
