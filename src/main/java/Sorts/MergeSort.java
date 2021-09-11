package Sorts;

import java.util.Arrays;

public class MergeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array.length == 0 || array.length == 1)
            return;

        sort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void sort(T[] array, int start, int end) {
        if (start >= end) return;

        int mid = (int) Math.floor((start + end) >>> 1);

        sort(array, start, mid);
        sort(array, mid + 1, end);

        merge(array, start, mid, end);
    }

    private <T extends Comparable<T>> void merge(T[] array, int start, int mid, int end) {
        T[] left = Arrays.copyOfRange(array, start, mid + 1);
        T[] right = Arrays.copyOfRange(array, mid + 1, end + 1);

        int index = start, leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            int result = left[leftIndex].compareTo(right[rightIndex]);

            if (result < 0)
                array[index++] = left[leftIndex++];
            else
                array[index++] = right[rightIndex++];
        }

        while (leftIndex < left.length) {
            array[index++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            array[index++] = right[rightIndex++];
        }
    }
}
