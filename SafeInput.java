import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String input = "";
        do {
            System.out.print(prompt + " ");
            input = pipe.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }


    public static int getInt(Scanner pipe, String prompt) {
        int number = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + " ");
            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                pipe.nextLine(); // Consume the leftover newline
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                pipe.nextLine(); // Clear the invalid input
            }
        } while (!valid);
        return number;
    }


    public static double getDouble(Scanner pipe, String prompt) {
        double number = 0.0;
        boolean valid = false;
        do {
            System.out.print(prompt + " ");
            if (pipe.hasNextDouble()) {
                number = pipe.nextDouble();
                pipe.nextLine(); // Consume the leftover newline
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                pipe.nextLine(); // Clear the invalid input
            }
        } while (!valid);
        return number;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print(prompt + " (yes/no): ");
            response = pipe.nextLine().trim().toLowerCase();
            if (response.equals("yes") || response.equals("y")) {
                return true;
            } else if (response.equals("no") || response.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        } while (true);
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int number = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                pipe.nextLine(); // Consume the leftover newline
                if (number >= low && number <= high) {
                    valid = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                pipe.nextLine(); // Clear the invalid input
            }
        } while (!valid);
        return number;
    }


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double number = 0.0;
        boolean valid = false;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                number = pipe.nextDouble();
                pipe.nextLine(); // Consume the leftover newline
                if (number >= low && number <= high) {
                    valid = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                pipe.nextLine(); // Clear the invalid input
            }
        } while (!valid);
        return number;
    }
}

