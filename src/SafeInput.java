import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();
        } while (input.length() == 0);
        return input;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value = 0;
        boolean done = false;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine(); // clear buffer
                if (value >= low && value <= high) {
                    done = true;
                } else {
                    System.out.println("Error: number out of range.");
                }
            } else {
                System.out.println("Error: invalid integer input.");
                pipe.nextLine(); // clear bad input
            }
        } while (!done);
        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
        } while (!response.equals("Y") && !response.equals("N"));
        return response.equals("Y");
    }
}
