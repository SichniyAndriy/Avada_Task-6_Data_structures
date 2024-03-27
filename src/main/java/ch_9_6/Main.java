package main.java.ch_9_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import net.datafaker.Faker;

public class Main {
    private final static Faker faker = new Faker(Locale.getDefault());

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            Person newPerson = new Person(
                    faker.idNumber().valid(),
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.random().nextInt(18, 65)
            );
            persons.add(newPerson);
        }

        System.out.println(persons);

        List<Person> personsCopy1 = new ArrayList<>(persons);
        Collections.sort(personsCopy1);
        System.out.println(personsCopy1);

        List<Person> personsCopy2 = new ArrayList<>(persons);
        personsCopy2.sort(Comparator.comparing(Person::id));
        System.out.println(personsCopy2);
    }
}
