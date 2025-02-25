import java.util.Objects;

class PersonEntry {
    private final Person person;
    private final int duplicates;

    public PersonEntry(Person person, int duplicates) {
        this.person = person;
        this.duplicates = duplicates;
    }

    public Person getPerson() {
        return person;
    }

    public int getDuplicates() {
        return duplicates;
    }

    @Override
    public String toString() {
        return String.format("PersonEntry {Person(\"%s\", %d), %d}", person.getName(), person.getAge(), duplicates);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntry that = (PersonEntry) o;
        return duplicates == that.duplicates && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(person);
        result = 31 * result + duplicates;
        return result;
    }
}