package com.example.demoUpClipster.serviceImpl;

import com.example.demoUpClipster.model.File;
import com.example.demoUpClipster.service.SortAlgorithm;


public class LegacySort implements SortAlgorithm<File> {
    @Override
    public File[] sort(File[] array) {
        if (array == null) {
            return new File[]{};
        }

        if (array.length > 1) {

            int mid = array.length / 2;

            File[] left = new File[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }

            File[] right = new File[array.length - mid];
            for (int i = mid; i < array.length; i++) {
                right[i - mid] = array[i];
            }

            sort(left);
            sort(right);

            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i].compareTo(right[j]) == 1) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }

            while (i < left.length) {
                array[k] = left[i];
                i++;
                k++;
            }

            while (j < right.length) {
                array[k] = right[j];
                j++;
                k++;
            }
        }

        return array;
    }

}
