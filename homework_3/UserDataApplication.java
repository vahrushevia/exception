package homework_3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDataApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (ФИО, дата рождения, номер телефона, пол):");
        String input = scanner.nextLine();

        try {
            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            String fullName = data[0] + " " + data[1] + " " + data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            validateFullName(fullName);
            validateBirthDate(birthDate);
            validatePhoneNumber(phoneNumber);
            validateGender(gender);

            String lastName = getLastName(fullName);
            String fileName = data[0] + ".txt";

            String formattedData = formatData(fullName, birthDate, phoneNumber, gender);

            saveToFile(fileName, formattedData);

            System.out.println("Данные успешно сохранены в файл " + fileName);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: неверный формат данных");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void validateFullName(String fullName) {
        String[] nameParts = fullName.split(" ");

        if (nameParts.length != 3) {
            throw new IllegalArgumentException("Неверный формат ФИО");
        }

        // Дополнительная проверка для каждой части ФИО
        String lastName = nameParts[0];
        String firstName = nameParts[1];
        String middleName = nameParts[2];

        if (lastName.isEmpty() || firstName.isEmpty() || middleName.isEmpty()) {
            throw new IllegalArgumentException("ФИО не может быть пустым");
        }

    }

    private static void validateBirthDate(String birthDate) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);

        try {
            Date parsedDate = dateFormat.parse(birthDate);
            // Дополнительная логика проверки корректности даты рождения, если требуется
        } catch (ParseException e) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }
    }

    private static void validatePhoneNumber(String phoneNumber) {
        try {
            long parsedNumber = Long.parseLong(phoneNumber);
            if (parsedNumber <= 0) {
                throw new IllegalArgumentException("Неверный формат номера телефона");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }
    }

    private static void validateGender(String gender) {
        if (!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("w")) {
            throw new IllegalArgumentException("Неверный формат пола");
        }
    }

    private static String getLastName(String fullName) {
        String[] nameParts = fullName.split(" ");
        if (nameParts.length > 0) {
            return nameParts[0];
        } else {
            throw new IllegalArgumentException("Неверный формат ФИО");
        }
    }

    private static String formatData(String fullName, String birthDate, String phoneNumber, String gender) {
        return fullName + birthDate + " " + phoneNumber + gender;
    }

    private static void saveToFile(String fileName, String data) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.println(data);
        writer.close();
    }
}