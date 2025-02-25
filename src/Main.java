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

        Set<PersonEntry> uniqueAndCounted = countPerson(list1);
        for (PersonEntry person : uniqueAndCounted) {
            System.out.println(person);
        }
    }

    public static Set<PersonEntry> countPerson(List<Person> list) {
        if (list == null || list.isEmpty()) return new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                list.remove(i);
                i--;
            }
        }
//        list.removeIf(Objects::isNull);

        Set<Person> uniqueSet = new HashSet<>(list);
        Set<PersonEntry> result = new HashSet<>();

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

