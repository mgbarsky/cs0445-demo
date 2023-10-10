//Demo of why an iterator may be useful.  This example is using that standard
//Java List, LinkedList and ArrayList in a demonstration that finds the mode
//[most common value] in a list of Integers.
import java.util.*;

public class ModeIterators {
	public static void main(String [] args)
	{
		List<Integer> L1 = new LinkedList<Integer>(); 
		List<Integer> L2 = new ArrayList<Integer>();

		Random R = new Random();
		
		for (int i = 0; i < 10000; i++) {
			Integer newVal = R.nextInt(1000);
			L1.add(newVal);
			L2.add(newVal);
		}

		System.out.println("Calculating mode with nested iterators: ");
		long start = System.currentTimeMillis();
		getModeIterator1(L1);
		long end = System.currentTimeMillis();
		System.out.println("LinkedList: finished in " + (end-start) + "ms.");
		
		start = System.currentTimeMillis();
		getModeIterator1(L2);
		end = System.currentTimeMillis();
		System.out.println("ArrayList: finished in " + (end-start) + "ms.");
		
		System.out.println("\nCalculating mode with for each loop iterators: ");
		start = System.currentTimeMillis();
		getModeIterator2(L1);
		end = System.currentTimeMillis();
		System.out.println("LinkedList: finished in " + (end-start) + "ms.");
		
		start = System.currentTimeMillis();
		getModeIterator2(L2);
		end = System.currentTimeMillis();
		System.out.println("ArrayList: finished in " + (end-start) + "ms.");

		System.out.println("\nCalculating mode without iterators using get: ");
		start = System.currentTimeMillis();
		getModeNoIterator(L1);
		end = System.currentTimeMillis();
		System.out.println("LinkedList: finished in " + (end-start) + "ms.");
		
		start = System.currentTimeMillis();
		getModeNoIterator(L2);
		end = System.currentTimeMillis();
		System.out.println("ArrayList: finished in " + (end-start) + "ms.");	
	}

	// Using nested iterators to calculate the mode of a list of
	// integers.  Note that this works fine for either an array or
	// a linked implementation of the List, and that at this level
	// we do not need to know or care how the List is stored or how
	// the iterator is implemented.  The idea is that the iterator will
	// be implemented in an efficient way for the underlying data
	// structure of the list.
	public static void getModeIterator1(List<Integer> L)
	{
		Iterator<Integer> outer = L.iterator();
		Iterator<Integer> inner;
		Integer theMode = null, currOuter = null, currInner = null;
		int modeCount = 0, currCount = 0;
		while (outer.hasNext())
		{
			currOuter = outer.next();
			currCount = 0;
			inner = L.iterator();
			while (inner.hasNext())
			{
				currInner = inner.next();
				if (currInner.equals(currOuter))
					currCount++;
			}
			if (currCount > modeCount)
			{
				theMode = currOuter;
				modeCount = currCount; 
			}
		}
		System.out.println("The mode is " + theMode + " with " + modeCount +
						   " occurrences ");
	}

	// Logically, this code is equivalent to the version above.  However, with
	// JDK 1.5 the Iterable interface was introduced, which allows the standard
	// Java for loop to use the iterator of the underlying class in the loop.
	// This version of the for loop can also be used to iterate through regular
	// arrays (if so desired).
	public static void getModeIterator2(List<Integer> L)
	{
		Integer theMode = null;
		int modeCount = 0, currCount = 0;
		for (Integer currOuter : L)
		{
			currCount = 0;
			for (Integer currInner : L)
			{
				if (currInner.equals(currOuter))
					currCount++;
			}
			if (currCount > modeCount)
			{
				theMode = currOuter;
				modeCount = currCount;
			}
		}
		System.out.println("The mode is " + theMode + " with " + modeCount +
						   " occurrences ");
	}

	// In this version we are using the get() method rather than using an
	// iterator.  For the array version this works fine, but it is very
	// inefficient for the linked list, since each call to get() for the
	// linked list requires a traversal of the list.  It is situations like
	// this where it is prudent for the programmer to be aware of the
	// underlying implementation of an ADT.
	public static void getModeNoIterator(List<Integer> L)
	{
		Integer theMode = null, currOuter = null, currInner = null;
		int modeCount = 0, currCount = 0;
		for (int i = 0; i < L.size(); i++)
		{
			currOuter = L.get(i);
			currCount = 0;
			for (int j = i; j < L.size(); j++)
			{
				currInner = L.get(j);
				if (currInner.equals(currOuter))
					currCount++;
			}
			if (currCount > modeCount)
			{
				theMode = currOuter;
				modeCount = currCount;
			}
		}
		System.out.println("The mode is " + theMode + " with " + modeCount +
						   " occurrences ");
	}	
}