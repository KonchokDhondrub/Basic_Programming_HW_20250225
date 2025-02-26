import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<Person> list1 = List.of(
//                new Person("Jack", 12),
//                new Person("John", 22),
//                new Person("Jack", 12),
//                new Person("Jack", 12)
//        );

        List<Person> list1 = new ArrayList<>();
        list1.add(new Person("Jack", 12));
        list1.add(null);
        list1.add(new Person("John", 22));
        list1.add(new Person("Jack", 12));
        list1.add(new Person("Jack", 12));


        Set<PersonEntry> uniqueAndCounted = countPerson(list1);
        for (PersonEntry person : uniqueAndCounted) {
            System.out.println(person);
        }
    }

    public static Set<PersonEntry> countPerson(List<Person> list){
//        Set<PersonEntry> result =  countPerson_HashSetThenGetDuplicates(list);
        Set<PersonEntry> result = countPerson_SortThenGetDuplicates(list);
        return result;
    }

    public static Set<PersonEntry> countPerson_SortThenGetDuplicates(List<Person> list) {
        Set<PersonEntry> result = new HashSet<>();

        if (list == null || list.isEmpty()) return result;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                list.remove(i);
                i--;
            }
        }

        List<Person> editableList = new ArrayList<>(list);
        editableList.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));

        int count = 1;
        for (int i = 1; i <= editableList.size(); i++) {
            if (i < editableList.size() && editableList.get(i).equals(editableList.get(i - 1))) {
                count++;
            } else {
                result.add(new PersonEntry(editableList.get(i - 1), count));
                count = 1;
            }
        }
        return result;
    }

    public static Set<PersonEntry> countPerson_HashSetThenGetDuplicates(List<Person> list) {
        Set<PersonEntry> result = new HashSet<>();

        if (list == null || list.isEmpty()) return result;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                list.remove(i);
                i--;
            }
        }

        Set<Person> uniqueSet = new HashSet<>(list);

        for (Person person : uniqueSet) {
            int count = 0;
            for (Person p : list) {
                if (person.equals(p)) {
                    count++;
                }
            }
            result.add(new PersonEntry(person, count));
        }
        return result;
    }
}

