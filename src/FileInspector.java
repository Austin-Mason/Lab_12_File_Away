import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser(new File("src"));
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            System.out.println("----- File Content -----");
            try (Scanner scanner = new Scanner(selectedFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                return;
            }

            System.out.println("\n----- Summary Report -----");
            System.out.println("File name: " + selectedFile.getName());
            System.out.println("Number of lines: " + lineCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of characters: " + charCount);
        } else {
            System.out.println("File selection cancelled.");
        }
    }
}

