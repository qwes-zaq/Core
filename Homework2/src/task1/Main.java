package task1;

import java.util.*;
import java.util.Comparator;

public class Main {
    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }


    }

    static class PersonComparator implements Comparator<Person> {

        public int compare(Person person1, Person person2) {
            if (person1.name.equals(person2.name)) {
                return person1.id - person2.id;
            }
            int minLength = Math.min(person1.name.length(), person2.name.length());
            int answer = 0;
            for (int i = 0; i < minLength; i++) {
                if (person1.name.charAt(i) > person2.name.charAt(i)) {
                    answer = 1;
                    break;
                } else if (person1.name.charAt(i) < person2.name.charAt(i)) {
                    answer = -1;
                    break;
                }
            }

            return answer;
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        if (RAW_DATA == null) {
            System.out.println("RAW_DATA equal null");
        }

        List<Person> sortedList = Arrays.stream(RAW_DATA).distinct().sorted(new PersonComparator()).toList();
        String currentName = sortedList.get(0).name;
        int count = 1;

        for (int i = 1; i < sortedList.size(); i++) {
            if (currentName.equals(sortedList.get(i).name)) {
                count++;
            } else {
                System.out.println("Key: " + currentName);
                System.out.println("Value: " + count);
                currentName = sortedList.get(i).name;
                count = 1;
            }
            if (i == sortedList.size() - 1) {
                System.out.println("Key: " + currentName);
                System.out.println("Value: " + count);
            }
        }

    }
}
