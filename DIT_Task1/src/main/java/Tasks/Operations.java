package Tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Operations {
    public static List<Person> personList = new ArrayList<>();

    public static Person readFromParams(String[] args) {
        String firstName = args[0];
        String lastName = args[1];
        Person person = new Person(firstName, lastName);
        System.out.println(person);
        return person;

    }

    public static Person readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String[] Name = scanner.nextLine().split(" ");
        Person person = new Person(Name[0], Name[1]);
        System.out.println(person);
        return person;
    }

    public static List<Person> addPerson(List<Person> personList) {
        personList.add(readFromConsole());
        return personList;
    }

    public static List<Person> sortPerson(List<Person> personList) {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return personList;
    }

    public static List<Person> sortUniquePerson(List<Person> personList) {
        sortPerson(personList);
        Set<Person> uniquePerson = new HashSet<>(sortPerson(personList));
        List<Person> uniqueSortedPerson = new ArrayList<>(uniquePerson);
        showPerson(uniqueSortedPerson);
        return uniqueSortedPerson;
    }

    public static void showPerson(List<Person> personList) {
        System.out.println("Список объектов: ");
        for (Person person :
                personList) {
            System.out.println(person);
        }


    }


    public static void printInFile(List<Person> personList) {

        try (FileWriter writer = new FileWriter("list.txt")) {
            for (Person person :
                    personList) {
                writer.write(person.toString());
                writer.write('\n');
            }
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void readFromFile() throws FileNotFoundException {

        try (FileReader reader = new FileReader("list.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void clearFile() {
        List<Person> emptyList = new ArrayList<>();
        printInFile(emptyList);

    }

}
