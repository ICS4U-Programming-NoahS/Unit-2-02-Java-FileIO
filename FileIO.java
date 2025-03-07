import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

/**
* The FileIO program reads a sample input file with integers on each line.
* It converts each of the numbers from a string to an integer.
* For each line of integers:
* It converts them from string to int.
* It calculates the sum of all the integers.
* It writes the sum to the output file.
* If any of the input is erroneous,
* it display the error message in “output.txt” instead.

*
* @author Noah Smith
* @version 1.0
* @since 2025-03-05
*/

final class FileIO {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output
        String outputStr = "";

        // Initialize sum to 0
        int sum = 0;

        // Write to the output file
        FileWriter myWriter = new FileWriter("./Unit2-02-output.txt");

        // pass the relative path to the input file as a parameter
        File file = new File("./Unit2-02-input.txt");

        // Create a scanner object to read the file
        Scanner scanner = new Scanner(file);

        // while there is another line in the file
        while (scanner.hasNextLine()) {

            // reset sum
            sum = 0;

            // Initialize validInt
            int validInt = 0;

            // Read the line from the file
            String line = scanner.nextLine();

            // Display the line of numbers
            System.out.println(line);

            // Split the line into an array of strings
            String[] arrayNumStr = line.split(" ");

            // Loop through the array of strings
            for (String numStr : arrayNumStr) {
                // Convert the string to an integer
                try {
                    // Declare and initialize the integer
                    int num = Integer.parseInt(numStr);
                    // Add the integer to the sum
                    sum += num;

                    // If the integer is valid
                    validInt += 1;
                // If the string is not an integer
                } catch (Exception exception) {
                    // Display an error message
                    outputStr += (numStr + " is not an integer. \n");
                }
            }

            // If there are no integers on the line
            if (validInt == 0) {
                // Display an error message
                outputStr += "Error: no integers were found on this line.\n";

                // Add a new line for spacing
                outputStr += "\n";
            } else {
                // Display the sum of the numbers
                outputStr += "The sum of the valid integers is "
                + Integer.toString(sum) + "\n";

                // Add a new line for spacing
                outputStr += "\n";
            }
        }

        // Write the output string to the file
        myWriter.write(outputStr);

        // Added a blank line for spacing
        System.out.println("");

        // Display that the file was written to successfully
        System.out.println("Successfully wrote to the file.");

        // Close the file writer
        myWriter.close();

        // Close the scanner
        scanner.close();
    }
}
