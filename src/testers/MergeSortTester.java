package testers;

import java.util.ArrayList;
import java.util.Random;

import classes.ArrayQueue;
import classes.Queue;

public class MergeSortTester {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
				
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(rand.nextInt(50));
		}
		
		System.out.println("List in original order:");
		System.out.println(list);
		Queue<Integer> q = toArrayQueue(list);
		sort(q);
		toArrayList(q, list);
		System.out.println("\nList sorted in increasing order:");
		System.out.println(list);
	}
	
	public static ArrayQueue<Integer> toArrayQueue(ArrayList<Integer> list) {
		ArrayQueue<Integer> q = new ArrayQueue<Integer>();
		for (int i = 0; i < list.size(); i++) {
			q.enqueue(list.get(i));
		}
		
		return q;
	}
	
	public static void toArrayList(Queue<Integer> q, ArrayList<Integer> list) {
		while(!list.isEmpty()) {
			list.remove(list.size()-1);
		}
		int size = q.size();
		for (int i = 0; i < size; i++) {
			list.add(q.dequeue());
		}
	}
	
	// Sorts the elements in the given queue in non-decreasing order
	public static void sort(Queue<Integer> q) {
		if (q.size() > 1) {     // if size is <= 1, then nothing needs to be done
			Queue<Integer> q1, q2; 
			// Initialize q1 and q2 to empty instances of  ArrayQueue as implemented in previous lab.
			q1 = new ArrayQueue<>(); 
			q2 = new ArrayQueue<>(); 

			// split the elements of q in two halves (or close to), first half into q1 and second half into q2
			int size = q.size();
			for (int i = 0; i < size / 2; i++) 
				q1.enqueue(q.dequeue());

			while (!q.isEmpty())
				q2.enqueue(q.dequeue()); 

			sort(q1);    // recursively sort q1
			sort(q2);    // recursively sort q2

			// What is left to do now is the merging operation. Given that q1 and q2 are each sorted, 
			// efficiently combine is elements back into q so that they are placed in order from first to last. 
			// This process efficiently exploits the property that both, q1 and q2, are sorted.
			while (!q1.isEmpty() && !q2.isEmpty())
				if (((Comparable<Integer>) q1.first()).compareTo(q2.first()) <= 0)
					q.enqueue(q1.dequeue()); 
				else q.enqueue(q2.dequeue()); 
			// At this moment, one of the two queues, either q1 or q2, is empty.
			Queue<Integer> r = (!q1.isEmpty() ? q1 : q2);  // find which, q1 or q2, is not empty yet
			while (!r.isEmpty())
				q.enqueue(r.dequeue()); 
		} 

	}

}
