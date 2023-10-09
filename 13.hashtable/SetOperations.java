
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class SetOperations {
    private static Set<Integer> setOf(Integer [] values) {
        
        return new HashSet<Integer>(Arrays.asList(values));
    }
    
    private Set<Integer> setA ;
    private Set<Integer> setB ;
    
    public SetOperations (Integer [] arrayA, Integer [] arrayB){
        this.setA = setOf(arrayA);
        this.setB = setOf(arrayB);
            
        
    }
    
    public Set<Integer> intersection(){
        Set<Integer> intersectSet = new HashSet<>(setA);
        intersectSet.retainAll(setB);
        return intersectSet;
    }
    
    public Set<Integer> union(){
        Set<Integer> unionSet = new HashSet<>(setA);
        unionSet.addAll(setB);
        return unionSet;
    }
    
    public Set<Integer> difference(){
        Set<Integer> differenceSet = new HashSet<>(setA);
        differenceSet.removeAll(setB);
        return differenceSet;
    }
    
    public static void main(String [] args) {
        Integer [] a = {1,2,3,4};
        Integer [] b = {2,4,5,6};
        
        SetOperations sop = new SetOperations(a, b);
        System.out.println("Set A: " + sop.setA);
        System.out.println("Set B: " + sop.setB);
        System.out.println("Intersection AB: " + sop.intersection());
        System.out.println("Union A U B: " + sop.union());
        System.out.println("Difference A - B: " + sop.difference());
        
    }
}