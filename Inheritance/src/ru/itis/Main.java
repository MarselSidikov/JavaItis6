package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Grandmother kapa = new Grandmother("Баба Капа",
                true, 2);

	    kapa.feedGrandsons();

	    GrandmotherBatman batman = new GrandmotherBatman(
	            "Баба МегаКапа", false,
                1, 10, true);

	    batman.catchEnemies();
	    batman.feedGrandsons();
    }
}
