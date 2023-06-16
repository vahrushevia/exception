package homework_1.task1;

public class Application {

    // Метод, генерирующий NumberFormatException
    public static void generateNumberFormatException() {
        String str = "123abc"; // Неправильный формат числа
        int num = Integer.parseInt(str);
        System.out.println(num);
    }

    // Метод, генерирующий ArrayIndexOutOfBoundsException
    public static void generateArrayIndexOutOfBoundsException() {
        int[] arr = new int[3]; // Массив размером 3
        int num = arr[5]; // Попытка обратиться к индексу, выходящему за пределы массива
        System.out.println(num);
    }

    // Метод, генерирующий NullPointerException
    public static void generateNullPointerException() {
        String str = null; // Null-ссылка
        int length = str.length(); // Попытка вызвать метод у null-ссылки
        System.out.println(length);
    }

    public static void main(String[] args) {
        try {
            generateNumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught!");
        }

        try {
            generateArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught!");
        }

        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught!");
        }
    }
}