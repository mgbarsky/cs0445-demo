package zoo2;

public class Dog extends Animal implements Pet{
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
    
    public void play() {
        System.out.println("Dog is playing");
        this.makeNoise();
    }

}
