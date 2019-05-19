package classes;

public class ArrayQueue<E> implements Queue<E> {

	private final static int INITCAP = 4; 
	private E[] elements; 
	private int first, size; 

	@SuppressWarnings("unchecked")
	public ArrayQueue() { 
		this.elements = (E[]) new Object[INITCAP]; 
		this.first = -1; 
		this.size = 0; 
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E first() {
		if (this.isEmpty())
			return null; 
		return elements[first]; 
	}
	
	public E last() {
		if (this.isEmpty())
			return null;
		return elements[lastPosition(first, this.elements.length)];
	}

	public E dequeue() {
		if (isEmpty())
			return null;

		E etr = elements[first]; 
		elements[first] = null;
		
		if (this.size == 1) {
			first = 0;
		}
		else {
			first = this.nextPosition(first, this.elements.length);
		}
		size--;

		if (elements.length >= 2*INITCAP && size < elements.length/4)
			changeCapacity(elements.length/2);

		return etr;

	}

	public void enqueue(E e) {
		if (this.isEmpty()) {
			this.elements[size++] = e;
			first = 0;
		} else {
			if (size == elements.length)   // check capacity, double it if needed
				changeCapacity(2*size);
			int pos = this.nextAvailablePosition(first, this.elements.length);
			this.elements[pos] = e;
			size++;
		}
	}

	@SuppressWarnings("unchecked")
	private void changeCapacity(int newCapacity) { 
		// PRE: newCapacity >= size
		if (newCapacity < INITCAP) return; // Less capacity not allowed
		E[] arr = (E[]) new Object[newCapacity];
		
		for(int currentPos = first, i=0; i < this.size(); currentPos = nextPosition(currentPos, this.elements.length), i++) {
			arr[i] = this.elements[currentPos];
			this.elements[currentPos] = null;
		}
		this.elements = arr;
		this.first = 0;
	}
	
	@SuppressWarnings("unchecked")
	public E[] toArray() {
		if (this.isEmpty()) {
			return (E[]) new Object[0];
		}
		else {
			E[] result = (E[]) new Object[this.size()];
			int cursor = this.first;
			for (int i=0; i < this.size(); ++i) {
				result[i] = this.elements[cursor];
				cursor = this.nextPosition(cursor, this.elements.length);
			}
			return result;
		}
	}

	private int nextPosition(int currentPosition, int arrayLength) {
		return (currentPosition + 1) % arrayLength;
	}
	
	private int lastPosition(int firstPosition, int arrayLength) {
		return (firstPosition + (this.size-1)) % arrayLength;
	}
	
	private int nextAvailablePosition(int firstPosition, int arrayLength) {
		return (firstPosition + this.size) % arrayLength;
	}
	
}

