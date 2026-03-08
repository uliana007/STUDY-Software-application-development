package Task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();

        System.out.println("\nИсходные данные:");
        System.out.println("Введённое число = " + number);

        if ((number >= 10 && number <= 99 || number <= -10 && number >= -99)
                && number % 2 != 0) {
            System.out.println("\nРезультат:");
            System.out.println("Число является нечетным двухзначным");
        } else {
            System.out.println("\nРезультат:");
            System.out.println("Число НЕ является нечетным двухзначным");
        }

        scanner.close();
    }
}
