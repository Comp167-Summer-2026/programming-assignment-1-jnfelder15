import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, char unit) {
        if (unit == 'C') {
            return (temperature * 9.0 / 5.0) + 32.0;
        } else {
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
            System.out.print("Enter temperature/unit or stop: ");
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("stop")) {
                running = false;
            }
            else if (input.length() == 0) {
                System.out.println("Error: Blank input.");
            }
            else if (!input.contains("/")) {
                System.out.println("Error: Input must be in the format temperature/unit.");
            }
            else {
                String[] parts = input.split("/");

                if (parts.length != 2) {
                    System.out.println("Error: Input must be in the format temperature/unit.");
                }
                else {
                    String tempStr = parts[0].trim();
                    String unitStr = parts[1].trim();

                    if (!isNumeric(tempStr)) {
                        System.out.println("Error: Invalid temperature value.");
                    }
                    else if (unitStr.length() != 1) {
                        System.out.println("Error: Unrecognized unit.");
                    }
                    else {
                        char unit = Character.toUpperCase(unitStr.charAt(0));

                        if (unit != 'C' && unit != 'F') {
                            System.out.println("Error: Unrecognized unit.");
                        }
                        else {
                            double temperature = Double.parseDouble(tempStr);
                            double converted =
                                    convertTemperature(temperature, unit);

                            if (unit == 'C') {
                                System.out.printf(
                                        "%.2f°C is equal to %.2f°F%n",
                                        temperature,
                                        converted
                                );
                            }
                            else {
                                System.out.printf(
                                        "%.2f°F is equal to %.2f°C%n",
                                        temperature,
                                        converted
                                );
                            }
                        }
                    }
                }
            }
        }

        scnr.close();
    }
}