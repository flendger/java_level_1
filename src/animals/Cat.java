package animals;

import kitchen.Plate;

public class Cat extends GroundAnimal{
    private int currentSatiety = 0;
    private int maxSatiety;

    public Cat(String name, double maxRun, double maxJump, int maxSatiety) {
        super(name, maxRun, maxJump);
        this.maxSatiety = maxSatiety;
    }

    protected boolean isSatiety() {
        return currentSatiety >= maxSatiety;
    }

    protected int getMaxSatiety() {
        return maxSatiety;
    }

    protected int getCurrentSatiety() {
        return currentSatiety;
    }

    @Override
    public String run(double length) {
        return String.format("CAT Run {%.1f}: %s", length, (getMaxRun() >= length && getMaxRun() > 0 && length >= 0));
    }

    @Override
    public String jump(double height) {
        return String.format("CAT Jump {%.1f}: %s", height, (getMaxJump() >= height && getMaxJump() > 0 && height >= 0));
    }

    @Override
    public String toString() {
        return "animals.Cat{" +
                "name='" + getName() + '\'' +
                ", maxRun=" + getMaxRun() +
                ", maxJump=" + getMaxJump() +
                ", maxSatiety=" + getMaxSatiety() +
                ", currentSatiety=" + getCurrentSatiety() +
                ", satiety=" + isSatiety() +
                '}';
    }

    public void eatFood(Plate plate) {
        currentSatiety = currentSatiety + plate.takeFood(maxSatiety - currentSatiety);
    }

    public void setHungry() {
        currentSatiety = 0;
    }
}