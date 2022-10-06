import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    public Console() {
    }

    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {
        while(true) {
            System.out.print(prompt);
            double value = scanner.nextDouble();
            if (value >= min && value <= max) {
                return value;
            }

            System.out.println("Enter a value between " + min + " and " + max + ".");
        }
    }

    static {
        scanner = new Scanner(System.in);
    }
}
