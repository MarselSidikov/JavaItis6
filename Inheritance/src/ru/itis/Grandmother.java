package ru.itis;

public class Grandmother {
    private String name;
    private boolean hasGlasses;
    private int countOfGrandsons;

    public Grandmother(String name, boolean hasGlasses, int countOfGrandsons) {
        this.name = name;
        this.hasGlasses = hasGlasses;
        if (countOfGrandsons >= 0) {
            this.countOfGrandsons = countOfGrandsons;
        } else {
            System.err.println("Бабушка с отрицательными внуками");
        }
    }

    public void feedGrandsons() {
        for (int i = 0; i < countOfGrandsons; i++) {
            System.out.println("Внук номер " + i + " накормлен");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isHasGlasses() {
        return hasGlasses;
    }

    public int getCountOfGrandsons() {
        return countOfGrandsons;
    }
}
