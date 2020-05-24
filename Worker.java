public class Worker {

    private String name;
    private String middleName;
    private String surname;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;

    public Worker(String name, String middleName, String surname, String position, String email, String phoneNumber,
           double salary, int age){
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printWorkerInfo(){
        System.out.println(name+" "+middleName+" "+surname+"\n"+position+"\n"+email+"\n"+phoneNumber+"\n"+salary+"\n"+age+"\n");
    }

    public int getAge(){
        return this.age;
    }



}
