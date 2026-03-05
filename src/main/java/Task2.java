import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        int n = readListSize();

        if (n <= 0) {
            System.out.println("Список пуст");
            return;
        }

        ArrayList<Double> list = generateList(n);

        System.out.println("Исходный список:");
        printList(list);

        bubbleSort(list);

        System.out.println("Отсортированный список:");
        printList(list);
    }

    public static int readListSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов списка: ");
        return scanner.nextInt();
    }

    public static ArrayList<Double> generateList(int size) {
        Random random = new Random();
        ArrayList<Double> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(random.nextDouble() * 100);
        }

        return list;
    }

    public static void printList(ArrayList<Double> list) {
        for (Double value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(ArrayList<Double> list) {

        int n = list.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (list.get(j) > list.get(j + 1)) {

                    double temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                }

            }

        }

    }
}