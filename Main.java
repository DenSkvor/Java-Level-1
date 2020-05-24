public class Main {

    //решил, что список сотрудников логичнее вынести в отдельный класс
    
    public static void main(String[] args) {

        showWorkersOlderThan40();

    }

    public static void showWorkersOlderThan40(){
        WorkersBase workers = new WorkersBase();

        for(int i = 0; i < workers.getWorkersArrayLength(); i++){
            if(checkAgeAbove40(workers.getWorkerInfo(i).getAge())) workers.getWorkerInfo(i).printWorkerInfo();
        }
    }

    public static boolean checkAgeAbove40(int age){
        if(age > 40) return true;
        else return false;
    }
}
