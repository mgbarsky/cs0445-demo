package javasorting;
import java.util.*;

public class SortingDogs {    
    
    public static void printDogs(List<Dog> dogs) {
        for (Dog d: dogs) {
            System.out.println(d);
        }
    }     
    
    public static void main(String [] args) {
        List<Dog> dogs = new ArrayList<Dog> ();
        
        dogs.add(new Dog("Lisa", 2.4, 10, "Alice"));
        dogs.add(new Dog("Bart", 4, 15, "Bob"));
        dogs.add(new Dog("Marge", 2.1, 12, "Alice"));
        dogs.add(new Dog("Lisa", 3, 8, "Bob"));
        
        System.out.println("Before sorting:");
        printDogs(dogs);
        
        System.out.println();
        Collections.sort(dogs);        
        System.out.println("After default sorting:");
        printDogs(dogs);
        
        System.out.println();
        Collections.sort(dogs, new HeightComparator());        
        System.out.println("After sorting by height:");
        printDogs(dogs);
        
        System.out.println();
        Collections.sort(dogs, new Comparator<Dog>() {        
            public int compare(Dog d1, Dog d2) {
                return d1.owner.compareTo(d2.owner);
            }
        });        
        
        System.out.println("After sorting by owner:");
        printDogs(dogs);
        
        System.out.println();
        Collections.sort(dogs, Dog.AgeComparator);
        
        System.out.println("After sorting by age:");
        printDogs(dogs);
    }

}
