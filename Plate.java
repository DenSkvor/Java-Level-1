public class Plate {

    private int plateCapacity;
    private int food;

    public Plate(int plateCapacity){
        if(plateCapacity < 0) this.plateCapacity = 0;
        else this.plateCapacity = plateCapacity;
        this.food = 0;
    }

    public int getPlateCapacity(){
        return plateCapacity;
    }

    public int getFoodQuantity(){
        return food;
    }

    public void decreaseFoodQuantity (int decreasedFoodQuantity){
        if(food - decreasedFoodQuantity < 0) food = 0;
        else food -= decreasedFoodQuantity;
    }

    public void increaseFoodQuantity (int increasedFoodQuantity){
        if(food + increasedFoodQuantity > plateCapacity) food = plateCapacity;
        else food += increasedFoodQuantity;
    }

}
