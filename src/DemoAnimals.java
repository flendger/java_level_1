public class DemoAnimals {
    public static void main(String[] args) {
        Cat cat1 = new Cat("cat1");
        System.out.println(cat1);
        System.out.println(cat1.run(150));
        System.out.println(cat1.swim(0));
        System.out.println(cat1.jump(2));
        System.out.println();

        Dog dog1 = new Dog("dog1");
        System.out.println(dog1);
        System.out.println(dog1.run(600));
        System.out.println(dog1.swim(9));
        System.out.println(dog1.jump(0.4));
        System.out.println();

        Dog dog2 = new Dog("dog2", 600, 5, 0.2);
        System.out.println(dog2);
        System.out.println(dog2.run(600));
        System.out.println(dog2.swim(9));
        System.out.println(dog2.jump(0.4));

        Dog dog3 = new Dog("dog3", 400, 5, 0.2);
        System.out.println(dog3);
        System.out.println(dog3.run(600));
        System.out.println(dog3.swim(9));
        System.out.println(dog3.jump(0.4));

    }
}
