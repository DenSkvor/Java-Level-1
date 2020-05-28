public class Dog extends Animal {

    protected double runMax;
    protected double jumpMax;
    protected double swimMax;

    public Dog(String name, String color){
        super(name, color);
        runMax = 400 + ((int)(Math.random() * 3)) * 100;
        jumpMax = 0.4 + ((int)(Math.random() * 3)) * 0.1;
        swimMax = 9 + (int)(Math.random() * 3);
    }

    public Dog(){
        name = "";
        color = "";
        runMax = 400 + ((int)(Math.random() * 3)) * 100;
        jumpMax = 0.4 + ((int)(Math.random() * 3)) * 0.1;
        swimMax = 9 + (int)(Math.random() * 3);
    }

    public double getRunMax(){
        return runMax;
    }

    public double getJumpMax(){
        return jumpMax;
    }

    public double getSwimMax(){
        return swimMax;
    }

    @Override
    public void run(double length){
        if(length > runMax) System.out.println("Собаки столько не бегают!");
        else if(length == 0) System.out.println(color + "собакен " + name + "пробежал " + length + " м. " + "Бег на месте!");
        else System.out.println(color + "собакен " + name + "пробежал " + length + " м. ");

    }

    @Override
    public void jump(double height){
        if(height > jumpMax) System.out.println("Собаки так не прыгают!");
        else if(height == 0) System.out.println(color + "собакен " + name + "перепрыгнул " + height + " м. " + "Прыжок на месте!");
        else System.out.println(color + "собакен " + name + "перепрыгнул " + height + " м. ");
    }

    @Override
    public void swim(double length){
        if(length > swimMax) System.out.println("Собаки столько не плавают!");
        else if(length == 0) System.out.println(color + "собакен " + name + "проплыл " + length + " м. " + "Искупнулся!");
        else System.out.println(color + "собакен " + name + "проплыл " + length + " м. ");

    }

}
