package LastTwoTasks;

import Tasks.Operations;
import Tasks.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Person> personList = new ArrayList<>();

        Menu menu = new Menu(args);
    }

    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem {
        // Наименование пункта меню
        private String name;
        // Доступное действие
        private Exec exec;

        public String getName() {
            return name;
        }
        public Exec getExec() {
            return exec;
        }
    }

    private static class Menu {

        private List<MenuItem> items = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        Tasks.Menu menuLists = new Tasks.Menu();

        public Menu(String[] args) throws Exception {
            Tasks.Menu.printListMenu(args);

            MenuItem menuItem = new MenuItem();
            menuItem.name = "1";
            menuItem.exec =  x -> Operations.addPerson(personList);
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "2";
            menuItem.exec = x -> Operations.showPerson(personList);
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "3";
            menuItem.exec = x -> Operations.sortPerson(personList);
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "4";
            menuItem.exec = x -> Operations.sortUniquePerson(personList);
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "5";
            menuItem.exec = x -> Operations.printInFile(personList);
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "6";
            menuItem.exec = x -> Operations.readFromFile();
            items.add(menuItem);

            menuItem = new MenuItem();
            menuItem.name = "7";
            menuItem.exec = x -> Operations.clearFile();
            items.add(menuItem);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                int i = 0;
                String s = scanner.nextLine();
                for (MenuItem item : items) {
                    if (item.getName().equals(s)) {
                        i = 1;
                        item.exec.exec(personList);
                        break;
                    }
                }
                if (i == 0) {
                    System.out.println("Ошибка ввода, повторите выбор");
                }
                if (false) {
                    break;
                }
            }
        }
    }
}

