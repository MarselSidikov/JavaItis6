class Program {
	public static void main(String[] args) {
		String message = "Hello ,";
		int i = 0;
		while (i < args.length - 1) {
			message = message + " " + args[i] + ",";
			i = i + 1;
		}
		message = message + " and " + args[i];
		System.out.println(message);
	}
}