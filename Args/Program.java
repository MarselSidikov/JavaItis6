class Program {
	public static void main(String[] args) {
		// Сообщение для вывода
		String message = "Hello ,";
		// переменная цикла, необходима для 
		// учета количества аргументов, поданных на вход
		int i = 0;
		// пока i меньше, чем количество аргументов -1
		while (i < args.length - 1) {
			// прикрепляем следующее имя через запятую
			message = message + " " + args[i] + ",";
			i = i + 1;
		}
		// последнее имя прикрепляем через and
		message = message + " and " + args[i];
		System.out.println(message);
	}
}