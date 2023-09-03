package zoo2;

public class Zoo {
    public static void main(String [] args) {
        Bear b = new Bear();
        b.move(4, 5);
        b.eat();
        b.sleep();
        
        Cat c = new Cat();
        c.move(10, 20);
        c.eat();
        c.sleep();
        
        System.out.println(b);
        System.out.println(c);      
    }
}
