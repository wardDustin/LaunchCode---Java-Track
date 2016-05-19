package robotPackage;

public class PersonalAssistant extends Robot{

	private String directive;
	private String reminder;
	private boolean cook;
	private boolean clean;
	
	public PersonalAssistant(String name, int[] position, int speed, int direction){
		super(name, position, speed, direction);
		this.reminder = "waiting for input!";
	}
	
	public String getDirective(){
		return this.directive;
	}
	
	public String getReminder(){
		return this.reminder;
	}
	
	public void setDirective(String newDirective){
		this.directive = newDirective;
	}
	
	public void setReminder(String newReminder){
		this.reminder =  newReminder;
	}
	
	public void clean(){
		this.clean = !this.clean;
	}
	
	public void cook(){
		this.cook = !this.cook;
	}
	
}
