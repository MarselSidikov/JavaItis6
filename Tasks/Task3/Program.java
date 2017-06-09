import java.util.Scanner; 
class Program { 
	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in); 
		// количество цифр в числе
		int n = scanner.nextInt(); 
		// текущий символ-цифра
		char c; 
		// код цифры
		int code = 0; 
		// общая сумма
		int sum = 0; 
		// степень десяти
		int step = 1; 
		
		// получаем максимальную степень десяти
		for (int i = 0; i < n - 1; i++) { 
			step = step * 10; 
		} 
		// бежим по всем цифрам
		for (i = 0; i < n; i++) { 
			// считали йифру
			c = scanner.next().charAt(0); 
			// получили код
			code = c; 
			// получили значение int ('8' -> 8)
			code = code - '0';
			// кидаем в сумму  
			sum = sum + step * code;
			// понижаем степень десяти
			step = step / 10; 
		} 
		System.out.println(sum); 
	} 
}