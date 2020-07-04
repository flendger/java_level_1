public class Dog extends Animal {
    public Dog(String name) {
        super(name, 500, 10, 0.5);
    }
    public Dog(String name, double maxRun, double maxSwim, double maxJump) {
        super(name, maxRun, maxSwim, maxJump);
    }
}
