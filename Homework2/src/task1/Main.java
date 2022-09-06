package task1;

import java.util.*;

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
        TreeMap<String, ArrayList<Integer>> dictionary = deleteDuplicatesAndSort();
        for(Map.Entry<String, ArrayList<Integer>> item : dictionary.entrySet()){
            System.out.println("Key: "+item.getKey());
            System.out.println("Value: "+item.getValue().size());
        }
    }

    public static TreeMap<String, ArrayList<Integer>> deleteDuplicatesAndSort(){
        List<Person> distinctList = Arrays.stream(RAW_DATA).distinct().toList();
        TreeMap<String, ArrayList<Integer>> answer = new TreeMap<>();
        for(Person item : distinctList){
            if(!answer.containsKey(item.name)) {
                answer.put(item.name, new ArrayList<>());
                answer.get(item.name).add(item.id);
            }
            else {
                answer.get(item.name).add(item.id);
            }
        }
        for(var item : answer.values()){
            Collections.sort(item);
        }
        return answer;
    }
}
