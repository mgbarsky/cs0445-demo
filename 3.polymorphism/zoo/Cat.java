package zoo;

public class Cat extends Animal{
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
}
