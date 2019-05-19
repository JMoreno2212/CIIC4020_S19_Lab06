package testers;

import java.util.ArrayList;
import java.util.Random;

import classes.Pair;
import classes.SinglyLinkedList;

public class ReverseListTester {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> intList = new SinglyLinkedList<>();
		for(Integer i = 5; i >= 1; i--) {
			intList.addFirst(i);
		}
		System.out.println("=======================================================");
		System.out.println("TESTING RECURSIVE REVERSE LIST METHOD");
		System.out.println("");
		System.out.print("The regular list is: ");
		System.out.println(intList.toString());
		System.out.println("Reversing the list...");
		intList.reverse();
		System.out.print("The reversed list is: ");
		System.out.println(intList.toString());
		System.out.println("=======================================================");

		SinglyLinkedList<Integer> intList2 = new SinglyLinkedList<>();
		Random rand = new Random();
		for(Integer i = 1; i <= 5; i++) {
			intList2.addFirst(rand.nextInt(25));
		}

		System.out.println("=======================================================");
		System.out.println("TESTING CONSECUTIVE INCREASING PAIRS METHOD");
		System.out.println("");
		System.out.print("The regular list is: ");
		System.out.println(intList2.toString());
		System.out.println("Creating the pairs...");
		ArrayList<Pair<Integer>> array = intList2.consecutiveIncreasingPairs();
		System.out.println(array.toString());
		System.out.println("=======================================================");
	}

}
