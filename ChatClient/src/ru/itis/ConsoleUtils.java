package ru.itis;

public class ConsoleUtils {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // print("Hello", "Red")
    public static void print(String message, String color) {
        switch (color) {
            case "Red": {
                System.out.println(ANSI_RED + message + ANSI_RED);
                break;
            }
            case "Blue": {
                System.out.println(ANSI_BLUE + message + ANSI_BLUE);
                break;
            }
            case "Black": {
                System.out.println(ANSI_BLACK + message + ANSI_BLACK);
                break;
            }
            case "Cyan": {
                System.out.println(ANSI_CYAN + message + ANSI_CYAN);
                break;
            }
            case "Green": {
                System.out.println(ANSI_GREEN + message + ANSI_GREEN);
                break;
            }
            case "Purple": {
                System.out.println(ANSI_PURPLE + message + ANSI_PURPLE);
                break;
            }
            case "White": {
                System.out.println(ANSI_WHITE + message + ANSI_WHITE);
                break;
            }
            case "Yellow": {
                System.out.println(ANSI_YELLOW + message + ANSI_YELLOW);
                break;
            }
            default: {
                System.err.println("Wrong colour");
                break;
            }
        }
    }

}
