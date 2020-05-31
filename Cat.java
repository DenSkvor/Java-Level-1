public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        if(appetite > 0) satiety = false;
        else satiety = true;
    }

    public boolean getSatiety(){
        return satiety;
    }

    public String getName(){
        return name;
    }

    public void eat(Plate object){
        if(checkIsFoodEnough(object)) {
            object.decreaseFoodQuantity(appetite);
            satiety = true;
            appetite = 0;
        } else {
            int food = object.getFoodQuantity();
            object.decreaseFoodQuantity(appetite);
            appetite -= food;
            System.out.println("В миске кончилась еда.\n" +
                    name + " требует еды ещё: " + appetite);
        }
    }

    public boolean checkIsFoodEnough(Plate object){
        if((object.getFoodQuantity() - appetite) < 0) return false;
        else return true;
    }
}
