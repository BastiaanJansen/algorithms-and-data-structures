package Sorts;

import java.util.Arrays;

public class MergeSort implements SortAlgorithm {

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();

        Integer[] array = {6, 2, 5, 3, 7};
        Integer[] sorted = sorter.sort(array);

        System.out.println(sorted[0]);
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length == 1)
            return array;

        int start = 0;
        int end = array.length - 1;
        int mid = (int) Math.floor((start + end) >>> 1);

        T[] leftSide = Arrays.copyOfRange(array, start, mid + 1);
        T[] rightSide = Arrays.copyOfRange(array, mid + 1, end + 1);

        T[] leftSideSorted = sort(leftSide);
        T[] rightSideSorted = sort(rightSide);

        return merge(leftSideSorted, rightSideSorted);
    }

    @SuppressWarnings("unchecked")
    private <T> T[] merge(Comparable<? super T>[] array1, Comparable<? super T>[] array2) {
        int array1Length = array1.length;
        int array2Length = array2.length;

        int array1Index = 0, array2Index = 0, index = 0;

        T[] newArray = (T[]) new Object[array1Length + array2Length];

        while (array1Length > 0 && array2Length > 0) {
            int result = array1[array1Index].compareTo((T) array2[array2Index]);

            if (result < 0) {
                newArray[index] = (T) array2[array2Index++];
                array2Length--;
            } else {
                newArray[index] = (T) array1[array1Index++];
                array1Length--;
            }

            index++;
        }

        while (array1Length > 0) {
            newArray[index++] = (T) array1[array1Index++];
            array1Length--;
        }

        while (array2Length > 0) {
            newArray[index++] = (T) array2[array2Index++];
            array2Length--;
        }

        return newArray;
    }
}
