import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Person> list1 = List.of(
                new Person("Jack", 12),
                new Person("John", 22),
                new Person("Jack", 12),
                new Person("Jack", 12)
        );

        Set<PersonEntry> result = countPerson(list1);
        for (PersonEntry person : result) {
            System.out.println(person);
        }
    }

    public static Set<PersonEntry> countPerson(List<Person> list) {
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

class PersonEntry {
    private final Person person;
    private int value;

    public PersonEntry(Person person, int value) {
        this.person = person;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("PersonEntry {Person(\"%s\", %d), %d}", person.getName(), person.getAge(), value);
    }
}

