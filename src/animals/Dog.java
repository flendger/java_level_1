package animals;

public class Dog extends SwimAnimal {
    public Dog(String name, double maxRun, double maxJump, double maxSwim) {
        super(name, maxRun, maxJump, maxSwim);
    }

    @Override
    public String swim(double length) {
        return String.format("DOG Swim {%.1f}: %s", length, (getMaxSwim() >= length && getMaxSwim() > 0 && length >= 0));
    }

    @Override
    public String run(double length) {
        return String.format("DOG Run {%.1f}: %s", length, (getMaxRun() >= length && getMaxRun() > 0 && length >= 0));
    }


    @Override
    public String jump(double height) {
        return String.format("DOG Jump {%.1f}: %s", height, (getMaxJump() >= height && getMaxJump() > 0 && height >= 0));
    }

}
