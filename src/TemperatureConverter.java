import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32.0;
        }
        else {
            return (temperature - 32.0) * 5.0 / 9.0;
        }
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }

        str = str.trim();
        int start = 0;
        boolean decimalFound = false;

        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            start = 1;
        }

        for (int i = start; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '.') {
                if (decimalFound) {
                    return false;
                }
                decimalFound = true;
            }
            else if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.print("Enter a temperature or type stop to quit: ");
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("stop")) {
                running = false;
            }
            else if (!isNumeric(input)) {
                System.out.println("Error: Invalid temperature value.");
            }
            else {
                double temperature = Double.parseDouble(input);

                String unit = "";
                boolean validUnit = false;

                while (!validUnit) {
                    System.out.print("Enter unit (C or F): ");
                    unit = scnr.nextLine().trim();

                    if (unit.equalsIgnoreCase("C")
                            || unit.equalsIgnoreCase("F")) {
                        validUnit = true;
                    }
                    else {
                        System.out.println("Error: Invalid unit.");
                    }
                }

                double converted = convertTemperature(temperature, unit);

                if (unit.equalsIgnoreCase("C")) {
                    System.out.printf("%.1f C is equal to %.1f F%n",
                            temperature, converted);
                }
                else {
                    System.out.printf("%.1f F is equal to %.1f C%n",
                            temperature, converted);
                }
            }
        }

        scnr.close();
    }
}