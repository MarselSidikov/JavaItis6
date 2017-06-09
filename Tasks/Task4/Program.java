import java.util.Scanner;
class Program {
    public static void main(String[] args) {
        // создали считыватель
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("----------");
        int a[] = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println("----------");
        for (i = a.length - 1; i >= 0; i--) {
            System.out.println(a[i]);
        }
    }
}