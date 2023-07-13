package com.example.demoUpClipster.serviceImpl;

import com.example.demoUpClipster.model.File;
import com.example.demoUpClipster.service.SortAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class Microbenchmark {
    private static final int ARRAY_SIZE = 10; //mil
    private static final int NUM_RUNS = 5;

    public void execute() {
        File[] input = generateRandomArray();

        SortAlgorithm<File>[] algorithms = new SortAlgorithm[]{
                new LegacySort(),
                new MergeSort(),
                new ClassicSort(),
                new StandardSortAlgorithm()
        };

        for (SortAlgorithm<File> algorithm : algorithms) {
            long totalTime = 0;

            for (int i = 0; i < NUM_RUNS; i++) {
                File[] arrayCopy = Arrays.copyOf(input, input.length);
                long startTime = System.currentTimeMillis();

                algorithm.sort(arrayCopy);

                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                totalTime += elapsedTime;

                System.out.println(algorithm.getClass().getSimpleName() + " Run " + (i + 1) +
                        " - Elapsed Time: " + elapsedTime + " ms");
            }

            double averageTime = totalTime / (double) NUM_RUNS;
            System.out.println(algorithm.getClass().getSimpleName() + " Average Time: " + averageTime + " ms");
            System.out.println();
        }
    }

    private File[] generateRandomArray() {
        File[] array = new File[ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = new File(random.nextInt(1000));
        }

        return array;
    }
}
