package classes;

public class Pair<E> {
	private E first;
	private E second;
	
	public Pair() {
		first = second = null;
	}
	
	public Pair(E first) {
		this.first = first;
		this.second = null;
	}
	
	public Pair(E first, E second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "(" + first + "," + second + ")";
	}
	
	public E first() {return first;}
	public void setFirst(E newFirst) {this.first = newFirst;}

	public E second() {return second;}
	public void setSecond(E newSecond) {this.second = newSecond;}
	
}
