package main.java.ch_9_7;

import java.util.Arrays;

public class SortUtil {
    //------------------------------  HEAP SORT  ------------------------------\\
    public static void heap(final int[] arr) {
       final int len = arr.length;
        for (int i = len / 2 - 1; i >= 0 ; --i) {
            heapify(arr, len, i);
        }
        for (int i = len - 1; i >= 0 ; --i) {
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
    public static void merge(int[] arr) {
        int[] tmpArr = new int[arr.length];
        merge(arr, tmpArr, 0, arr.length - 1);
    }

    private static void merge(int[] arr, int[] tmpArr, int from, int to) {
        if (from >= to) {
            return;
        }
        int mid = from + (to - from) / 2;
        merge(arr, tmpArr, from, mid);
        merge(arr, tmpArr, mid + 1, to);
        merging(arr, tmpArr, from, mid, to);
    }

    private static void merging(int[] arr, int[] tmpArr, int from, int mid, int to) {
        int len = to - from + 1;
        Arrays.fill(tmpArr, 0);
        System.arraycopy(arr, from, tmpArr, from, len);
        int i = from;
        int j = mid + 1;

        for (int k = from; k <= to ; ++k) {
            if (i > mid) arr[k] = tmpArr[j++];
            else if (j > to) arr[k] = tmpArr[i++];
            else if (tmpArr[i] < tmpArr[j]) arr[k] = tmpArr[i++];
            else arr[k] = tmpArr[j++];
        }
    }

    //------------------------------  SHAKER SORT ------------------------------\\
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

    //------------------------------  QUICK SORT  ------------------------------\\
    public static void quick(int[] arr) {
        quick(arr, 0,arr.length - 1);
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

    //------------------------------  SERVICE  ------------------------------\\
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
