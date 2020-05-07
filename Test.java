package test;

import java.io.IOException;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) throws IOException {
       /*char symbol = 0;
       int spaceCount = 0;
        while (symbol != '.'){
            if (symbol == ' ') spaceCount++;
            symbol++;
        }
        System.out.println(symbol + "\n" + spaceCount);
*/
        /*
        char symbol = 0;
        int spaceCount = 0;
        Scanner scn = new Scanner(System.in);

        do {
            symbol = (char)scn.nextInt();

            if(symbol == ' ') spaceCount++;
        }while (symbol != '.');
        System.out.println(spaceCount);
        */
        //for(int i = 1000; i >= 0; i-=2) System.out.println(i);

        //for(int i = 1; i < 100; i*=2) System.out.println(i);
        /*
        int number = 99;
        char symbol;
        symbol = (char)number;
        System.out.println(symbol);
         */
/*
        char symbol, ignore;
        symbol = (char)System.in.read();


        do{
            ignore = (char) System.in.read();
        }while (ignore != '\n');

        System.out.println(symbol);
*/
/*
        char symbol, ignore;
        int change = 0;

    do {
        System.out.println("Введите букву. Точка - выход.");

        symbol = (char) System.in.read();

        do{
            ignore = (char) System.in.read();
        }while (ignore != '\n');

        if (symbol >= 65 & symbol <= 90) {
            symbol += 32;
            change++;
            System.out.println(symbol + "\n" + change);
        } else if (symbol >= 97 & symbol <= 122) {
            symbol -= 32;
            change++;
            System.out.println(symbol + "\n" + change);
        } else if (symbol != '.') {
            System.out.println("Вы ввели не букву");
        } else {
            System.out.println(change);
            break;
        }
    } while (symbol != '.');
*/
        /*
        stop:
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.println(i + " " + j);
                if(i + j == 12) break stop;
            }
        }
        System.out.println("Финиш");
        */

        char a, b, c, d;

        a = (char)System.in.read();
        b = (char)(System.in.read() + 88);
        c = (char)System.in.read();
        d = (char)(System.in.read() + 90);

        System.out.print(a + "_" + b + "_" + c + "_" + d + "_");

//////



    }


}
