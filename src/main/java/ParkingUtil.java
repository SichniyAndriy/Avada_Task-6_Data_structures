package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;

public class ParkingUtil {
    public final static List<String> numberList = new ArrayList<>();
    public final static Set<String> numberSet = new HashSet<>();
    public final static Map<String, String> numberMap = new HashMap<>();
    public final static Scanner scan = new Scanner(System.in);

    private final static Faker faker = new Faker(Locale.getDefault());

    static {
        numberList.add(faker.examplify("AB1111CD"));
        numberList.add(faker.examplify("AB1111CD"));
        numberList.add(faker.examplify("AB1111CD"));
        numberList.add(faker.examplify("AB1111CD"));
        numberList.add(faker.examplify("AB1111CD"));
    }

    static {
        numberSet.add(faker.examplify("AB1111CD"));
        numberSet.add(faker.examplify("AB1111CD"));
        numberSet.add(faker.examplify("AB1111CD"));
        numberSet.add(faker.examplify("AB1111CD"));
        numberSet.add(faker.examplify("AB1111CD"));
    }

    static {
        numberMap.put(faker.examplify("AB1111CD"), faker.name().fullName());
        numberMap.put(faker.examplify("AB1111CD"), faker.name().fullName());
        numberMap.put(faker.examplify("AB1111CD"), faker.name().fullName());
        numberMap.put(faker.examplify("AB1111CD"), faker.name().fullName());
        numberMap.put(faker.examplify("AB1111CD"), faker.name().fullName());
    }
}
