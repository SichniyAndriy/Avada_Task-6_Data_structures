package main.java.ch_9_5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import net.datafaker.Faker;
import org.apache.commons.lang3.time.StopWatch;

public class Main {
    private final static Integer LEN = 1_000_000;
    private final static Integer AMOUNT = 100_000;
    private final static Integer DIVISER = 10;
    private final static Faker faker = new Faker(Locale.getDefault());

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < LEN; ++i) {
            Integer x = faker.number().numberBetween(-999_999_999, 1_000_000_000);
            arrayList.add(x);
            linkedList.add(x);
        }

        measureAddToEnd(arrayList);
        measureAddToEnd(linkedList);

        measureAddToFirstHalf(arrayList);
        measureAddToFirstHalf(linkedList);

        measureGettingFromEnd(arrayList);
        measureGettingFromEnd(linkedList);

        measureGettingFromFirstHalf(arrayList);
        measureGettingFromFirstHalf(linkedList);

        measureDeletingFromEnd(arrayList);
        measureDeletingFromEnd(linkedList);

        measureDeletingFromFirstHalf(arrayList);
        measureDeletingFromFirstHalf(linkedList);
    }

    private static void measureAddToEnd(List<? super Integer> lst) {
        StopWatch stopWatch = StopWatch.createStarted();
        for (int i = 0; i < AMOUNT; ++i) {
            lst.add(faker.number().numberBetween(-999_999_999, 1_000_000_000));
        }
        stopWatch.stop();
        showResult(
                "Додавання в кінець ",
                lst.getClass().getSimpleName(),
                AMOUNT,
                stopWatch.getNanoTime()
        );
    }

    private static void measureAddToFirstHalf(List<? super Integer> lst) {
        int len = lst.size() / 2;
        final int amount = AMOUNT / DIVISER;
        StopWatch stopWatch = StopWatch.createStarted();
        for (int i = 0; i < amount; i++) {
            int n = faker.number().numberBetween(0, len);
            int x = faker.number().numberBetween(-999_999_999, 1_000_000_000);
            lst.add(n, x);
        }
        stopWatch.stop();
        showResult(
                "Додавання в першу половину ",
                lst.getClass().getSimpleName(),
                amount,
                stopWatch.getNanoTime()
        );
    }

    private static void measureGettingFromEnd(List<? extends Number> lst) {
        int index = lst.size() - 1;
        StopWatch stopWatch = StopWatch.createStarted();
        for (int i = 0; i < AMOUNT; ++i) {
            Number x = lst.get(index);
        }
        stopWatch.stop();
        showResult(
                "Отримання з кінця ",
                lst.getClass().getSimpleName(),
                AMOUNT,
                stopWatch.getNanoTime()
        );
    }

    private static void measureGettingFromFirstHalf(List<? extends Number> lst) {
        int len = lst.size() / 2;
        final int amount = AMOUNT / DIVISER;
        StopWatch stopWatch = StopWatch.createStarted();
        for (int i = 0; i < amount; i++) {
            Number x = lst.get(faker.number().numberBetween(0, len));
        }
        stopWatch.stop();
        showResult(
                "Отримання з першої половини ",
                lst.getClass().getSimpleName(),
                amount,
                stopWatch.getNanoTime()
        );
    }

    private static void measureDeletingFromEnd(List<? super Integer> lst) {
        StopWatch stopWatch = StopWatch.createStarted();
        for (int i = 0; i < AMOUNT; ++i) {
            lst.removeLast();
        }
        stopWatch.stop();
        showResult(
                "Видалення з кінця ",
                lst.getClass().getSimpleName(),
                AMOUNT,
                stopWatch.getNanoTime()
        );
    }

    private static void measureDeletingFromFirstHalf(List<? super Integer> lst) {
        final int len = lst.size() / 2;
        final int amount = AMOUNT / DIVISER;
        StopWatch stopWatch = StopWatch.createStarted();
        for (int i = 0; i < amount; ++i) {
            lst.remove(faker.number().numberBetween(0, len));
        }
        stopWatch.stop();
        showResult(
                "Видалення з першої половини ",
                lst.getClass().getSimpleName(),
                amount,
                stopWatch.getNanoTime()
        );
    }

    private static void showResult(String s, String type, int amount, long n) {
        System.out.println(
                s + type + " " + DecimalFormat.getNumberInstance().format(amount) +
                " елементів: " + (n / 1_000_000_000.) + " s."
        );
    }
}
