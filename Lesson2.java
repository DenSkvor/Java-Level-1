import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {
	// Задание 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
    // 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] arrSample = {0,1,0,1,1,1,0};

        System.out.println("Задание 1.\nИзначальный массив:\n" + Arrays.toString(arrSample));

        for(int i = 0; i < arrSample.length; i++){
            if(arrSample[i] == 0 ) arrSample[i] = 1;
            else arrSample[i] = 0;
        }

        System.out.println("Измененный массив:\n" + Arrays.toString(arrSample) + "\n");

    //Задание 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
    //значениями 0 3 6 9 12 15 18 21;

        int[] arrSample2 = new int[8];

        for(int i = 0, j = 0; i < arrSample2.length; i++, j+=3) arrSample2[i] = j;

        System.out.println("Задание 2.\n" + Arrays.toString(arrSample2) + "\n");

    //Задание 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
    //умножить на 2;

        int[] arrSample3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Задание 3.\nИзначальный массив:\n" + Arrays.toString(arrSample3));

        for(int i = 0; i < arrSample3.length; i++) if(arrSample3[i] < 6) arrSample3[i] *= 2;

        System.out.println("Измененный массив:\n" + Arrays.toString(arrSample3) + "\n");

    //Задание 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
    //одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        int[][] arrSample4 = new int[5][5];

        for(int i = 0; i < arrSample4.length; i++) {
            arrSample4[i][i] = 1;
            arrSample4[i][arrSample4.length - 1 - i] = 1;
        }
        System.out.println("Задание 4.\n");

        twoDimArrPrint(arrSample4);

        System.out.println();

    //Задание 5.** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
    //помощи интернета);

        double[] arrSample5 = {1.2, -3.4, 5.6, 7.8, 0.9};
        double minValue = arrSample5[0];
        double maxValue = arrSample5[0];

        System.out.println("Задание 5.\nИсходный массив:\n" + Arrays.toString(arrSample5));

        for(int i = 1; i < arrSample5.length; i++){
            if(arrSample5[i] < minValue) minValue = arrSample5[i];
            if(arrSample5[i] > maxValue) maxValue = arrSample5[i];
        }
        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Максимальное значение: " + maxValue + "\n");

    //Задание 6.** Написать метод, в который передается не пустой одномерный целочисленный массив,
    //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
    //массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
    //2, 1]) → true, граница показана символами ||, эти символы в массив не входят.

        int[] arrSample6 = {1, 4, 1, 2, 2, 1, 1};
        System.out.println("Задание 6.\nИсходный массив:\n" + Arrays.toString(arrSample6));

        if(doTusk6(arrSample6)) System.out.println("Такое место нашлось!\n");
        else System.out.println("Такого места не нашлось.\n");

    //Задание 7.**** Написать метод, которому на вход подается одномерный массив и число n (может быть
    //положительным, или отрицательным), при этом метод должен сместить все элементы
    //массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными
    //массивами.

        int[] arrSample7 = {1, 2, 3, 4, 5};
        System.out.println("Задание 7.\nИсходный массив:\n" + Arrays.toString(arrSample7));

        System.out.println("Массив со сдвинутыми элементами:");
        doTusk7(arrSample7, 1);

    }


    /////////////////////////методы/////////////////////////////////////////////////////////////////////

    //К заданию 4. Метод, печатающий целочисленный двумерный массив

    public static void twoDimArrPrint(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    //К заданию 6.

    public static boolean doTusk6(int[] arr){
        for (int i = 1; i <= arr.length-3; i++){ // переменной i делим массив на две части
            int sumLeft = 0, sumRight = 0; // сумма слева и сумма справа, обнуляется при новой итерации
            for(int j = 0; j <= i ; j++){ // считаем сумму слева от i
                sumLeft += arr[j];
            }
            for(int k = arr.length - 1; k > i; k--){ // считаем сумму справа от i
                sumRight += arr[k];
            }
            if(sumLeft == sumRight) return true; // сравниваем суммы
        }
        return false;
    }

    //К заданию 7.

    public static void doTusk7(int[] arr, int n){
        // tempCell's - временные хранилища значений в меняемых местами ячейках массива
        int i = 1, tempCell1 = arr[0], tempCell2;
        //перевод отрицательного n в положительный эквивалент
        if(n < 0) n = n + arr.length + shiftValueCalculate(i, -n, arr.length) * (-n > arr.length ? 1 : 0);

        for(; i <= arr.length; i++){

            tempCell2 = arr[n * i - shiftValueCalculate(i, n, arr.length)];
            arr[n * i - shiftValueCalculate(i, n, arr.length)] = tempCell1;
            tempCell1 = tempCell2;

        }
        System.out.println(Arrays.toString(arr));
    }

    //К заданию 7.
    //Метод считает величину сдвига позиции элемента массива при переходах через край массива,
    //исходя из колличества таких переходов

    public static int shiftValueCalculate(int i, int n, int arrLength){

        return arrLength * (int)(n * i / arrLength);
    }


}
