import animals.Cat;
import kitchen.Plate;

public class DemoAnimals {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("cat1", 150, 2, 10),
                      new Cat("cat2", 150, 2, 7),
                      new Cat("cat3", 150, 2, 8)};

        Plate plate1 = new Plate();
        plate1.addFood(20);
        System.out.println(plate1);
        System.out.println();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eatFood(plate1);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
        System.out.println();

        System.out.println(plate1);
    }
}
