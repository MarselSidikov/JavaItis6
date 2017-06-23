package ru.itis;

public class GrandmotherBatman extends Grandmother {
    private int countOfEnemies;
    private boolean hasBatmobile;

    public GrandmotherBatman(String name,
                             boolean hasGlasses,
                             int countOfGrandsons,
                             int countOfEnemies,
                             boolean hasBatmobile) {
        super(name, hasGlasses, countOfGrandsons);
        if (countOfEnemies > 0) {
            this.countOfEnemies = countOfEnemies;
        }

        this.hasBatmobile = hasBatmobile;
    }

    public void catchEnemies() {
        for (int i = 0; i < countOfEnemies; i++) {
            System.out.println("Враг " + i + " пойман");
        }
    }

    public int getCountOfEnemies() {
        return countOfEnemies;
    }

    public boolean isHasBatmobile() {
        return hasBatmobile;
    }
}
