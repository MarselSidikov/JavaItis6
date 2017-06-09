import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char c = scanner.next().charAt(0);
		while (true) {
			if (c >= '0' && c <= '9') {
				System.out.println("IS DIGIT");
			} else if (c >= 'A' && c <= 'Z') {
				System.out.println("IS LETTER");
			} else {
				System.out.println("NO");
				return;
			}
			c = scanner.next().charAt(0);
		}
	}
}