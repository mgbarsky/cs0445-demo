package javasorting;
import java.util.Comparator;

public class HeightComparator implements Comparator<Dog> {
    public int compare(Dog d1, Dog d2) {
        return d1.height - d2.height;
    }
}
