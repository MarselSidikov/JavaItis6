package hash;

public class Program {
    public static void main(String[] args) {
        Map map = new Map();
        map.put("Marsel", "Sidikov");
        map.put("Amir", "Kamalov");
        map.put("Adelya", "Garieva");
        map.put("Sergey", "Mikheev");
        map.put("Vasya", "Tsaplin");
        map.put("Adel", "Tonkov");
        map.put("Daniil", "Volgaev");
        map.put("Leonid", "Solovyev");
        map.put("Yan", "Bashkirtsev");
        map.put("Svyatoslav", "Gorodilov");
        map.put("Adel", "Gilmeev");

        map.show();
        System.out.println(map.get("Yan"));
        int i = 0;
    }
}
