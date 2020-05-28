abstract public class Animal {

    protected String name;
    protected String color;

    public Animal(String name, String color){
        this.name = name + " ";
        this.color = color + " ";
    }

    public Animal(){
    }

    abstract public void run(double length);

    abstract public void jump(double height);

    abstract public void swim(double length);

}
