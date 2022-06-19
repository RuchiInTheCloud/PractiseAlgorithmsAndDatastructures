package array.sorting;

import datatype.Person;

public class QuickSort {
    public static void quickSort(Person[] person, int low, int high) {
        int partition = partition(person, low, high);
        if (low < partition - 1) {
            quickSort(person, low, partition - 1);
        }
        if (partition < high) {
            quickSort(person, partition, high);
        }
    }

    private static int partition(Person[] persons, int low, int high) {
        int mid = (low + high) / 2;
        while (low <= high) {
            while (persons[low].compareTo(persons[mid]) < 0) low++;
            while (persons[high].compareTo(persons[mid]) > 0) high--;

            if (low <= high) {
                Person temp = persons[low];
                persons[low] = persons[high];
                persons[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }
}
