package Task4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите n: ");
        int n = sc.nextInt();

        System.out.println("\nИсходные данные:");
        System.out.println("n = " + n);

        if (n <= 0) {
            System.out.println("\nРезультат:");
            System.out.println("Исходные данные не верны!");
        } else {
            double result = 1.0;

            for (int i = 1; i <= n; i++) {
                result *= (1.0 - 1.0 / (2 * i));
            }

            System.out.println("\nРезультат:");
            System.out.println("(1 - 1/2)(1 - 1/4)...(1 - 1/(2n)) = " + result);
        }

        sc.close();
    }
}
