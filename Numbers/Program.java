// включаем библиотеку для работы со случайными числами
import java.util.Random;
// включаем библиотеку для считывания с клавиатуры
import java.util.Scanner;
// основной код программы
class Program {
	// main - входная точка приложения. 
	// приложение начинает запуск с этой функции
	public static void main(String args[]) {
		// завели переменную, целое число
		// здесь мы будем хранить загаданное компьютером число
		int a;
		// создаем генератор случайных чисел
		Random random = new Random();
		// генерируем случайное число
		a = random.nextInt(10);
		// создаем считыватель с клавиатуры
		Scanner scanner = new Scanner(System.in);
		// считываем (вводим) пользовательское число с клавиатуры
		int x = scanner.nextInt();
		// пока число, которое ввел пользователь не совпало
		// с загаданным компьютером числом
		while (x != a) {
			// говорим, меньше оно или больше
			if (x < a) {
				System.out.println("Bolshe");
			} else if (x > a) {
				System.out.println("Menshe");
			}
			// считываем новое число пользовтеля
			x = scanner.nextInt();
		}
		// если пользователь угадал, то мы выходим из цикла
		// и попадаем сюда
		System.out.println("URA!");
	}
}