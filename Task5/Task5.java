package Task5;

import java.util.Random;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите количество строк матрицы: ");
        int rows = sc.nextInt();

        System.out.print("Введите количество столбцов матрицы: ");
        int cols = sc.nextInt();

        if (rows <= 0 || cols <= 0) {
            System.out.println("\nРезультат:");
            System.out.println("Количество строк и столбцов должно быть больше 0.");
            sc.close();
            return;
        }

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(201) - 100;
            }
        }

        System.out.println("\nИсходные данные:");
        System.out.println("Количество строк: " + rows);
        System.out.println("Количество столбцов: " + cols);
        System.out.println("Матрица:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println();
        }

        System.out.print("\nВведите число для поиска в строках матрицы: ");
        int target = sc.nextInt();

        StringBuilder rowIndexes = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            boolean foundInRow = false;

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) {
                    foundInRow = true;
                    break;
                }
            }

            if (foundInRow) {
                if (rowIndexes.length() > 0) {
                    rowIndexes.append(", ");
                }
                rowIndexes.append(i);
            }
        }

        System.out.println("\nРезультат:");
        if (rowIndexes.length() == 0) {
            System.out.println("Строк, содержащих введенное число, нет.");
        } else {
            System.out.println("Индексы строк, содержащих число " + target + ": " + rowIndexes);
        }

        sc.close();
    }
}
