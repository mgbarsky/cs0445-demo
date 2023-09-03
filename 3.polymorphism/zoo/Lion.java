package zoo;

public class Lion extends Animal{
    public Lion() {
        super("Lion", "deer");
    }
    
    public void eat() {
        System.out.println("Lion is eating " + diet);
        this.energyLevel += 4;
    }
    
    public void makeNoise() {
        System.out.println("RRRoar");
    }
}
