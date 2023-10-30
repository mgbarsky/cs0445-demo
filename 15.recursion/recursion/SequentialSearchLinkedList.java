package recursion;
/** @author John Ramirez 
* simplified version by M. Barsky
* Demonstration of Recursive Sequential Search using a linked list. 
* recursive version. A trace version of the recursive algorithm is also shown
* so you can better see the behavior of the recursive algorithm. 
*/  

import java.io.*;

public class SequentialSearchLinkedList {
	
	//creates a linked list with num nodes of random integers 
	public static Node<Integer> loadData(int num)	{
		Node<Integer> curr = null;
		Node<Integer> head = null;
		for (int i = 0; i < num; i++)	{
			Integer item = Integer.valueOf((int) (Math.random() * 200));
			// Special case for empty list -- watch for these cases.
			if (head == null) {
				head = new Node<Integer>(item);
				curr = head;
			}
			else {
				curr.next = new Node<Integer>(item);
				curr = curr.next;
			}
		}
		return head;
	}

	// Iterative sequential search of the list.  Note that we do not need a new curr
	// variable here since "head" is a parameter and reassigning "head" will not affect
	// the caller variable (passing by copy)
	public static <T extends Comparable<T>> int linkedSearch(Node<T> head, T key) {
		int loc = 0;
		while (head != null)	{
			if (head.data.compareTo(key) == 0)
				return loc;
			else	{
				head = head.next;
				loc++;
			}
		}
		return -1;	
	}

	// Recursive sequential search of the list.  Note the order of the cases -- just as
	// with the array this order matters.  If the list is null then trying to access
	// a method would generate a NullPointerException.  Note how simple and elegant the
	// recursive solution is.  Despite this elegance, we would not actually use it due
	// to the overhead of the recursive calls.
	public static <T extends Comparable<T>> int recLinkedSearch(Node<T> node, T key, int loc) {
		if (node == null)  // List is empty -- base case not found
			return -1;
		else if (node.data.compareTo(key) == 0)  // base case found
			return loc;
		else		// recurse to next Node and return that result
			return (recLinkedSearch(node.next, key, loc+1));
	}
	
	public static void main (String [] args) throws IOException	{
		BufferedReader BR = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("Please enter size of the list:");
		int num = Integer.parseInt(BR.readLine());
	
		Node<Integer> head = loadData(num);
		System.out.println("The data is: ");
		Node<Integer> curr = head;
		while (curr != null) {
			System.out.print(curr.data);
			if (curr.next != null)
				System.out.print(", ");
			curr = curr.next;
		}
		System.out.println();

		System.out.println("Please enter the item to search for:");
		Integer key = Integer.valueOf(BR.readLine());
		
		int loc = linkedSearch(head, key);
		if (loc >= 0)
			System.out.println("Iteratively, " + key + " found at Node " + loc);
		else
			System.out.println(key + " was not found ");

		loc = recLinkedSearch(head, key, 0);
		if (loc >= 0)
			System.out.println("Recursively, " + key + " found at Node " + loc);
		else
			System.out.println(key + " was not found ");

	}
}