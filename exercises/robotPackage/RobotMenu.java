package robotPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
	
	private Scanner input;
	private ArrayList<Robot> robots;
	
	public RobotMenu(){
		input = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	public static void main (String args[]){
		int x = 0;
		RobotMenu menu = new RobotMenu();
		do{
			x = menu.startMenu();
			menu.processInput(x);
		}while (x!=6);
		
	}
	
	public int startMenu(){
		System.out.println("Welcome to the Robot Menu!");
		System.out.println("1. Create a Robot");
		System.out.println("2. Display the list of Robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a Robot");
		System.out.println("5. Compute the distance between two Robots");
		System.out.println("6. Exit");
		int selection = 0;
		selection = verifyInput(selection);
		
		while (selection < 0 || selection > 6){
			System.out.println("Invalid Selection, please choose again!");
			selection = verifyInput(selection);
		}
		return selection;
	}
	
	public void processInput(int selection){
		if (selection == 1){
			createRobot();
		}
		else if (selection == 2){
			displayRobots();
			System.out.println("");
		}
		else if (selection == 3){
			displayRobots();
			System.out.println("Choose a robot to move: ");
			Robot a = selectRobot();
			a.move();
			System.out.println("Here is the status of the Robot after the move:");
			System.out.println(a);
			System.out.println("");
		}
		else if (selection == 4){
			displayRobots();
			System.out.println("Choose a robot to rotate: ");
			Robot a = selectRobot();
			System.out.println("Choose direction in which to rotate your robot: ");
			System.out.println("1. Right");
			System.out.println("2. Left");
			int choice = 0;
			choice = verifyInput(choice);
			
			while (choice!=1 && choice!=2){
				System.out.println("Invalid input, please try again!");
				choice = verifyInput(choice);
			}
			if (choice == 1){
				a.rotate(true);
			}
			else{
				a.rotate(false);
			}
			System.out.println("Here is the status of the Robot after the rotation: ");
			System.out.println(a);
			System.out.println("");
		}
		else if (selection == 5){
			displayRobots();
			System.out.println("Choose two robots to find the distance between: ");
			System.out.println("First robot: ");
			Robot a = selectRobot();
			System.out.println("And the second robot: ");
			Robot b = selectRobot();
			System.out.println("The distance between the first and second robots is: ");
			System.out.println(a.distanceFromOther(b));
			System.out.println("");
			
		}
		else if (selection == 6){
			System.out.println("Exiting...");
			System.out.println("Thank you for visiting the Robot Menu!");
		}
	}
	
	public void displayRobots(){
		System.out.println("");
		for (int i=0; i<robots.size(); i++){
			System.out.println((i+1) + ".) " + robots.get(i));
		}
		System.out.println("");
	}
	
	public Robot selectRobot(){
		if (robots.size() < 1){
			System.out.println("You have not yet created any Robots!");
			
		}
		int select = 0;
		select = verifyInput(select);
		
		while (select < 1 || select > robots.size()){
			System.out.println("Invalid selection, please try again!");
			select = verifyInput(select);
		}
		return robots.get(select - 1);
	}
	
	public void createRobot(){
		System.out.println("Welcome to build-a-Robot!");
		System.out.println("What is your Robot's name?");
		String rName = input.nextLine();
		
		System.out.println("Thanks! Now we need your robot's position on a grid. Enter the x coordinate, please: ");
		int xCoord = 0;
		xCoord = verifyInput(xCoord);
		
		System.out.println("And now the y coordinate!");
		int yCoord = 0;
		yCoord = verifyInput(yCoord);
		
		int[] x = new int[]{xCoord, yCoord};
		
		System.out.println("Got them! Now we need the speed of your Robot: ");
		int rSpeed = 0;
		rSpeed = verifyInput(rSpeed);
		while (rSpeed < 0){
			System.out.println("The speed of an object must be positive. Please try again!");
			rSpeed = verifyInput(rSpeed);
		}
		
		System.out.println("Thank you! Last item. We need the Robot's direction- in degrees. Either 0, 90, 180 or 270: ");
		int rDirection = 0;
		rDirection = verifyInput(rDirection);
		
		while (rDirection != 0 && rDirection != 90 && rDirection != 180 && rDirection != 270){
			System.out.println("The direction must be represented by degrees. 0, 90, 180 or 270. Please try again!");
			rDirection = verifyInput(rDirection);
		}
		System.out.println("Ok! Building your Robot...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("Almost done...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("Robot finished!!");
		System.out.println("");
		
		robots.add(new Robot(rName, x, rSpeed, rDirection));
	}
	
	public int verifyInput(int newInt){
		while (!input.hasNextInt()){
			input.next();
			System.out.println("I need an integer please: ");
		}
		newInt = input.nextInt();
		input.nextLine();
		return newInt;
	}

}
