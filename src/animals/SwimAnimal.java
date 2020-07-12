package animals;

public abstract class SwimAnimal extends GroundAnimal{
    private double maxSwim;

    public SwimAnimal(String name, double maxRun, double maxJump, double maxSwim) {
        super(name, maxRun, maxJump);
        this.maxSwim = maxSwim;
    }

    @Override
    public String toString() {
        return "animals.SwimAnimal{" +
                "name='" + getName() + '\'' +
                ", maxRun=" + getMaxRun() +
                ", maxJump=" + getMaxJump() +
                ", maxSwim=" + getMaxSwim() +
                '}';
    }

    protected double getMaxSwim() {
        return maxSwim;
    }

    public abstract String swim(double length);
}
