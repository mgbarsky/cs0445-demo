package zoo1;

public class Animals {
    public static void main(String [] args) {
        Animal [] animals = new Animal[3];
        
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Lion();
        
        for (Animal a: animals) {
            System.out.println(a);
            a.makeNoise();
        }
    }
}
