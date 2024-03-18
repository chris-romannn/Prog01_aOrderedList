import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Main class for Program 01 - Ordered List Operations
 *
 * CSC 1351 Programming Project No 1
 * Section 2
 *
 * @author Christopher Roman
 * @since 3/17/24
 */
public class Prog01_aOrderedList {
    public static void main(String[] args) {
        Scanner scanner = getInputFile("Enter input filename: ");
        while (scanner == null) {
            System.out.println("Invalid filename.");
            scanner = getInputFile("Enter input filename: ");
        }

        aOrderedList<Car> orderedList = new aOrderedList<Car>();


        while (scanner.hasNextLine()) {
            String car = scanner.nextLine();
            String[] info = car.split(",");
            if (info[0].equals("A")) {
                try {
                    // Add car to the ordered list

                    orderedList.add(new Car(info[1],
                            Integer.parseInt(info[2]),
                            Integer.parseInt(info[3])));
                } catch (NumberFormatException e) {}
            } else if (info[0].equals("D")) {
                // Loop through the ordered list to find and remove the specified car

                while (orderedList.hasNext()) {

                    Car curr = orderedList.next();
                    Car removal = null;

                    try {
                        // Create car object for removal
                        removal = new Car(info[1], Integer.parseInt(info[2]), 0);
                    } catch (NumberFormatException e) {
                    }
                    // Remove the car if found in the ordered list
                    if (removal != null && curr.compareTo(removal) == 0) {
                        orderedList.remove();
                    }
                }
                // Reset the iterator
                orderedList.reset();
            }
        }
        scanner.close();

        PrintWriter writer = getOutputFile("Enter output filename: ");
        if (writer == null) {
            System.out.println("Invalid filename.");
            return;
        }


        writer.println("Number of cars: " + orderedList.size());
        orderedList.reset();
        while (orderedList.hasNext()) {
            Car car =  orderedList.next();
            writer.println(carToString(car));
        }

        writer.close();
    }

    /**
     * Method to generate a string representation of a car.
     *
     * @param car the car object
     * @return a string representation of the car
     * @author Christopher Roman
     * @since 3/17/24
     */

    public static String carToString(Car car) {
        return "Make: " + car.getMake() + "\nYear: " + car.getYear() + "\nPrice: $" + car.getPrice() + "\n";
    }

    /**
     * Method to read input file.
     *
     * @param userPrompt the prompt to ask the user for input file name
     * @return a Scanner object to read from the input file
     * @author Christopher Roman
     * @since 3/17/24
     */    public static Scanner getInputFile(String userPrompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(userPrompt);
            String filename = scanner.nextLine();
            File file = new File(filename);
            if (file.exists()) {
                try {
                    return new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File specified <" + filename + "> does not exist. Would you like to continue? <Y/N>");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    return null;
                }
            }
        }
    }
    /**
     * Method to get the output file.
     *
     * @param userPrompt the prompt to ask the user for output file name
     * @return a PrintWriter object to write to the output file
     * @author Christopher Roman
     * @since 3/17/24
     */
    public static PrintWriter getOutputFile(String userPrompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(userPrompt);
            String filename = scanner.nextLine();
            File file = new File(filename);
            try {
                return new PrintWriter(file);
            } catch (FileNotFoundException e) {
                System.out.println("File specified <" + filename + "> is not valid. Would you like to continue? <Y/N>");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    return null;
                }
            }
        }
    }
}