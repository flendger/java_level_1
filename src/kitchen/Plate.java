package kitchen;

public class Plate {
    private int food = 0;

    public void addFood(int food) {
        this.food = food;
    }

    public int takeFood(int food) {
        int eatenFood;

        if (this.food < food) {
            //съедаем только то, что есть в миске
            eatenFood = this.food;
        } else {
            //съедаем полностью то, что хотели съест
            eatenFood = food;
        }

        this.food = this.food - eatenFood;

        return eatenFood;
    }

    @Override
    public String toString() {
        return "kitchen.Plate{" +
                "food=" + food +
                '}';
    }
}
