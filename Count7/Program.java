import java.util.Scanner;
class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// исходное число
		int n = scanner.nextInt();
		int count = 0;
		while (n != 0) {
			
			int digit = n % 10;
			if (digit == 7) {
				count = count + 1; // count+=1, count++
			}
			n = n / 10;
		}
		System.out.println(count);
	}
}