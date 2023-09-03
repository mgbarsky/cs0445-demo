package zoo2;

public class PetStore {
    public static void main(String [] args) {
        Pet [] pets = new Pet [4];
        
        pets[0] = new Cat();
        pets[1] = new Cat();
        pets[2] = new Cat();
        pets[3] = new Dog();
        
        for (Pet p: pets) {
            p.play();
        }
    }
    

}
