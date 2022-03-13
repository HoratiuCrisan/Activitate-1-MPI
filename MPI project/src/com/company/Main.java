package com.company;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

class MergeSort {


    void merge(int arr[], int p, int q, int r) {


        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];


        int i, j, k;
        i = 0;
        j = 0;
        k = p;


        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }


    void mergeSort(int arr[], int l, int r) {
        if (l < r) {


            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);


            merge(arr, l, m, r);
        }
    }

}

class ShellSort {


   static void shellSort(int array[], int n) {
        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                    array[j] = array[j - interval];
                }
                array[j] = temp;
            }
        }
    }
}

class HeapSort {

    static void heapsort(int arr[]) {
        int n = arr.length;


        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i) {

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;


        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}

class Quicksort {


    static int partition(int array[], int low, int high) {

        // choose the rightmost element as pivot
        int pivot = array[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greatr element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swapt the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {


            int pi = partition(array, low, high);


            quickSort(array, low, pi - 1);


            quickSort(array, pi + 1, high);
        }
    }
}

class  BubbleSort {
    static void bubbleSort(int array[]) {
        int size = array.length;


        for (int i = 0; i < (size - 1); i++) {


            boolean swapped = false;


            for (int j = 0; j < (size - i - 1); j++) {

                if (array[j] > array[j + 1]) {


                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;

        }
    }
}

class InsertionSort {
    static void insertionSort(int array[]) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;


            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }


            array[j + 1] = key;
        }
    }
}

class SelectionSort{
    static void selectionSort(int array[]) {
        int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;

            for (int i = step + 1; i < size; i++) {


                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }


            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }
}

class Random {
    public static void generateRandomNumbers(int array[], int number) {
        for (int i = 0; i < number; i++)
                array[i] = ThreadLocalRandom.current().nextInt();
                // Generarea de numere intr-un anumit interval
                //array[i] = ThreadLocalRandom.current().nextInt(10, 15);
    }
}

class Time {
    public static double timeInNano(int array[], int number)
    {

        long startTime = System.nanoTime();
        double result = Math.pow(10, -9);
        TimeUnit.SECONDS.toSeconds(1);

        //Apelarea functiilor care contin algoritmii de sortare

        //BubbleSort.bubbleSort(array);
        //SelectionSort.selectionSort(array);
        //InsertionSort.insertionSort(array);
        //Quicksort.quickSort(array, 0, number-1);
        //HeapSort.heapsort(array);
        //ShellSort.shellSort(array, number);

        /*MergeSort ob = new MergeSort();
        ob.mergeSort(array, 0, array.length - 1);*/

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;


        return ((double)timeElapsed * result);
    }
}

public class Main {
    public static void printArray(int array[], int number)
    {
        for (int i=0; i < number; i++ )
            System.out.println(array[i]);
    }



    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        // declaratia de variabile si constante
        System.out.println("Introduceti numarul de elemente dorite: ");
         int randomNumbersToBeGenerated = myObj.nextInt(); // constanta care retine dimensiunea listei
        System.out.println("Introduceti numarul de liste pe care doriti sa le generati: ");
        int numberOfRepetitions = myObj.nextInt();

        double max = 0; double min = 999999999;

        double current;

        for (int i = 0; i < numberOfRepetitions; i++) {

                int array2[] =  new int [randomNumbersToBeGenerated];
                Random.generateRandomNumbers(array2, randomNumbersToBeGenerated);
                current = Time.timeInNano(array2,randomNumbersToBeGenerated);

                if (current > max)
                    max = current;
                if(current < min)
                    min = current;

             printArray(array2, randomNumbersToBeGenerated);
        }
        System.out.println("Min = " + min + "s, Max = " + max + "s");
    }
}
