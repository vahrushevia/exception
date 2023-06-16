package homework_1.task3;

public class Application {

    public static int[] divideArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не совпадают!");
        }

        int[] result = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Деление на ноль недопустимо!");
            }
            result[i] = arr1[i] / arr2[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {10, 20, 30};
        int[] array2 = {2, 4, 0};

        try {
            int[] result = divideArrays(array1, array2);
            System.out.println("Результат: " + Arrays.toString(result));
        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}