import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    //переменные///////////////////////////////////////////

    //В методичке переменные были вынесены за методы, сделал так же.

    public static final char SIGN_X = 'X';
    public static final char SIGN_O = 'O';
    public static final char SIGN_EMPTY = '.';

    public static int pastX; // Х координата прошлого хода человека
    public static int pastY; // У координата прошлого хода человека
    public static int currentX; // Х координата текущего хода человека
    public static int currentY; // У координата текущего хода человека

    public static int winLength;

    public static int tableSize;

    public static char [][] table;

    public static Random rndm = new Random();
    public static Scanner scn = new Scanner(System.in);


    //методы///////////////////////////////////////////////

    public static void main(String[] args) {

        playGame();
    }

    //игра
    public static void playGame(){
        System.out.println("Добро пожаловать в игру крестики-нолики!\n");

        //определение размера и создание игрового поля
        int choice;
        do {
            do {
                System.out.println("Выберите длину стороны игрового поля (от 3 до 99)");
                tableSize = scn.nextInt();
                if(tableSize < 3||99 < tableSize) System.out.println("Некорректный ввод!");
            } while(tableSize < 3||99 < tableSize);

            table = new char [tableSize][tableSize];

            makeTable();
            showTable();

            //необходимо для первого хода компьютера
            currentX = rndm.nextInt(tableSize);
            currentY = rndm.nextInt(tableSize);

            //условие победы зависит от размера поля
            if(tableSize == 3 || tableSize == 4) winLength = 3;
            else if(tableSize == 5) winLength = 4;
            else winLength = 5; // условие победы согласно правилам игры на "бесконечном" поле

            System.out.println("Для победы необходимо собрать в ряд " + winLength + ((winLength < 5) ? " фишки" : " фишек"));
            System.out.println();

            //ход человека
            for (;;) {
                System.out.println("Ход человека");
                doHumanTurn();
                showTable();
                if (checkWin(SIGN_X)) {
                    System.out.println("Человек победил!");
                    break;
                }
                if (chekIsTableFull()) {
                    System.out.println("Ничья.");
                    break;
                }

            //ход компьютера
                System.out.println("Ход компьютера");
                doComputerTurn();
                showTable();
                if (checkWin(SIGN_O)) {
                    System.out.println("Компьютер победил!");
                    break;
                }
                if (chekIsTableFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }

            System.out.println("Игра окончена!");

            do {
                System.out.println("Ещё раз? да - 1, нет - 0");
                choice = scn.nextInt();
                if(choice != 0 && choice != 1) System.out.println("Некорректный ввод!");
            }while (choice != 0 && choice != 1);

        } while (choice == 1);
        scn.close();

    }

    //вспомогательные методы/////////////////////////////

    //создание стола
    public static void makeTable(){

        for(int y = 0; y < tableSize; y++){
            for(int x = 0; x < tableSize; x++){
                table[y][x] = SIGN_EMPTY;
            }
        }
    }

    //отображение стола
    public static void showTable(){
        //нумерация столбцов
        System.out.print(" " + 0 + "  ");
        for (int i = 0; i <tableSize; i++) System.out.print((i + 1) + (i < 9 ? "  " : " "));

        System.out.println();
        for(int y = 0; y < tableSize; y++){
            System.out.print((y < 9 ? " " : "") + (y + 1) + "  "); //нумерация строк
            for(int x = 0; x < tableSize; x++){
                System.out.print(table[y][x] + "  ");
            }
            System.out.println();
        }
    }

    //проверка корректности ячейки
    public static boolean checkIsCellValid(int y, int x){
        if(y < 0 || y >= tableSize || x < 0 || x >= tableSize || table[y][x] != SIGN_EMPTY){
            //System.out.println("Некорректная ячейка"); для отладки
            return false;
        } else return true;
    }

    //ход человека
    public static void doHumanTurn(){
        pastY = currentY;
        pastX = currentX;
        do {
            System.out.println("Введите номер столбца (от 1 до " + tableSize + ")");
            currentX = scn.nextInt() - 1;
            System.out.println("Введите номер строки (от 1 до " + tableSize + ")");
            currentY = scn.nextInt() - 1;
            if (!checkIsCellValid(currentY, currentX)) System.out.println("Некорректная ячейка!");
        } while (!checkIsCellValid(currentY, currentX));
        table[currentY][currentX] = SIGN_X;
    }

    //ход компьютера

    /* Простой рандомный ход
    public static void doComputerTurn(){
        int x, y;
        do {
            y = rndm.nextInt(tableSize);
            x = rndm.nextInt(tableSize);
        } while (!checkIsCellValid(y, x));
        table[y][x] = SIGN_O;
    }
    */
    public static void doComputerTurn (){
        //Логика: запоминаются координаты двух последних ходов человека, сравниваются. Таким образом определяется
        //направление, в котором выстраивает свой ряд человек. Перед этим рядом компьютер пытается поставить ноль,
        //если не может, пытается поставить с другого конца ряда. Если не может, ставит в рандомном месте в области
        //3 на 3 вокруг последнего хода человека. Если не может, ставит в рандомном месте всего поля.

        //определяем направление текущего хода человека относительно предыдущего
        int directionY = currentY - pastY;
        int directionX = currentX - pastX;

        //выбираем действие исходя из направления, ставим симовл так, чтобы перекрыть путь
        if (directionY == 0 && directionX < 0) { //текущий ход был "на 9 часов" относительно предпоследнего, т.е. игрок движется налево
            goToLeftOrRight(-1);
            return;
        }
        if (directionY == 0 && directionX > 0) { //текущий ход на 3, направо
            goToLeftOrRight(+1);
            return;
        }
        if (directionY < 0 && directionX == 0) { //текущий ход на 12, вверх
            goToUpOrDawn(-1);
            return;
        }
        if (directionY > 0 && directionX == 0) { //текущий ход на 6, вниз
            goToUpOrDawn(+1);
            return;
        }
        if (directionY < 0 && directionX > 0) { //текущий ход на 1.5, вверх и направо
            goToMinorDiagonal(-1);
            return;
        }
        if (directionY > 0 && directionX < 0) { //текущий ход на 7.5, вниз и налево
            goToMinorDiagonal(+1);
            return;
        }
        if (directionY < 0 && directionX < 0) { //текущий ход на 10.5, вверх и налево
            goToMainDiagonal(-1);
            return;
        }
        if (directionY > 0 && directionX > 0) { //текущий ход на 4.5, вниз и направо
            goToMainDiagonal(+1);

        } else if (checkIsFieldValid(currentY, currentX)) { //на случай, если первый ход человека совпадет с рандомным
            doLimitedRandomTurn();

        } else doFullRandomTurn();

    }

    public static void goToLeftOrRight(int directionSign) { //directionSign: -1 налево, +1 направо
        if (checkIsCellValid(currentY, currentX + directionSign)) {
            table[currentY][currentX + directionSign] = SIGN_O;

        } else {
            for (int i = 1; i <= winLength - 1; i++) {
                if (checkIsCellValid(currentY, currentX - i * directionSign)) {
                    table[currentY][currentX - i * directionSign] = SIGN_O;
                    return;
                }
            }
            if (checkIsFieldValid(currentY, currentX)) {
                doLimitedRandomTurn();
            }
            else doFullRandomTurn();
        }
    }

    public static void goToUpOrDawn(int directionSign) { //directionSign: -1 вверх, +1 вниз
        if (checkIsCellValid(currentY + directionSign, currentX)) {
            table[currentY + directionSign][currentX] = SIGN_O;

        } else {
            for (int i = 1; i <= winLength - 1; i++) {
                if (checkIsCellValid(currentY - i * directionSign, currentX)) {
                    table[currentY - i * directionSign][currentX] = SIGN_O;
                    return;
                }
            }
            if (checkIsFieldValid(currentY, currentX)) {
                doLimitedRandomTurn();
            }
            else doFullRandomTurn();
        }
    }

    public static void goToMainDiagonal(int directionSign){ //directionSign: -1 вверх и влево, +1 вниз и вправо
        if (checkIsCellValid(currentY + directionSign, currentX + directionSign)) {
            table[currentY + directionSign][currentX + directionSign] = SIGN_O;

        } else {
            for (int i = 1; i <= winLength - 1; i++) {
                if (checkIsCellValid(currentY - i * directionSign, currentX - i * directionSign)) {
                    table[currentY - i * directionSign][currentX - i * directionSign] = SIGN_O;
                    return;
                }
            }
            if (checkIsFieldValid(currentY, currentX)) {
                doLimitedRandomTurn();
            }
            else doFullRandomTurn();
        }
    }

    public static void goToMinorDiagonal(int directionSign){ //directionSign: -1 вверх и вправо, +1 вниз и влево
        if (checkIsCellValid(currentY + directionSign, currentX - directionSign)) {
            table[currentY + directionSign][currentX - directionSign] = SIGN_O;

        } else {
            for (int i = 1; i <= winLength - 1; i++) {
                if (checkIsCellValid(currentY - i * directionSign, currentX + i * directionSign)) {
                    table[currentY - i * directionSign][currentX + i * directionSign] = SIGN_O;
                    return;
                }
            }
            if (checkIsFieldValid(currentY, currentX)) {
                doLimitedRandomTurn();
            }
            else doFullRandomTurn();
        }
    }

    //проверка области 3 на 3 клетки вокруг текущего хода человека на наличие валидной ячейки
    public static boolean checkIsFieldValid(int y, int x){
        int validCellCount = 0;
        for(int i = y - 1; i <= y + 1; i++){
            if(i < 0 || i > tableSize - 1) continue;
            for(int j = x - 1; j <=x + 1; j++){
                if(j < 0 || j > tableSize - 1) continue;
                if(checkIsCellValid(i, j)) validCellCount++;
            }
        }
        if(validCellCount != 0) return true;
        return false;
    }

    public static void doLimitedRandomTurn(){
        int deltaY, deltaX;
        do {
            deltaY = rndm.nextInt(3);
            deltaX = rndm.nextInt(3);
        } while (!checkIsCellValid((currentY - 1) + deltaY, (currentX - 1) + deltaX));
        table[(currentY - 1) + deltaY][(currentX - 1) + deltaX] = SIGN_O;
    }

    public static void doFullRandomTurn(){
        int y, x;
        do {
            y = rndm.nextInt(tableSize);
            x = rndm.nextInt(tableSize);
        } while (!checkIsCellValid(y, x));
        table[y][x] = SIGN_O;
    }

    //проверка победы
    public static boolean checkWin(char SIGN_DOT){

        int check = 0; //счетчик фишек идущих подряд

        for(int i = 0; i < tableSize; i++) {
            //проверка строки
            for (int j = 0; j < tableSize; j++) {
                if (table[i][j] == SIGN_DOT) {
                    check++;
                    if (check == winLength){
                        return true;
                    }
                } else {
                    check = 0;
                }
            }
            check = 0;
            //проверка столбца
            for (int j = 0; j < tableSize; j++) {
                if (table[j][i] == SIGN_DOT) {
                    check++;
                    if (check == winLength){
                        return true;
                    }
                } else {
                    check = 0;
                }
            }
            check = 0;
        }

        //проверка диагоналей \
        for (int i = 0; i < tableSize; i++) {
            for(int j = 0; j < tableSize - i; j++) {
                if (table[j + i][j] == SIGN_DOT) {
                    check++;
                    if (check == winLength) {
                        return true;
                    }
                } else {
                    check = 0;
                }
            }
            check = 0;
            for(int j = 0; j < tableSize - i; j++) {
                if (table[j][j + i] == SIGN_DOT) {
                    check++;
                    if (check == winLength) {
                        return true;
                    }
                } else {
                    check = 0;
                }
            }
            check = 0;
        }

        //проверка диагоналей /
        for (int i = 0; i < tableSize; i++) {
            for(int j = 0; j < tableSize - i; j++) {
                if (table[j + i][(tableSize - 1) - j] == SIGN_DOT) {
                    check++;
                    if (check == winLength) {
                        return true;
                    }
                } else {
                    check = 0;
                }
            }
            check = 0;
            for(int j = 0; j < tableSize - i; j++) {
                if (table[j][((tableSize - 1) - j) - i] == SIGN_DOT) {
                    check++;
                    if (check == winLength) {
                        return true;
                    }
                } else {
                    check = 0;
                }
            }
            check = 0;
        }
        return false;
    }

    //проверка на ничью
    public static boolean chekIsTableFull(){
        int emptyCellCount = 0;
        for(int i = 0; i < tableSize; i++){
            for(int j = 0; j < tableSize; j++){
                if(table[i][j] == SIGN_EMPTY){
                    emptyCellCount++;
                }
            }
        }
        if(emptyCellCount == 0){
            return true;
        }
        return false;
    }

}
