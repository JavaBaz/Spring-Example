package com.github.javabaz.springexample.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Validator {

    public static Scanner scanner = new Scanner(System.in);

    public static String getStringInput() {
        while (true) {
            if (scanner.hasNext()) {
                return scanner.next();
            } else {
                System.out.print("Invalid input. Please enter a valid String : ");
                scanner.next();
            }
        }
    }

    public static String getSpacedStringInput() {
        while (true) {
            if (scanner.hasNext()) {
                return scanner.nextLine();
            } else {
                System.out.print("Invalid input. Please enter a valid String : ");
                scanner.next();
            }
        }
    }


    public static long getLongInput() {
        while (true) {
            if (scanner.hasNextLong()) {
                return scanner.nextLong();
            } else {
                System.out.print("Invalid input. Please enter a valid long integer :");
                scanner.next();
            }
        }
    }

    public static int getIntInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.print("Invalid input. Please enter a valid integer :");
                scanner.next();
            }
        }
    }

    public static boolean getBooleanInput() {
        while (true) {
            String input = scanner.next();

            if (input.equalsIgnoreCase("yes")) {
                return true;
            } else if (input.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.print("Invalid input. Please enter 'yes' or 'no' :");
            }
        }
    }

    public static LocalDate dateFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,M,d");
        LocalDate localDate = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a date in the format (yyyy,M,d): ");
            String dateString = scanner.next();
            scanner.nextLine();
            try {
                localDate = LocalDate.parse(dateString, formatter);
                validInput = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy,M,d");
            }
        }
        return localDate;
    }


    public static String getDigitString() {
        String input = "";
        boolean isValid = false;

        while (!isValid) {
            input = scanner.next();
            scanner.nextLine();
            if (input.matches("\\d+")) {
                isValid = true;
            } else {
                System.out.print("Invalid input. Please enter only digits number :");
            }
        }

        return input;
    }

    public static String getDigitString(int desiredLength) {
        String input = "";
        boolean isValid = false;

        while (!isValid) {
            input = scanner.next();
            scanner.nextLine();
            if (input.matches("\\d+") && input.length() == desiredLength) {
                isValid = true;
            } else {
                System.out.print("Invalid input. Please enter a " + desiredLength + " digit number :");
            }
        }

        return input;
    }


    public static String getStrongPassword() {
        while (true) {
            String input = scanner.next();

            if (isPasswordStrong(input)) {
                return input;
            } else {
                System.out.print("Your password is weak! it must be between 8 to 50 character and included numbers and alphabets :");
            }
        }
    }

    public static String getValidEmail() {
        while (true) {
            String input = scanner.next();

            if (isEmailValid(input)) {
                return input;
            } else {
                System.out.print("Your Email is not Valid!");
            }
        }
    }


    //============================= internal methods =============================


    public static boolean isEmailValid(String email) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isPasswordStrong(String password) {
        String regex = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}



