package zoo1;

public abstract class Animal {
    protected String name;
    protected int energyLevel;
    protected String diet;
    protected int x, y;
    
    public Animal() {
        this.name = "?";
        this.energyLevel = 100;
        this.x = 0;
        this.y=0; 
    }
    
    public Animal(String name) {
        this();
        this.name = name;              
    } 
    
    public Animal(String name, String diet) {
        this(name);        
        this.diet = diet;
    }    
    
    public String getName() {
        return this.name;
    }
    
    public void move(int dX, int dY) {
        this.x += dX;
        this.y += dY;
        this.energyLevel-=(dX + dY);
    }
    
    public void eat() {
        System.out.println(name + " is eating " + diet);
        this.energyLevel ++;
    }
    
    public void sleep() {
        this.energyLevel ++;
    }
    
    public abstract void makeNoise();
    
    public String toString() {
        return name + " is located at (" +x + "," + y + "). Energy level=" + this.energyLevel;
    }
}
