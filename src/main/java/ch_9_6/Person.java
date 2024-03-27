package main.java.ch_9_6;

public record Person(
        String id,
        String firstName,
        String lastName,
        Integer age
) implements Comparable<Person> {
    @Override
    public int compareTo(Person o) {
        int i = id.compareTo(o.id);
        if (i != 0) return i;

        i = firstName.compareTo(o.firstName);
        if (i != 0) return i;

        i = lastName.compareTo(o.lastName);
        if (i != 0) return i;

        return age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return id + ", " + firstName + ", " + lastName + ", " + age + "\n";
    }
}
