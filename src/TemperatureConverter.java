import java.util.Scanner;

public class TemperatureConverter {

    // converts the temp based on what unit was entered
    public static double convertTemperature(double temperature, String unit) {

        // celsius to fahrenheit
        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32.0;
        }

        // fahrenheit to celsius
        else {
            return (temperature - 32.0) * 5.0 / 9.0;
        }
    }

    // checks if the user actually entered a number
    public static boolean isNumeric(String str) {

        // catches blank input
        if (str == null || str.trim().length() == 0) {
            return false;
        }

        str = str.trim();

        int start = 0;

        // keeps track of decimal points
        boolean decimalFound = false;

        // allows negative numbers
        if (str.charAt(0) == '-') {

            // just a minus sign isnt a number
            if (str.length() == 1) {
                return false;
            }

            start = 1;
        }

        // goes through each character
        for (int i = start; i < str.length(); i++) {
            char ch = str.charAt(i);

            // only allow one decimal point
            if (ch == '.') {

                if (decimalFound) {
                    return false;
                }

                decimalFound = true;
            }

            // anything besides a digit is invalid
            else if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // scanner for user input.
        Scanner scnr = new Scanner(System.in);

        // keeps program running until stop is entered
        while (true) {

            // ask for temperature
            System.out.print("Enter a temperature or type stop to quit: ");

            String input = scnr.nextLine().trim();

            // quit program
            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            // make sure temperature is valid
            if (!isNumeric(input)) {
                System.out.println("Error: Invalid temperature value.");
                continue;
            }

            // convert string input into a double
            double temperature = Double.parseDouble(input);

            String unit;

            // keep asking until a valid unit is entered
            while (true) {

                System.out.print("Enter unit (C or F): ");

                unit = scnr.nextLine().trim();

                // valid units
                if (unit.equalsIgnoreCase("C")
                        || unit.equalsIgnoreCase("F")) {
                    break;
                }

                // invalid unit message
                System.out.println("Error: Invalid unit.");
            }

            // do the conversion
            double converted = convertTemperature(temperature, unit);

            // display result
            if (unit.equalsIgnoreCase("C")) {
                System.out.printf(
                        "%.2f C is equal to %.2f F%n",
                        temperature,
                        converted
                );
            }
            else {
                System.out.printf(
                        "%.2f F is equal to %.2f C%n",
                        temperature,
                        converted
                );
            }
        }

        // close scanner when done
        scnr.close();
    }
}