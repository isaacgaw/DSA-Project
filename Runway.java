
public class Runway
{
	Queue <Plane> runway = new Queue<>();
	int size = 0;
	
//=-------------- global variable ------------------------------------------------ 
	public String name;
	
//=-------------- constructor for the class ----------------------------------------------	
	public Runway(String name)
	{
		this.name = name;
	}
//=------------------ This gets the runway name -------------------------------------------------------------
	public String getName() {
		return name;
	}
//---------------------- This sets the runway name to your choosing ------------------
	public void setrName(String name) 
	{
		this.name = name;
	}
	
	public boolean isEmpty() {
		return runway.isEmpty();
	}
	
	public void add(Plane plane) {
		runway.enqueue(plane);
		size++;
	}
	
	public void remove() {
		runway.dequeue();
		size--;
	}
	
	public Plane peek() {
		return runway.peek();
	}
	
	public int size() {
		return size;
	}
}
