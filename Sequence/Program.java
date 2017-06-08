import java.util.Scanner;
class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int currentA;
		int sum = 0;
		currentA = scanner.nextInt();
		while (currentA != -1) {
			if (currentA % 2 == 0) {
				sum = sum + currentA;
			}
			currentA = scanner.nextInt();
		}
		System.out.println(sum);
	}
}