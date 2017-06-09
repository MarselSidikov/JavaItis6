import java.util.Scanner;
class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char c = 'A';
		c = (char)(c + 1);
		System.out.println(c);
		int code = c;
		System.out.println(code);
		c = (char)67;
		System.out.println(c);
		c = scanner.next().charAt(0);
		System.out.println(c);
		code = c;
		System.out.println(code);
	}
}