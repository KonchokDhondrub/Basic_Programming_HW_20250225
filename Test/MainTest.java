import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MainTest {
    List<Person> list1_Orig = List.of(
            new Person("Jack", 12),
            new Person("John", 22),
            new Person("Jack", 12),
            new Person("Jack", 12)
    );
    Set<PersonEntry> uniqueAndCounted_Orig = new HashSet<>(List.of(
                    new PersonEntry(new Person("Jack", 12), 3),
                    new PersonEntry(new Person("John", 22), 1)
    ));


    @Test
    @DisplayName("#1 Empty List")
    void countPerson_nullList() {
        List<Person> list1 = List.of();

        Set<PersonEntry> expectedResult = Main.countPerson(list1);
        Assertions.assertNotNull(Main.countPerson(null), "Null test failed!");

        Assertions.assertTrue(expectedResult.isEmpty(), "Result should be empty for an empty list.");
    }

    @Test
    @DisplayName("#2 One object at List")
    void countPerson_oneObject() {
        List<Person> list1 = List.of(new Person("Jack", 12));

        Set<PersonEntry> actualResult = Main.countPerson(list1);
        Set<PersonEntry> expectedResult = new HashSet<>(List.of(
                new PersonEntry(new Person("Jack", 12), 1)
        ));

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("#3 Many individual objects at List")
    void countPerson_manyIndividualObjects() {
        List<Person> list1 = List.of(
                new Person("Jack", 12),
                new Person("Lena", 22),
                new Person("John", 32),
                new Person("Lenny", 42)
        );

        Set<PersonEntry> actualResult = Main.countPerson(list1);
        Set<PersonEntry> expectedResult = new HashSet<>(List.of(
                new PersonEntry(new Person("Jack", 12), 1),
                new PersonEntry(new Person("Lena", 22), 1),
                new PersonEntry(new Person("John", 32), 1),
                new PersonEntry(new Person("Lenny", 42), 1)
        ));

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("#4 Similar Persons and correct counting.\n" +
            "#5 Result have unique and similar values.\n" +
            "#10 Counting amount from original List and result.")
    void countPerson_combinePersonsAndCount() {
        List<Person> list1 = List.of(
                new Person("Jack", 12),
                new Person("John", 22),
                new Person("Jack", 12),
                new Person("Jack", 12)
        );

        Set<PersonEntry> actualResult = Main.countPerson(list1);
        Set<PersonEntry> expectedResult = new HashSet<>(List.of(
                new PersonEntry(new Person("Jack", 12), 3),
                new PersonEntry(new Person("John", 22), 1)
        ));

        Assertions.assertEquals(expectedResult, actualResult);


        int countDuplicates = 0;
        for (PersonEntry p : expectedResult) {
            countDuplicates+=p.getDuplicates();
        }

        Assertions.assertEquals(list1.size(), countDuplicates);
    }

    @Test
    @DisplayName("#6 Similar Persons with different age and correct counting")
    void countPerson_combineSimilarPersonsWithDifferentAgeAndCount() {
        List<Person> list1 = List.of(
                new Person("Jack", 12),
                new Person("John", 22),
                new Person("Jack", 12),
                new Person("Jack", 44)
        );

        Set<PersonEntry> actualResult = Main.countPerson(list1);
        Set<PersonEntry> expectedResult = new HashSet<>(List.of(
                new PersonEntry(new Person("Jack", 12), 2),
                new PersonEntry(new Person("John", 22), 1),
                new PersonEntry(new Person("Jack", 44), 1)
        ));

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("#7 Handling null values in the list")
    void countPerson_nullValues() {
        List<Person> list1 = new ArrayList<>();
                list1.add(new Person("Jack", 12));
                list1.add(null);
                list1.add(new Person("John", 22));
                list1.add(new Person("Jack", 12));

        Set<PersonEntry> actualResult = Main.countPerson(list1);
        Set<PersonEntry> expectedResult = new HashSet<>(List.of(
                new PersonEntry(new Person("Jack", 12), 2),
                new PersonEntry(new Person("John", 22), 1)
        ));

        Assertions.assertEquals(expectedResult, actualResult);
    }
}