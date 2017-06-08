import java.util.Random;
import java.util.Scanner;
class Program {
	public static void main(String args[]) {
		int a;
		
		Random random = new Random();
		a = random.nextInt(10);

		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		if (x < a) {
			System.out.println("Bolshe");
			System.out.println(a);
		} else if (x == a) {
			System.out.println("URA!!!!");
		} else {
			System.out.println("Menshe");
			System.out.println(a);
		}
	}
}