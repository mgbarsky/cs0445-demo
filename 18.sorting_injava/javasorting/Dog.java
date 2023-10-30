package javasorting;

import java.util.Comparator;

public class Dog implements Comparable<Dog>{
    String name;
    double age;
    int height;
    String owner; 
    
    public Dog(String name, double age, 
            int height, String owner) {
        this.name = name;
        this.age = age;
        this.height = height;        
        this.owner = owner;
    }
    
    public String toString() {
        return String.format("Dog %7s %4.1f years %4d inches owned by %7s",
                this.name, this.age, this.height, this.owner );      
    }
    
    public int compareTo(Dog another) {
        return this.name.compareTo((another).name);
    }
    
    //age is of type double
    public static Comparator<Dog> AgeComparator = new Comparator<Dog>() {        
        public int compare(Dog d1, Dog d2) {
          //we can invoke compareTo of Double 
            
            Double a1 = d1.age;
            Double a2 = d2.age;
            
            return a1.compareTo(a2);
            
            /*
             * or we could write the `if clause`
             * if (d1.age > d2.age)
             * return 1;
             * if (d1.age < d2.age)
             * return -1;
             * return 0;
             */
        }
    };
}
