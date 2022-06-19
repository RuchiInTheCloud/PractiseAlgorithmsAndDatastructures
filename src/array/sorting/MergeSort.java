package array.sorting;

import datatype.Person;

//equal, hashcode, compare
public class MergeSort {
    public static Person[] mergeSort(Person[] unsortedArray, Person[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(unsortedArray, helper, low, mid);
            mergeSort(unsortedArray, helper, mid + 1, high);
            merge(unsortedArray, helper, low, mid, high);
        }
        return unsortedArray;
    }

    private static void merge(Person[] unsortedArray, Person[] helper, int low, int mid, int high) {
        for(int i = low; i <= high; i++) {
            helper[i] = unsortedArray[i];
        }

        int helperLeft = low;
        int helperRight = mid + 1;
        int current = low;

        while (helperLeft <= mid && helperRight <= high) {
            if (helper[helperLeft].compareTo(helper[helperRight]) < 0) {
                unsortedArray[current] = helper[helperLeft];
                helperLeft++;
            } else if (helper[helperRight].compareTo(helper[helperLeft]) < 0) {
                unsortedArray[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        if (helperLeft <= mid) {
            for (int i = helperLeft; i <= mid; i++) {
                unsortedArray[current] = helper[i];
                current++;
            }
        }
    }
}
