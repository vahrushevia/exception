// 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        float number = readFloatFromUser();
        System.out.println("Введенное число: " + number);
    }

    public static float readFloatFromUser() {
        Scanner scanner = new Scanner(System.in);
        float number;

        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                number = Float.parseFloat(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
            }
        }

        return number;
    }
}