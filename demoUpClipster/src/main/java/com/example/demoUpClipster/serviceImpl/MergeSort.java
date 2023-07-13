package com.example.demoUpClipster.serviceImpl;

import com.example.demoUpClipster.service.SortAlgorithm;

public class MergeSort implements SortAlgorithm<Comparable> {
    @Override
    public Comparable[] sort(Comparable[] array) {
        if (array == null) {
            return null;
        }

        Comparable[] aux = new Comparable[array.length];
        sortHelper(array, aux, 0, array.length - 1);
        return array;
    }

    private void sortHelper(Comparable[] array, Comparable[] aux, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        sortHelper(array, aux, low, mid);
        sortHelper(array, aux, mid + 1, high);
        merge(array, aux, low, mid, high);
    }

    private void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
        System.arraycopy(array, low, aux, low, high - low + 1);

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (aux[i].compareTo(aux[j]) <= 0) {
                array[k++] = aux[i++];
            } else {
                array[k++] = aux[j++];
            }
        }

        while (i <= mid) {
            array[k++] = aux[i++];
        }
    }

}