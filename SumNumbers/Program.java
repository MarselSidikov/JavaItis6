class Program {
	public static void main(String[] args) {
		// исходное число
		int n = 13768;
		// сумма всех цифр
		int sum = 0;
		// пока число не закончилось
		while (n != 0) {
			// получаем текущую цифру
			int digit = n % 10;
			// кидаем ее в сумму
			sum = sum + digit;
			// отбрасываем последнюю цифру
			n = n / 10;
		}
		System.out.println(sum);
	}
}
/*
	while (n != 0) {
			// получаем текущую цифру
			int digit = n % 10;
			// кидаем ее в сумму
			sum = sum + digit;
			// отбрасываем последнюю цифру
			n = n / 10;
		}
	n = 13768
	1) 
		digit = 13768 % 10 = 8
		sum = 0 + 8 = 8
		n = 13768 / 10 = 1376
	2)  digit = 1376 % 10 = 6
		sum = 8 + 6 = 14
		n = 1376 / 10 = 137
	3)  digit = 137 % 10 = 7
		sum = 14 + 7 = 21
		n = 137 / 10 = 13
		и т. д.
*/