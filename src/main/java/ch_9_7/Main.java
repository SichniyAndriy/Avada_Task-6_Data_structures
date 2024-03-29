package main.java.ch_9_7;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import net.datafaker.Faker;
import org.apache.commons.lang3.time.StopWatch;

public class Main {
    private final static int LEN = 20;
    private final static Faker faker = new Faker();

    public static void main(String[] args) {
        int[] arr = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            arr[i] = faker.random().nextInt(-99, 99);
        }
        System.out.println("Original array:\t\t\t " + Arrays.toString(arr));

        int[] arrCopy1 = arr.clone();
        StopWatch stopWatch = StopWatch.createStarted();
        SortUtil.quick(arrCopy1);
        stopWatch.stop();
        printResult("Quick sort", stopWatch.getTime(TimeUnit.NANOSECONDS), Arrays.toString(arrCopy1));

        stopWatch.reset();

        int[] arrCopy2 = arr.clone();
        stopWatch.start();
        SortUtil.shaker(arrCopy2);
        stopWatch.stop();
        printResult("Shaker sort", stopWatch.getTime(TimeUnit.NANOSECONDS), Arrays.toString(arrCopy1));

        stopWatch.reset();

        int[] arrCopy3 = arr.clone();
        stopWatch.start();
        SortUtil.merge(arrCopy3);
        stopWatch.stop();
        printResult("Merge sort", stopWatch.getTime(TimeUnit.NANOSECONDS), Arrays.toString(arrCopy1));

        stopWatch.reset();

        int[] arrCopy4 = arr.clone();
        stopWatch.start();
        SortUtil.heap(arrCopy4);
        stopWatch.stop();
        printResult("Heap sort", stopWatch.getTime(TimeUnit.NANOSECONDS), Arrays.toString(arrCopy4));

        stopWatch.reset();
        int[] arrCopy5 = arr.clone();
        stopWatch.start();
        SortUtil.shell(arrCopy5);
        stopWatch.stop();
        printResult("Shell sort", stopWatch.getTime(TimeUnit.NANOSECONDS), Arrays.toString(arrCopy5));
    }

    static void printResult(String type, long res, String arr) {
        System.out.println(type + "\t" + String.format("%.5f",res / 1_000_000.) + " ms.: " + arr);
    }
}
