class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char c = scanner.next().charAt(0);

		// c = '8', code = 56
		// '0' code 48
		// 56 - 48 = 8
		int i = c - '0';	
	}
}