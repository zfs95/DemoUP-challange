package com.example.demoUpClipster.serviceImpl;

import com.example.demoUpClipster.model.File;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LegacySortTest {
    LegacySort service = new LegacySort();

    @Test
    void sort() {
        // Test case 1: Sorting an empty array
        File[] array1 = {};
        File[] expected1 = {};
        assertArrayEquals(expected1, service.sort(array1));

        // Test case 2: Sorting an array with one element
        File[] array2 = {new File(5)};
        File[] expected2 = {new File(5)};
        assertArrayEquals(expected2, service.sort(array2));

        // Test case 3: Sorting an array with multiple elements
        File[] array3 = {new File(7), new File(9), new File(5), new File(1), new File(3)};
        File[] expected3 = {new File(1), new File(3), new File(5), new File(7), new File(9)};
        assertArrayEquals(expected3, service.sort(array3));
    }
}