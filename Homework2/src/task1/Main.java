package task1;

import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

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
            new Person(8, "Amelia"),
            new Person(7, "Amelia"),
            new Person(0, "Harry"),
            new Person(4, "Jack"),
            new Person(6, "Amelia"),
            new Person(5, "Amelia"),
            new Person(2, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
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

        if (RAW_DATA == null || RAW_DATA.length==0) {
            System.out.println("RAW_DATA equal null");
            return;
        }

        Map<String, List<Person>> tmp = Arrays.stream(RAW_DATA)
                .distinct()
                .collect(Collectors.groupingBy(Person::getName));
        TreeMap<String, List<Person>> groupedByNameMap = new TreeMap<>(tmp);

        for (String key: groupedByNameMap.keySet()){
            groupedByNameMap.get(key).sort(new PersonComparator());
            System.out.println("Key: " + key);
            System.out.println("Value: " + groupedByNameMap.get(key).size());
        }

    }
}
