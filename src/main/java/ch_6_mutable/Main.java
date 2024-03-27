package main.java.ch_6_mutable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import net.datafaker.Faker;

public class Main {
    public final static Faker faker = new Faker(Locale.getDefault());
    private final static Integer LENGTH = 20;

    public static void main(String[] args) {
        List<Integer> mutableList = new ArrayList<>();
        for (int i = 0; i < LENGTH; i++) {
            mutableList.add(faker.random().nextInt(-99, 99));
        }
        System.out.println("List");
        mutableList.forEach(el -> System.out.print(el + " "));

        System.out.println("\nSet");
        Set<Integer> mutableSet = new HashSet<>();
        mutableSet.addAll(mutableList);
        mutableSet.forEach(el -> System.out.print(el + " "));

        System.out.println("\nQueue");
        Queue<Integer> mutableQueue = new PriorityQueue<>();
        mutableQueue.addAll(mutableList);
        mutableQueue.forEach(el -> System.out.print(el + " "));
    }
}
