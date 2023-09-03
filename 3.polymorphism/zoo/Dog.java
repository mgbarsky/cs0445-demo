package zoo;

public class Dog extends Animal{
    public Dog() {
        super("Dog", "bone");
    }
    
    public void eat() {
        System.out.println("Dog is eating " + diet);
        this.energyLevel += 3;
    }
    
    public void makeNoise() {
        System.out.println("Wuff");
    }
}
