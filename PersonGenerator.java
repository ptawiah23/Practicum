import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> personRecords = new ArrayList<>();
        System.out.println("Welcome to the Person Generator!");

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Enter the following details for a person:");

            // Collect user inputs
            String id = SafeInput.getNonZeroLenString(in, "Enter ID:");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name:");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name:");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (Mr., Mrs., Dr., etc.):");
            int yearOfBirth = SafeInput.getInt(in, "Enter Year of Birth:");

            // Add record to ArrayList
            personRecords.add(id + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);

            // Ask user if they want to add another record
            keepGoing = SafeInput.getYNConfirm(in, "Do you want to add another person?");
        }

        // Save the data to a file
        String fileName = SafeInput.getNonZeroLenString(in, "Enter the name of the file to save:");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String record : personRecords) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
