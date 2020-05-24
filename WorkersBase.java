public class WorkersBase {

    private Worker[] workersArray = {

            new Worker("Ivan", "Ivanovich", "Anykeev", "Engineer",
                    "ivanov@mail.ru","89211234567", 100000, 35),

            new Worker("Dmitriy", "Dmitrievich", "Cucumber", "cook",
                    "cucumber@mail.ru","89110134567", 900000, 45),

            new Worker("Vasiliy", "Vasilievich", "Grablin", "Gardener",
                    "grablin@mail.ru","89211567867", 600000, 41),

            new Worker("Olga", "Olegovna", "Zarplatina", "Bookkeeper",
                    "zarplatina@mail.ru","89214532567", 100000, 39),

            new Worker("Leonid", "Leonidovich", "Zloy", "Security",
                    "zloy@mail.ru","89211321467", 50000, 56)

    };

    public Worker getWorkerInfo(int number){
        do {
            if(number < 0 || number > workersArray.length) System.out.println("Такого номера в списке нет!");
        } while (number < 0 || number > workersArray.length);

        return workersArray[number];
    }

    public int getWorkersArrayLength(){
        return workersArray.length;
    }

}
