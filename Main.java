import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        doAnimalsAction();

    }

    public static void doAnimalsAction(){
        Cat matroskin = new Cat("Матроскин", "Полосатый");
        Dog mukhtar = new Dog("Мухтар","Черный");
        Cat cat = new Cat();
        Dog dog = new Dog();

        matroskin.run(200);
        matroskin.jump(2);
        matroskin.swim(0);
        System.out.println(String.format(Locale.US,"макс бег %.1f, макс прыг %.1f",matroskin.getRunMax(), matroskin.getJumpMax()));
        System.out.println();

        mukhtar.run(500);
        mukhtar.jump(0.5);
        mukhtar.swim(10);
        System.out.println(String.format(Locale.US,"макс бег %.1f, макс прыг %.1f, макс плав %.1f",mukhtar.getRunMax(), mukhtar.getJumpMax(),mukhtar.getSwimMax()));
        System.out.println();

        cat.run(200);
        cat.jump(2);
        cat.swim(0);
        System.out.println(String.format(Locale.US,"макс бег %.1f, макс прыг %.1f",cat.getRunMax(), cat.getJumpMax()));
        System.out.println();

        dog.run(500);
        dog.jump(0.5);
        dog.swim(10);
        System.out.println(String.format(Locale.US,"макс бег %.1f, макс прыг %.1f, макс плав %.1f",dog.getRunMax(), dog.getJumpMax(), dog.getSwimMax()));
        System.out.println();

    }

}
