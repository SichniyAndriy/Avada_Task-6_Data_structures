package main.java.ch_9_7;

public class SortUtil {
    public static void quick(int[] arr) {
        quick(arr, 0,arr.length - 1);
    }

    public static void shaker(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int control = 0;
        do {
            for (int i = left; i < right; ++i) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    control = i;
                }
            }
            right = control;
            for (int i = right; i > left; --i) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr,i,i - 1);
                    control = i;
                }
            }
            left = control;
        } while (left < right);
    }

    private static void quick(int[] arr, final int from, final int to) {
        if (from >= to) {
            return;
        }
        int i = from;
        int j = to;
        int pivot = arr[from + (to - from) / 2];
        while(i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
        }

        quick(arr, from, i - 1);
        quick(arr, i, to);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
