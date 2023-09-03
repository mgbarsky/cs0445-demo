package zoo2;

public class Cat extends Animal implements Pet{
    public Cat() {
        super("Cat", "mice");
    }
    
    public void eat() {
        System.out.println("Cat is eating " + diet);
        this.energyLevel += 3;
    }
    
    public void makeNoise() {
        System.out.println("Purrr");
    }  
    
    public void play() {
        System.out.println("Cat is playing");
        this.makeNoise();
    }

}
