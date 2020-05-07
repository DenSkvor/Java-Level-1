public class Lesson1 {

    public static void main(String[] args) {
        // Задание 1: Создать пустой проект в IntelliJ IDEA и прописать метод main()

        // Задание 2: Создать переменные всех пройденных типов данных, и инициализировать их значения
        byte b = 99;
        short s = 9999;
        int i = 999999999;
        long l = 999999999999999999L;
        char c = '9';
        char C = 9;
        float f = 9.9F;
        double d = 9.9;
        String str = "Nine";

        // Задание 3: Написать метод вычисляющий выражение a * (b + (c / d))
        // и возвращающий результат,где a, b, c, d – входные параметры этого метода
        System.out.println("Задание 3");
        System.out.println(doTask3(2,2.5,1,2));
        System.out.println();

        // Задание 4: Написать метод, принимающий на вход два числа и проверяющий,
        // что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false
        System.out.println("Задание 4");
        System.out.println(doTask4(10,5));
        System.out.println();

        // Задание 5: Написать метод, которому в качестве параметра передается целое число,
        // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
        // Замечание: ноль считаем положительным числом
        System.out.println("Задание 5");
        doTask5(5);
        System.out.println();

        // Задание 6: Написать метод, которому в качестве параметра передается целое число,
        // метод должен вернуть true, если число отрицательное
        System.out.println("Задание 6");
        System.out.println(doTask6(-5));
        System.out.println();

        // Задание 7: Написать метод, которому в качестве параметра передается строка,
        // обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»
        System.out.println("Задание 7");
        doTask7("Денис");
        System.out.println();

        // Задание 8*: Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный
        System.out.println("Задание 8");
        doTask8(2020);
    }

/////////////////////////////Методы////////////////////////////////////////////

    // Задание 3: Написать метод вычисляющий выражение a * (b + (c / d))
    // и возвращающий результат,где a, b, c, d – входные параметры этого метода
    public static double doTask3(double a,double b, double c, double d){
        return a * (b + (c / d));

    }

    // Задание 4: Написать метод, принимающий на вход два числа и проверяющий,
    // что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    public static boolean doTask4(double a, double b){
        double c = a + b;
        if(c >= 10 & c <= 20) return true;
        else return false;
    }

    // Задание 5: Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
    // Замечание: ноль считаем положительным числом
    public static void doTask5(int a){
        if(a >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    // Задание 6: Написать метод, которому в качестве параметра передается целое число,
    // метод должен вернуть true, если число отрицательное
    public static boolean doTask6(int a){
        if(a < 0) return true;
        else return false;
    }

    // Задание 7: Написать метод, которому в качестве параметра передается строка,
    // обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»
    public static void doTask7(String textName){
        System.out.println("Привет, " + textName + "!");
    }

    // Задание 8*: Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный
    /*
    public static void task8(int year){
        if(year % 400 == 0){
            System.out.println("Год високосный");
        } else if(year % 100 == 0){
            System.out.println("Год не високосный");
        } else if(year % 4 == 0){
            System.out.println("Год високосный");
        } else System.out.println("Год не високосный");
    }
    */
    public static void doTask8(int year){
        if(year % 400 !=0 && (year % 100 == 0 | year % 4 != 0)) {
            System.out.println("Год не високосный");
        } else System.out.println("Год високосный");
    }

}
