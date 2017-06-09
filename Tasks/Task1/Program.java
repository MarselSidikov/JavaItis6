import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// считали символ с консоли
		char c = scanner.next().charAt(0);
		// бесконечный цикл
		while (true) {
			if (c >= '0' && c <= '9') {
				System.out.println("IS DIGIT");
			} else if (c >= 'A' && c <= 'Z') {
				System.out.println("IS LETTER");
			} else {
				System.out.println("NO");
				// остановит программу
				return;
			}
			// если return не был вызван, считываем
			// новый символ
			c = scanner.next().charAt(0);
		}
	}
}