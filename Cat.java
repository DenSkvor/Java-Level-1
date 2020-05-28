public class Cat extends Animal {

    protected double runMax;
    protected double jumpMax;


    public Cat(String name, String color){
        super(name, color);
        runMax = 100 + ((int) (Math.random() * 3)) * 100;
        jumpMax = 1 + (int)(Math.random() * 3);
    }

    public Cat(){
        name = "";
        color = "";
        runMax = 100 + ((int) (Math.random() * 3)) * 100;
        jumpMax = 1 + (int)(Math.random() * 3);
    }

    public double getRunMax(){
        return runMax;
    }

    public double getJumpMax(){
        return jumpMax;
    }

    @Override
    public void run(double length){
        if(length > runMax) System.out.println("Коты столько не бегают!");
        else if(length == 0) System.out.println(color + "кот " + name + "пробежал " + length + " м. " + "Бег на месте!");
        else System.out.println(color + "кот " + name + "пробежал " + length +  " м. ");
    }

    @Override
    public void jump(double height){
        if(height > jumpMax) System.out.println("Коты так не прыгают!");
        else if(height == 0) System.out.println(color + "кот " + name + "перепрыгнул " + height + " м. " + "Прыжок на месте!");
        else System.out.println(color + "кот " + name + "перепрыгнул " + height + " м. ");
    }

    @Override
    public void swim(double length){
        if(length == 0) System.out.println("Коты не плавают! " + "Зачем кота намочили?");
        else System.out.println("Коты не плавают!");
    }


}
