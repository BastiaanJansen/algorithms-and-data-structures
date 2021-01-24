package Sorts;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length == 0 || array.length == 1)
            return array;

        int start = 0;
        int end = array.length - 1;
        int mid = (int) Math.floor((start + end) >>> 1);

        T[] left = Arrays.copyOfRange(array, start, mid + 1);
        T[] right = Arrays.copyOfRange(array, mid + 1, end + 1);

        T[] leftSideSorted = sort(left);
        T[] rightSideSorted = sort(right);

        return merge(leftSideSorted, rightSideSorted);
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> T[] merge(T[] array1, T[] array2) {
        int array1Length = array1.length;
        int array2Length = array2.length;

        int array1Index = 0, array2Index = 0, index = 0;

        T[] newArray = (T[]) Array.newInstance(array1.getClass().getComponentType(), array1Length + array2Length);

        while (array1Length > 0 && array2Length > 0) {
            int result = array1[array1Index].compareTo(array2[array2Index]);

            if (result > 0) {
                newArray[index++] = array2[array2Index++];
                array2Length--;
            } else {
                newArray[index++] = array1[array1Index++];
                array1Length--;
            }
        }

        while (array1Length > 0) {
            newArray[index++] = array1[array1Index++];
            array1Length--;
        }

        while (array2Length > 0) {
            newArray[index++] = array2[array2Index++];
            array2Length--;
        }

        return newArray;
    }
}
