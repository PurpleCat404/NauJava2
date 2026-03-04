import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        int n = readArraySize();

        if (n == 0) {
            System.out.println("Размер массива равен нулю. Невозможно вычислить среднее значение");
            return;
        }

        int[] array = generateArray(n);

        System.out.println("Массив:");
        printArray(array);

        double average = calculateAverage(array);
        System.out.println("Среднее значение: " + average);
    }

    public static int readArraySize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        return scanner.nextInt();
    }

    public static int[] generateArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static double calculateAverage(int[] array) {
        int sum = 0;

        for (int value : array) {
            sum += value;
        }

        return (double) sum / array.length;
    }
}