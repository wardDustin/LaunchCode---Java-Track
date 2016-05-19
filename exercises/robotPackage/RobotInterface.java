package robotPackage;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RobotInterface{

	private JFrame frame;
	private DefaultListModel<Robot> listModel;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotInterface window = new RobotInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RobotInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Table.dropLineColor"));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 470, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateRobot = new JButton("Create Robot");
		btnCreateRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createRobot();
			}
		});
		btnCreateRobot.setBackground(UIManager.getColor("Button.background"));
		btnCreateRobot.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnCreateRobot.setFont(new Font("Ume Mincho S3", Font.BOLD, 14));
		btnCreateRobot.setBounds(40, 20, 165, 30);
		frame.getContentPane().add(btnCreateRobot);
		
		JButton btnMoveRobot = new JButton("Move Robot");
		btnMoveRobot.setEnabled(false);
		btnMoveRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				Object[] options = {"YES", "NO"};
				int yOrN = showMessage("You are about to move the Robot.\nIs this what you want?", "Robot Move", options);
				if (yOrN == 0){
					Robot a = listModel.get(selected);
					a = moveRobot(a);
					listModel.set(selected, a);
				}
				else{
					Object[] options2 = {"OK"};
					showMessage("You chose to NOT move the Robot", "Robot Move", options2);
				}
			}
		});
		btnMoveRobot.setBackground(UIManager.getColor("Button.background"));
		btnMoveRobot.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnMoveRobot.setFont(new Font("Ume Mincho S3", Font.BOLD, 14));
		btnMoveRobot.setBounds(265, 20, 165, 30);
		frame.getContentPane().add(btnMoveRobot);
		
		JButton btnComputeDistance = new JButton("Compute Distance");
		btnComputeDistance.setEnabled(false);
		btnComputeDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(frame, "Hi");
//				int selected = list.getSelectedIndex();
//				Robot one = listModel.get(selected);
//				Object[] optionRobots = {"OK"};
//				int x = showMessage("You have chosen one Robot\nNow choose the other Robot to\nfind the distance between them", "Compute Distance", optionRobots);
//				Robot two = listModel.get(x);
//				one.distanceFromOther(two);
				
			}
		});
		btnComputeDistance.setBackground(UIManager.getColor("Button.background"));
		btnComputeDistance.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnComputeDistance.setFont(new Font("Ume Mincho S3", Font.BOLD, 14));
		btnComputeDistance.setBounds(265, 75, 165, 30);
		frame.getContentPane().add(btnComputeDistance);
		
		JButton btnRotateRobot = new JButton("Rotate Robot");
		btnRotateRobot.setEnabled(false);
		btnRotateRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				Object[] options = {"YES", "NO"};
				int yOrN = showMessage("You are about to rotate the Robot.\nIs this what you want?", "Robot Rotate", options);
				if (yOrN == 0){
					Robot a = listModel.get(selected);
					a = rotateRobot(a);
					listModel.set(selected, a);
				}
				else{
					Object[] options2 = {"OK"};
					showMessage("You chose to NOT rotate the Robot", "Robot Move", options2);
				}
			}
		});
		btnRotateRobot.setBackground(UIManager.getColor("Button.background"));
		btnRotateRobot.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnRotateRobot.setFont(new Font("Ume Mincho S3", Font.BOLD, 14));
		btnRotateRobot.setBounds(40, 75, 165, 30);
		frame.getContentPane().add(btnRotateRobot);
		
		listModel = new DefaultListModel<Robot>();
		list = new JList(listModel);
		list.setBounds(12, 133, 446, 155);
		frame.getContentPane().add(list);
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnMoveRobot.setEnabled(true);
				btnRotateRobot.setEnabled(true);
				btnComputeDistance.setEnabled(true);
			}
		});
	}
	
	public void createRobot(){
		String rName = (String) JOptionPane.showInputDialog(frame, 
				"Welcome to build-a-Robot!  \nWhat is your Robot's name?", 
				"Name-a-Robot", 
				JOptionPane.PLAIN_MESSAGE, 
				null, 
				null, 
				"");
		
		int xCoord = 0;
		xCoord = verify("Thanks! Now we need your \nrobot's position on a grid. \nEnter the x coordinate, please: ", 
				"X-Coordinate");
		
		int yCoord = 0;
		yCoord = verify("And now the y coordinate!", "Y-Coordinate");
		
		int[] x = new int[]{xCoord, yCoord};
		
		int rSpeed = 0;
		rSpeed = verify("Got them! Now we need \nthe speed of your Robot: ", "Robot Speed");
		
		while (rSpeed < 0){
			rSpeed = verify("The speed of an object must be positive. Please try again!", "Robot Speed");
		}
		
		int rDirection = 0;
		Object[] degreeOptions = {"NORTH", "EAST", "SOUTH", "WEST"};
		rDirection = showMessage("Thank you! Last item. \nWe need the Robot's direction. \nEither North, East, South or West", 
				"Robot Direction", degreeOptions);
		
		if (rDirection == 0){
			rDirection = 0;
		}
		else if(rDirection == 1){
			rDirection = 90;
		}
		else if(rDirection == 2){
			rDirection = 180;
		}
		else if(rDirection == 3){
			rDirection = 270;
		}
		
		Object[] options = {"OK"};
		showMessage("Robot Built!!", "Build-a-Robot", options);
		
		Robot d = new Robot(rName, x, rSpeed, rDirection);
		
		listModel.add(listModel.size(), d);
	}
	
	public Robot moveRobot(Robot a){
		int direction = a.getDirection();
		int speed = a.getSpeed();
		int[] position = a.getPosition();
		
		if (direction == 0){
			position[1] = position[1] + speed;
		}
		else if (direction == 180){
			position[1] = position[1] - speed;
		}
		else if (direction == 90){
			position[0] = position[0] + speed;
		}
		else{
			position[0] = position[0] - speed;
		}
		return a;
	}
	
	public Robot rotateRobot(Robot a){
		Object[] options = {"LEFT", "RIGHT", "CANCEL"};
		int direction = a.getDirection();
		
		int x = showMessage("Do you want to rotate the Robot \nto the left or to the right?", "Robot Rotate", options);
		
		if (x == 0){
			direction = (360 + (direction - 90)) % 360;
		}
		else if (x == 1){
			direction = (direction + 90) % 360;
		}
		else{
			Object[] options2 = {"OK"};
			showMessage("You chose to NOT rotate the Robot", "Robot Rotate", options2);
		}
		a.setDirection(direction);
		return a;
	}

	public int verify(String message, String title){
		int x = 0;
		boolean promptUser = true;
		while(promptUser){
			try{
				x = Integer.parseInt((String) JOptionPane.showInputDialog(frame, 
						message, 
						title, 
						JOptionPane.PLAIN_MESSAGE, 
						null, 
						null, 
						""));
				promptUser = false;
			}catch(NumberFormatException e){
				message = "Must use an integer";
			}
		}
		
		return x;
	}
	
	public int showMessage(String message, String title, Object[] options){
		int x = JOptionPane.showOptionDialog(frame, 
				message, 
				title, 
				JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.PLAIN_MESSAGE, 
				null, 
				options, 
				options[0]);
		
		return x;
	}
}
