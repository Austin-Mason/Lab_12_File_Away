import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int recordCounter = 1;

        System.out.println("=== DataSaver: Enter User Records ===");

        do {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");

            String id = String.format("%06d", recordCounter++); // Zero-padded ID
            String email = SafeInput.getNonZeroLenString(in, "Enter Email");
            int yob = SafeInput.getRangedInt(in, "Enter Year of Birth", 1900, 2025);

            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, id, email, yob);
            records.add(record);

        } while (SafeInput.getYNConfirm(in, "Add another record?"));

        System.out.print("Enter file name to save (without extension): ");
        String fileName = in.nextLine().trim();
        if (!fileName.endsWith(".csv")) {
            fileName += ".csv";
        }

        File outFile = new File("src/" + fileName);
        try (FileWriter writer = new FileWriter(outFile)) {
            for (String rec : records) {
                writer.write(rec + "\n");
            }
            System.out.println("Data saved to: " + outFile.getPath());
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
