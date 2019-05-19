package classes;

import java.util.ArrayList;

public class SinglyLinkedList<E> {

	private Node<E> first = null;
	private int size = 0;

	public Node<E> getFirst(){
		return first;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(E e) { 
		Node<E> nuevo = new Node<>(e, first); 
		first = nuevo; 
		size++; 
	}
	public String toString() { 
		String s = ""; 
		Node<E> current = first; 
		while(current != null) { 
			s += " " + current.getElement(); 
			current = current.getNext(); 
		}
		return s; 
	}

	// New reverse and recReverse methods
	public void reverse() {
		if(size > 1) first = recReverse(first).first(); // We want the first one of the Pair which is the first node
	}

	private Pair<Node<E>> recReverse(Node<E> curr){
		if(curr.getNext() == null) {
			Pair<Node<E>> p = new Pair<Node<E>>(curr, curr);
			this.first = curr;
			return p;
		}
		
		Pair<Node<E>> p = recReverse(curr.getNext());
		p.second().setNext(curr);
		curr.setNext(null);
		p.setSecond(curr);
		
		return new Pair<Node<E>>(p.first(), curr);
	}

	public ArrayList<Pair<E>> consecutiveIncreasingPairs() { 
		ArrayList<Pair<E>> result = new ArrayList<>();
		if (size > 0) 
			recCIP(first, result); 
		return result; 
	}


	@SuppressWarnings("unchecked")
	private void recCIP(Node<E> curr, ArrayList<Pair<E>> list) {
		if(curr != null && curr.getNext() != null) {
			if(((Comparable<E>) curr.getElement()).compareTo(curr.getNext().getElement()) < 0) {
				list.add(new Pair<E>(curr.getElement(), curr.getNext().getElement()));
			}
			recCIP(curr.getNext(), list);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void sort(Queue<E> q) {    // sorts the elements in q in non-decreasing order
		   if (q.size() > 1) {     // if size is <= 1, then nothing needs to be done
		      Queue<E> q1, q2; 
		      // Initialize q1 and q2 to empty instances of  ArrayQueue as implemented in previous lab.
		      q1 = new ArrayQueue<>(); 
		      q2 = new ArrayQueue<>(); 

		      // split the elements of q in two halves (or close to), first half into q1 and second half into q2
		      int n = q.size(); 
		      for (int i=0; i<n/2; i++) 
		          q1.enqueue(q.dequeue()); 
		      while (!q.isEmpty())
		          q2.enqueue(q.dequeue()); 

		      sort(q1);    // recursively sort q1
		      sort(q2);    // recursively sort q2

		      // What is left to do now is the merging operation. Given that q1 and q2 are each sorted, 
		      // efficiently combine is elements back into q so that they are placed in order from first to last. 
		      // This process efficiently exploits the property that both, q1 and q2, are sorted.
		      while (!q1.isEmpty() && !q2.isEmpty())
		          if (((Comparable<E>) q1.first()).compareTo(q2.first()) <= 0)
		             q.enqueue(q1.dequeue()); 
		          else 
		             q.enqueue(q2.dequeue()); 
		      // At this moment, one of the two queues, either q1 or q2, is empty.
		      Queue<E> r = (!q1.isEmpty() ? q1 : q2);  // find which, q1 or q2, is not empty yet
		      while (!r.isEmpty())
		          q.enqueue(r.dequeue()); 
		     } 
		}



	private static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}

		public E getElement() {return element;}
		public Node<E> getNext() {return next;}
		public void setNext(Node<E> newNext) {this.next = newNext;}

	}

}
