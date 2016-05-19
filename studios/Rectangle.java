
public class Rectangle {

	private float length;
	private float width;
	
	public Rectangle (float length, float width){
		this.length = length;
		this.width = width;
	}
	
	public float getLength(){
		return this.length;
	}
	
	public float getWidth(){
		return this.width;
	}
	
	public void setLength(float newLength){
		if (newLength<0){
			return;
		}
		this.length = newLength;
	}
	
	public void setWidth(float newWidth){
		if (newWidth<0){
			return;
		}
		else{
			this.width = newWidth;
		}
	}
	
	public float showArea(){
		float area = (this.length*this.width);
		return area;
	}
	
	public float showPerim(){
		float perim = (this.length*2) + (this.width*2);
		return perim;
	}
	
	public boolean isSquare(){
		if (length == width){
			return true;
		}
		else{
			return false;
		}
	}
	
	public float biggerOrSmaller(Rectangle newRect){
		if((this.length*this.width) == (newRect.length * newRect.width)){
			return 0;
		}
		else{
			return ((this.length * this.width) - (newRect.length * newRect.width));
		}
	}
	
	public String toString(){
		return "Length: " + length + "| Width: " + width + "| Area: " + (length*width) + "| Perimeter: " + ((length*2)+(width*2));
	}
	
	public static void main(String args[]){
		Rectangle myRect = new Rectangle (17.2f, 10f);
		System.out.println(myRect);
		myRect.setLength(12);
		myRect.setWidth(4);
		System.out.println(myRect);
		Rectangle newRect = new Rectangle(22f, 4.2f);
		System.out.println(newRect);
		System.out.println(myRect.biggerOrSmaller(newRect));
		newRect.setLength(4.45f);
		newRect.setWidth(4.45f);
		System.out.println(myRect.biggerOrSmaller(newRect));
		System.out.println(myRect.isSquare());
		System.out.println(newRect.isSquare());
		System.out.println(newRect.showArea());
		System.out.println(newRect.showPerim());
	}
	
}
