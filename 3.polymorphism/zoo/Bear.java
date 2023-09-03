package zoo;

public class Bear extends Animal {   
    public Bear() {
        super("Bear", "honey");
    }
    
    public void eat() {
        System.out.println("Bear is eating " + diet);
        this.energyLevel += 2;
    }
    
    public void makeNoise() {
        System.out.println("OOO");
    }
}
