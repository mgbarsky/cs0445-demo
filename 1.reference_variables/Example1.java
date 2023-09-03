/*
 * MaxFrequency.java
 * Author: M. Barsky
 * Fall 2023
 * Demonstrates the use of reference variables
 */

public class Example1  {
	// Recall that static methods are not part of objects, but rather are part of the
	// class itself.  Thus, they do not have access to implicit data within the objects,
	//and they can be called without creating an instance of a class.
	public static void changeAge (Dog d, int years) {
		d.setAge(d.getAge()+years);
	}

	public static void reborn (Dog d) {
		d = new Dog("No name", 0);
	}
	
	public static void main(String [] args) // Note syntax of main
	{
		// Recall that all objects in Java are dynamic, so that
		// you can first declare reference variables and then create objects
		// to store in them, as shown below
		Dog dog1, dog2, dog3, dog4;
		dog1 = new Dog("Lisa", 2);
		dog2 = new Dog("Bart", 3);
		dog3 = new Dog("Bart", 3);
		
        // The statement below is NOT creating a new object.  Rather, it is
		// setting reference dog4 to the same object that dog3 was set to.
		dog4 = dog3;		
		
		// Recall that the == operator in Java compares primitive types
		// correctly, but for reference types it compares the references,
		// NOT the objects.  Be careful to avoid this common mistake.
		System.out.println("Dog 1: " + dog1);
		System.out.println("Dog 2: " +dog2);
		if (dog1 == dog2)
			System.out.println("the same objects");
		else
			System.out.println("different objects");		

		// To compare objects, we typically use the equals() method.  This method is
		// defined in the Object class, and we override it in our classes to compare
		// objects as we wish.  See how do we compare Dogs in class Dog
		if (dog1.equals(dog2))   // method call
			System.out.println("equal (identical) objects");
		else
			System.out.println("not equal objects");
		System.out.println();
		
		//now comparing dog2 and dog3
		System.out.println("Dog 2: " +dog2);
		System.out.println("Dog 3: " +dog3);
		if (dog2 == dog3)
			System.out.println("the same objects");
		else
			System.out.println("different objects");		

		if (dog2.equals(dog3))   // method call
			System.out.println("equal (identical) objects");
		else
			System.out.println("not equal objects");
		System.out.println();
		
		//now comparing dog3 and dog4
		System.out.println("Dog 3: " +dog3);
		System.out.println("Dog 4: " +dog4);
		if (dog3 == dog4)
			System.out.println("the same objects");
		else
			System.out.println("different objects");		

		if (dog3.equals(dog4))   // method call
			System.out.println("equal (identical) objects");
		else
			System.out.println("not equal objects");
		System.out.println();
		
		dog3.setAge(50); // mutate dog3, changing its age
        System.out.println("Dogs 2, 3 and 4 after mutating age of dog 3");
        System.out.println("Dog 2: " +dog2);
        System.out.println("Dog 3: " +dog3);
		System.out.println("Dog 4: " +dog4);
		
		System.out.println(); 
		//pass object to a method. The copy of reference is created and the 
		//passed object is changed through this new copy of reference
		System.out.println("Dog 1 before change age is called");
		System.out.println("Dog 1: " +dog1);
		changeAge(dog1, 5);
		
		System.out.println("\nDog 1 after change age is called");
		System.out.println("Dog 1: " +dog1);
		
		System.out.println();
		
		//because the method works with the copy of a reference variable
		//setting this copy to another address does not change the passed object
		System.out.println("Dog 2 before reborn is called");
		System.out.println("Dog 2: " +dog2);
		reborn(dog2);
		
		System.out.println("\nDog 2 after reborn");
		System.out.println("Dog 2: " +dog2);
		
	}
}
