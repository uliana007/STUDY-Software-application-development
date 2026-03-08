package Laba2;

import java.util.Scanner;

class Animal {
    private String name;
    private String animalClass;
    private int averageWeight;
    private static int objectCount = 0;

    public Animal() {
        this.name = "Неизвестно";
        this.animalClass = "Неизвестно";
        this.averageWeight = 0;
        objectCount++;
    }

    public Animal(String name, String animalClass, int averageWeight) {
        this.name = name;
        this.animalClass = animalClass;
        this.averageWeight = averageWeight;
        objectCount++;
    }

    public Animal(Animal other) {
        this.name = other.name;
        this.animalClass = other.animalClass;
        this.averageWeight = other.averageWeight;
        objectCount++;
    }

    public void show() {
        System.out.println("Имя: " + name + ", класс: " + animalClass + ", средний вес: " + averageWeight);
    }

    public String getName() {
        return name;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public int getAverageWeight() {
        return averageWeight;
    }

    public static void showObjectCount() {
        System.out.println("Количество созданных объектов: " + objectCount);
    }
}

public class Laba2 {
    private static boolean hasRequiredLetter(String value) {
        if (value == null) {
            return false;
        }

        String normalized = value.trim().toLowerCase();
        return normalized.contains("с") || normalized.contains("м")
                || normalized.contains("c") || normalized.contains("m");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество животных: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n <= 0) {
            System.out.println("Массив животных пуст.");
            Animal.showObjectCount();
            scanner.close();
            return;
        }

        Animal[] animals = new Animal[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nЖивотное " + (i + 1) + ":");
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите класс: ");
            String animalClass = scanner.nextLine();
            System.out.print("Введите средний вес (целое число): ");
            int averageWeight = scanner.nextInt();
            scanner.nextLine();

            animals[i] = new Animal(name, animalClass, averageWeight);
        }

        System.out.println();
        Animal.showObjectCount();

        System.out.println("\nВсе животные:");
        for (Animal animal : animals) {
            animal.show();
        }

        int maxWeight = animals[0].getAverageWeight();
        for (Animal animal : animals) {
            if (animal.getAverageWeight() > maxWeight) {
                maxWeight = animal.getAverageWeight();
            }
        }

        System.out.println("\nЖивотные с максимальным средним весом:");
        boolean hasMax = false;
        for (Animal animal : animals) {
            if (animal.getAverageWeight() == maxWeight) {
                animal.show();
                hasMax = true;
            }
        }
        if (!hasMax) {
            System.out.println("Таких животных нет.");
        }

        System.out.println("\nЖивотные, имя которых содержит одну из букв «с», «С», «м», «М»:");
        boolean hasLetters = false;
        for (Animal animal : animals) {
            if (hasRequiredLetter(animal.getName())) {
                animal.show();
                hasLetters = true;
            }
        }

        if (!hasLetters) {
            System.out.println("Таких животных нет.");
        }

        scanner.close();
    }
}

/*
Пример запуска №1 (первое условие выполняется, второе — нет):
Ввод:
3
Лев
Млекопитающие
190
Тигр
Млекопитающие
220
Волк
Млекопитающие
60

В этом наборе:
- по 1-му условию будет выведен "Тигр" (максимальный вес);
- по 2-му условию не будет ни одного объекта, потому что в именах нет букв с/С/м/М.

Пример запуска №2:
Требование "по первому условию не было ни одного объекта" для данного варианта
математически невыполнимо, так как максимум в непустом массиве существует всегда.
Поэтому можно показать максимально близкий случай: по 1-му условию ровно один объект,
а по 2-му — как минимум один.

Ввод:
4
Сом
Рыбы
5
Лиса
Млекопитающие
8
Тигр
Млекопитающие
220
Зебра
Млекопитающие
200

Здесь:
- по 1-му условию: "Тигр";
- по 2-му условию: "Сом", "Лиса".
*/
