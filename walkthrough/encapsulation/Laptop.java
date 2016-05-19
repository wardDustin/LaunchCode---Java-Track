package encapsulation;

import java.util.ArrayList;

public class Laptop extends Computer {
	
	private boolean isClosed;
	
	public Laptop(int memory, double size, double processor, String brand){
		super(memory, size, processor, brand);
		this.isClosed = true;
	}
	
	public void close(){
		this.isClosed=true;
	}
	
	public void open(){
		this.isClosed=false;
	}
	
	public static void main (String[] args){
		Laptop l = new Laptop(8, 15, 10000, "Acer");
		Tablet t = new Tablet(4, 10, 1000, "Apple");
		Computer c = new Computer(16, 24, 50000, "Dell");
		
		System.out.println(l.getBrand());
		System.out.println(t.getBrand());
		System.out.println(c.getBrand());
		
		ArrayList<Computer> computers = new ArrayList<Computer>();
		computers.add(c);
		computers.add(t);
		computers.add(l);
		System.out.println(computers.toString());
		
	}
	
}
