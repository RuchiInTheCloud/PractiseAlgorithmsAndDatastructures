package array.sorting;

import datatype.Person;

public class SortTest {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("", 100);
        persons[1] = new Person("", 80);
        persons[2] = new Person("", 60);
        persons[3] = new Person("", 40);
        persons[4] = new Person("", 20);
        Person[] helper = new Person[5];
        persons = MergeSort.mergeSort(persons, helper, 0, 4);
        for (int i = 0; i < persons.length; i++) {
            System.out.print(persons[i] + " ");
        }
    }
}
