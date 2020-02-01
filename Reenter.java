
public class Reenter {
	
	Queue <Plane> enterList = new Queue<>();
	
	public Reenter() {	
	}
	
	public void add(Plane plane) {
		enterList.enqueue(plane);
	}
	
	public void remove() {
		enterList.dequeue();
	}
}
