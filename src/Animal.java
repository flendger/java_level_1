public abstract class Animal {
    private String name;
    private double maxRun;
    private double maxSwim;
    private double maxJump;

    public Animal(String name, double maxRun, double maxSwim, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", maxRun=" + maxRun +
                ", maxSwim=" + maxSwim +
                ", maxJump=" + maxJump +
                '}';
    }

    public String run(double length) {
        return String.format("Run {%.1f}: %s", length, (maxRun >= length && maxRun > 0 && length >= 0));
    }

    public String swim(double length) {
        return String.format("Swim {%.1f}: %s", length, (maxSwim >= length && maxSwim > 0 && length >= 0));
    }

    public String jump(double height) {
        return String.format("Jump {%.1f}: %s", height, (maxJump >= height && maxJump > 0 && height >= 0));
    }
}
