package main.java.ch_9_7;

import java.util.Arrays;

public class SortUtil {
    //------------------------------  HEAP SORT  ------------------------------\\
    /*
     * Complexity
     * Worst - O(n log n)
     * Average - O(n log n)
     * Best - O(n log n) or O(n)
     * Memory - O(1)
     */
    public static void heap(final int[] arr) {
       final int len = arr.length;
        for (int i = len / 2 - 1; i >= 0 ; --i) {
            heapify(arr, len, i);
        }
        for (int i = len - 1; i > 0 ; --i) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(final int[] arr, final int len, final int i) {
        int indexMax = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < len && arr[left] > arr[indexMax]) {
            indexMax = left;
        }
        if (right < len && arr[right] > arr[indexMax]) {
            indexMax = right;
        }

        if (indexMax != i) {
            swap(arr, indexMax, i);
            heapify(arr, len, indexMax);
        }
    }

    //------------------------------  MERGE SORT ------------------------------\\
    /*
    * Complexity
    * Worst - O(n log n)
    * Average - O(n log n)
    * Best - O(n log n)
    * Memory - O(log n)
     */
    public static void merge(final int[] arr) {
        final int[] buffer = new int[arr.length];
        merge(arr, buffer, 0, arr.length - 1);
    }

    private static void merge(final int[] arr, final int[] buffer, final int from, final int to) {
        if (from >= to) {
            return;
        }
        int mid = from + (to - from) / 2;
        merge(arr, buffer, from, mid);
        merge(arr, buffer, mid + 1, to);
        merging(arr, buffer, from, mid, to);
    }

    private static void merging(final int[] arr, final int[] buffer, final int from, final int mid, final int to) {
        int len = to - from + 1;
        Arrays.fill(buffer, 0);
        System.arraycopy(arr, from, buffer, from, len);
        int i = from;
        int j = mid + 1;

        for (int k = from; k <= to ; ++k) {
            if (i > mid) arr[k] = buffer[j++];
            else if (j > to) arr[k] = buffer[i++];
            else if (buffer[i] < buffer[j]) arr[k] = buffer[i++];
            else arr[k] = buffer[j++];
        }
    }

    //------------------------------  SHAKER SORT ------------------------------\\
    /*
     * Complexity
     * Worst - O(n^2)
     * Average - O(n^2)
     * Best - O(n)
     * Memory - O(1)
     */
    public static void shaker(final int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int control = arr.length / 2;
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

    //------------------------------  QUICK SORT  ------------------------------\\
    /*
     * Complexity
     * Worst - O(n^2)
     * Average - O(n log n)
     * Best - O(n log n)
     * Memory - O(log n)
     */
    public static void quick(final int[] arr) {
        quick(arr, 0,arr.length - 1);
    }

    private static void quick(final int[] arr, final int from, final int to) {
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

    //------------------------------  SHELL SORT  ------------------------------\\
    /*
     * Complexity
     * Worst - O(n^2)
     * Average - O(n log n)
     * Best - ???O(n log n)???
     * Memory - O(1)
     */
    public static void shell(final int[] arr) {
        final int len = arr.length;
        for (int gap = len >> 2; gap > 0 ; gap >>= 1) {
            for (int i = gap; i < len; i += gap) {
                for (int j = i; j >= gap && arr[j] < arr[j - gap] ; --j) {
                    swap(arr, j, j - gap);
                }
            }
        }
    }

    //------------------------------  SERVICE  ------------------------------\\
    private static void swap(final int[] arr, final int i, final int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
