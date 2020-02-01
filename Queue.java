/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 10/11/17
 * Submitted:  10/11/17
 * Comment: test suite and sample run attached
 * @author: Isaac Gaw
 * @version: 2017.10.11
 */
public class Queue<T> implements QueueInterface<T> {

	protected T[] qList;
	static int size;
	static int front;
	static int back;

	public Queue() {
		qList = (T[]) new Object[3];
		size = 0;
		front = 0;
		back = 0;
	}

	public boolean isEmpty() {
		return qList.length == 0;
	}

	public void enqueue(T newItem) throws QueueException {
		if (qList.length == size) {
			this.resize();
		}
		qList[back] = newItem;
		back = (back + 1) % qList.length;
		size++;
	}

	public T dequeue() throws QueueException {
		if (!this.isEmpty()) {
			T temp = qList[front];
			qList[front] = null;
			front = (front + 1) % qList.length;
			size--;
			return temp;
		} else {
			// index out of range
			throw new QueueException("QueueException");
		} // end if
	}

	public void dequeueAll() {
		qList = (T[]) new Object[0];
		front = 0;
		back = 0;
	}

	public T peek() throws QueueException {
		if (!this.isEmpty()) {
			return qList[front];
		} else {
			throw new QueueException("QueueException");
		} // end if
	}

	public String toString() {
		if (!this.isEmpty()) {
			String list = "";
			for (int x = 0; x < size; x++) {
				list += (String) qList[(front + x) % qList.length] + " ";
			}
			return list;
		} else {
			throw new QueueException("QueueException");
		}
	}

	protected void resize() {
		int newLength = (qList.length + 1) * 2;
		T[] temp = (T[]) new Object[newLength];
		for (int i = 0; i < size; i++) {
			temp[i] = qList[(front + i) % qList.length];
		}
		front = 0;
		back = size;
		qList = temp;
	}
}
