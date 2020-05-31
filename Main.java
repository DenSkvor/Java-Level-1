import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        giveFoodToCats();

    }

    public static void giveFoodToCats(){
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Матроскин", 10);
        cats[1] = new Cat("Котёнок Гав",3);
        cats[2] = new Cat("Кот учёный", 8);

        Plate plate = new Plate(11);

        if(plate.getPlateCapacity() == 0){
            System.out.println("Пустая тарелка не годится!");
            return;
        }

        plate.increaseFoodQuantity(plate.getPlateCapacity());

        for(int i = 0; i < cats.length; i++){
            if (cats[i].getSatiety()){
                System.out.println(cats[i].getName() + " сыт? " + cats[i].getSatiety() + "\n");
            }
            else {
                cats[i].eat(plate);
                System.out.println(cats[i].getName() + " сыт? " + cats[i].getSatiety() + "\n");
            }
        }

        //здесь кончается ДЗ и начинается самодеятельность//////////////////////////////
        //Докармливаем котов

        feedThemAll(cats, plate);

    }


    public static void feedThemAll(Cat[] cats, Plate plate){
        int hungryCatsCount = 0;
        Scanner scn = new Scanner(System.in);

        //есть ли голодные?
        for (int i = 0; i < cats.length; i++) {
            if (!cats[i].getSatiety()) {
                hungryCatsCount++;
            }
        }
        //кормить будем?
        while (hungryCatsCount > 0) {
            int userChoice;
            do {
                System.out.println("Докормить котов? Да - 1, Нет - 0");
                userChoice = scn.nextInt();
                if (userChoice == 0) {
                    System.out.println("Обидели котов!");
                    return;
                }
                else if (userChoice != 1) System.out.println("Некорректный ввод!");
            } while (userChoice != 1);

            //кормим
            plate.increaseFoodQuantity(plate.getPlateCapacity());

            for (int i = 0; i < cats.length; i++) {
                if (!cats[i].getSatiety()) {
                    cats[i].eat(plate);
                    System.out.println(cats[i].getName() + " сыт? " + cats[i].getSatiety() + "\n");
                    if(cats[i].getSatiety())hungryCatsCount--;
                }
            }
        }
        //помыли миску
        if(plate.getFoodQuantity() != 0) plate.decreaseFoodQuantity(plate.getFoodQuantity());

        System.out.println("Все коты сыты!");

        scn.close();
    }
}
