package animals;

public abstract class Animal {
    private String name;
    private double maxRun;
    private double maxJump;

    public Animal(String name, double maxRun, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public String toString() {
        return "animals.Animal{" +
                "name='" + name + '\'' +
                ", maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                '}';
    }

    protected String getName() {
        return name;
    }

    protected double getMaxRun() {
        return maxRun;
    }

    protected double getMaxJump() {
        return maxJump;
    }

    public abstract String run(double length);
    public abstract String jump(double height);
}
