package com.example.demoUpClipster.serviceImpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardSortAlgorithmTest {
    StandardSortAlgorithm service = new StandardSortAlgorithm();
    @Test
    void sort() {
        // Test case 1: Sorting an empty array
        Comparable[] array1 = {};
        Comparable[] expected1 = {};
        assertArrayEquals(expected1, service.sort(array1));

        // Test case 2: Sorting an array with one element
        Comparable[] array2 = {5};
        Comparable[] expected2 = {5};
        assertArrayEquals(expected2, service.sort(array2));

        // Test case 3: Sorting an array with multiple elements
        Comparable[] array3 = {7, 9, 5, 1,3};
        Comparable[] expected3 = {1, 3, 5, 7, 9};
        assertArrayEquals(expected3, service.sort(array3));
    }
}