package com.example.demoUpClipster.serviceImpl;

import com.example.demoUpClipster.service.SortAlgorithm;

import java.util.Arrays;

public class StandardSortAlgorithm implements SortAlgorithm<Comparable> {
    @Override
    public Comparable[] sort(Comparable[] array) {
        Arrays.sort(array);
        return array;
    }
}
