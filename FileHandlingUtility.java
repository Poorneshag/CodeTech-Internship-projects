import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    // Method to write to a file
    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Contents of the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to modify a file (append content)
    public static void modifyFile(String fileName, String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(newContent);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.err.println("Error modifying the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        System.out.println("Choose an option: \n1. Write to file \n2. Read file \n3. Modify file");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        switch (choice) {
            case 1:
                System.out.println("Enter content to write to the file:");
                String contentToWrite = scanner.nextLine();
                writeFile(fileName, contentToWrite);
                break;

            case 2:
                readFile(fileName);
                break;

            case 3:
                System.out.println("Enter content to append to the file:");
                String contentToAppend = scanner.nextLine();
                modifyFile(fileName, contentToAppend);
                break;

            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
