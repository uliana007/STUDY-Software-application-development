package Task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите последовательность целых чисел.");
        System.out.println("Для завершения введите 0 (ноль не входит в последовательность).");

        Integer maxNumber = null;

        while (true) {
            System.out.print("Введите число: ");
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            if (maxNumber == null || number > maxNumber) {
                maxNumber = number;
            }
        }

        System.out.println("\nРезультат:");
        if (maxNumber == null) {
            System.out.println("Последовательность не содержит чисел.");
        } else {
            System.out.println("Наибольшее число из последовательности: " + maxNumber);
        }

        scanner.close();
    }
}
