import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        chooseTheGame();

    }



    ///////методы//////////////////////////////////////////////////////////////

    //Задача 1. Игра "угадай число"

    public static void playGameGuesTheNumber(){

        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);

        int guessedNumber; // под загаданное число
        int userAnswer; // под ответ игрока
        int tryCounts = 3; // количество попыток на игру
        int tryCountsLost; // счетчик потраченных попыток

        do {
            System.out.println("Добро пожаловать в игру \"Угадай число\".\nКомпьютер загадал число от 0 до 9, Вам необходимо угадать его.\n" +
                    "У Вас " + tryCounts + " попытки.\n");

            tryCountsLost = 0; // инициализация и обнуление счетчика

            do {
                //guessedNumber = 5; //для отладки
                guessedNumber = rnd.nextInt(10);

                System.out.println("Введите число:");
                userAnswer = scn.nextInt();

                if (userAnswer > guessedNumber) {
                    tryCountsLost++;
                    System.out.println("Загаданное число меньше.\nУ Вас осталось попыток: " + (tryCounts - tryCountsLost) + "\n");
                } else if (userAnswer < guessedNumber) {
                    tryCountsLost++;
                    System.out.println("Загаданное число больше.\nУ Вас осталось попыток: " + (tryCounts - tryCountsLost) + "\n");
                } else {
                    System.out.println("Вы угадали!\n");
                    break;
                }
            } while (tryCountsLost < tryCounts);

            if (userAnswer != guessedNumber) System.out.println("Вы истратили все попытки, но не угадали число. Вы проиграли.");

            System.out.println("Повторить игру еще раз? 1 - да, 0 - нет");
            userAnswer = scn.nextInt();
        }while (userAnswer == 1);

        System.out.println("Игра окончена!\n");

    }

    //Задача 2. Игра "угадай слово"

    //Добавил простые подсказки к каждому слову, иначе игра выглядит как-то странно.

    public static void playGameGuessTheWord(){

        String[][] wordsAndHints = {
                {"apple", "fruit"},
                {"orange","citrus"},
                {"lemon", "citrus"},
                {"banana", "fruit"},
                {"apricot", "fruit"},
                {"avocado", "fruit"},
                {"broccoli", "vegetable"},
                {"carrot", "vegetable"},
                {"cherry", "berry"},
                {"garlic", "vegetable"},
                {"grape", "berry"},
                {"melon", "fruit"},
                {"leak", "wut?"},
                {"kiwi", "fruit"},
                {"mango", "fruit"},
                {"mushroom", "hat on leg"},
                {"nut","gift from squirrel"},
                {"olive", "for oil"},
                {"pea", "pod"},
                {"peanut", "nut"},
                {"pear", "fruit"},
                {"pepper","red hot"},
                {"pineapple", "fruit"},
                {"pumpkin", "vegetable"},
                {"potato", "vegetable"}
        };

        char[] answerSymbols = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}; //набор символов, формирующих ответ
        char wordSymbol; //под символ из загаданного слова для сравнения с символом из ответа игрока
        char userAnswerSymbol; //под символ из ответа игрока
        int guessedSymbols; //число угаданных букв
        String userAnswer; //под ответ игрока
        int wordNumber; //для рандомного номера, определяющего положение загадываемого слова в массиве

        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);

        //wordNumber = 0; //для отладки
        wordNumber = rnd.nextInt(wordsAndHints.length); //рандомно выбираем номер слова из массива (загадываем слово)

        System.out.println("Hello! You must guess some word.\nHint: " + wordsAndHints[wordNumber][1]);

        do {
            System.out.println("Put your word in the console");

            userAnswer = scn.nextLine(); // ответ игрока

            // сравниваем ответ игрока с загаданным словом
            guessedSymbols = 0; //обнуляем счетчик
            for (int i = 0; i < wordsAndHints[wordNumber][0].length(); i++) {
                wordSymbol = wordsAndHints[wordNumber][0].charAt(i);
                userAnswerSymbol = (i < userAnswer.length() ? userAnswer.charAt(i) : ' '); //проверка на случай, если введенное слово короче загаданного
                if (userAnswerSymbol == wordSymbol) {
                    answerSymbols[i] = wordSymbol;
                    guessedSymbols++;
                }
            }
            //печатаем "ответ"
            for (int i = 0; i < answerSymbols.length; i++) System.out.print(answerSymbols[i]);
            System.out.println();

        } while (guessedSymbols != wordsAndHints[wordNumber][0].length());

        //на случай ввода более длинного слова, содержащего в себе загаданное
        if (guessedSymbols == wordsAndHints[wordNumber][0].length() && userAnswer.length() > wordsAndHints[wordNumber][0].length()){
            System.out.println("You guessed letters but not the word. It's just luck.\n");
        } else System.out.println("Congratulations! You guessed it!\n");

    }

    //Выбор игры

    public static void chooseTheGame(){
        int userChoice;
        Scanner scn = new Scanner(System.in);
        do {
            System.out.println("Выберите игру: \n\"Угадай число\" - 1\n\"Угадай слово\" - 2\nВыход - 0\n");
            userChoice = scn.nextInt();
            switch (userChoice) {
                case 1:
                    playGameGuesTheNumber();
                    break;
                case 2:
                    playGameGuessTheWord();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Ошибка! Некорректный ввод!\n");
            }
        } while (userChoice !=0);

        scn.close();

    }
    
}
