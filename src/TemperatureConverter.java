import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, char unit) {
        if (unit == 'C') {
            return (temperature * 9.0 / 5.0) + 32;
        }
        else { // unit == 'F'
            return (temperature - 32) * 5.0 / 9.0;
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        while (true) {
            System.out.print("Enter temperature/unit or stop: ");
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            if (!input.contains("/")) {
                System.out.println("Error: Input must be in the format temperature/unit.");
                continue;
            }

            String[] parts = input.split("/");

            if (parts.length != 2) {
                System.out.println("Error: Input must be in the format temperature/unit.");
                continue;
            }

            try {
                double temperature = Double.parseDouble(parts[0].trim());
                char unit = Character.toUpperCase(parts[1].trim().charAt(0));

                if (unit != 'C' && unit != 'F') {
                    System.out.println("Error: Unit must be C or F.");
                    continue;
                }

                double converted = convertTemperature(temperature, unit);

                if (unit == 'C') {
                    System.out.printf("%.1f C = %.1f F%n", temperature, converted);
                }
                else {
                    System.out.printf("%.1f F = %.1f C%n", temperature, converted);
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Error: Temperature must be a valid number.");
            }
            catch (Exception e) {
                System.out.println("Error: Input must be in the format temperature/unit.");
            }
        }

        scnr.close();
    }
}