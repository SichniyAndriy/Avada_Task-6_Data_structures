package main.java.ch_9_7;

import java.util.Arrays;
import net.datafaker.Faker;

public class Main {
    private final static int LEN = 20;
    private final static Faker faker = new Faker();

    public static void main(String[] args) {
        int[] arr = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            arr[i] = faker.random().nextInt(-99, 99);
        }
        System.out.println("Original array: " + Arrays.toString(arr));

        int[] arrCopy1 = arr.clone();
        SortUtil.quick(arrCopy1);
        System.out.println("Quick sort:\t\t" + Arrays.toString(arrCopy1));

        int[] arrCopy2 = arr.clone();
        SortUtil.shaker(arrCopy2);
        System.out.println("Shaker sort:\t" + Arrays.toString(arrCopy2));

        int[] arrCopy3 = arr.clone();
        SortUtil.merge(arrCopy3);
        System.out.println("Merge sort:\t\t" + Arrays.toString(arrCopy3));

        int[] arrCopy4 = arr.clone();
        SortUtil.heap(arrCopy4);
        System.out.println("Heap sort:\t\t" + Arrays.toString(arrCopy4));

        int[] arrCopy5 = arr.clone();
        SortUtil.shell(arrCopy5);
        System.out.println("Shell sort:\t\t" + Arrays.toString(arrCopy5));
    }
}
