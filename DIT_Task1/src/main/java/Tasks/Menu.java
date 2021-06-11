package Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Tasks.Operations.*;

public class Menu {
    public static List<Person> personList = new ArrayList<>();

    public static void printListMenu(String[] args) {
        System.out.println("Меню работы со списками. Выберите один из пунктов, введя нужную цифру: ");
        System.out.println("1. Добавление объекта в список\n2. Вывод списка объектов \n"
                + "3. Сортировка списка по фамилиям\n" + "4. Сортировка уникальная списка по фамилиям\n5. Сохранение списка объектов в файл\n" +
                "6. Выход из меню списков\n");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        while (a != 6) {
            switch (a) {
                case 1:
                    addPerson(personList);
                    break;
                case 2:
                    showPerson(personList);
                    break;
                case 3:
                    sortPerson(personList);
                    break;
                case 4:
                    sortUniquePerson(personList);
                    break;
                case 5:
                    printInFile(personList);
                    break;
            }
            a = scanner.nextInt();
        }
        printMainMenu(args);

    }

    public static String[] printMainMenu(String[] args) {
        System.out.println("Меню. Выберите один из пунктов, введя нужную цифру: ");
        System.out.println("1. Добавление объекта из параметров\n2. Добавление объекта с консоли\n" +
                "3. Добавление и работа со списками\n4. Выход");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        while (a != 4) {
            switch (a) {
                case 1:
                    readFromParams(args);
                    break;
                case 2:
                    readFromConsole();
                    break;
                case 3:
                    printListMenu(args);
                    break;
            }
            a = scanner.nextInt();
        }
        System.exit(0);
        return args;
    }

}
