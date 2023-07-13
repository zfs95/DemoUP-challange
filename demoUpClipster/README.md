Cuvrystraße 1, 10997 Berlin
Java Developer Position
Questions to: dhaeberlein@demoup-clipster.com

# Developer Challenge

**22nd May 2023**

## General requirements

Dear Candidate,

We highly appreciate that you take your valuable time in order to solve this challenge and ultimately become part of our team. To be sure that you are a match for the tasks to come, we need you to solve this challenge. Make sure to apply all good practices a software engineer is forced to use day by day in his or her job.

As a result, we expect a buildable Java project with dependency management. The project should be importable to a publicly available IDE (e.g. IDEA or Eclipse). Please work as comparable as possible on this project as it would be a production system. Apply everything you usually would do, except for deployment (no CI/CD).

The task has a clear time box. After receiving the task, you have 2 days to work on the challenge. Afterwards, we will grade your work and, if considered, we will have a 60-90 min call talking with you about the result. You will also be assessed during the call, and your final grade will be available afterwards. Also, in the call, we will ask you to extend the solution slightly, so be prepared.

## Task 1 - Understanding Legacy code

In your position as a Java Developer at DemoUp Clipster, you get assigned to the valuable task of refactoring a legacy system. The system sorts a number of user files by name using the following algorithm. This software was written in a much older version of Java:

```java
public static Comparable[] sort(Comparable[] array) {
        if (array == null) {
          return new Comparable[] {};
        }
        if (array.length > 1) {
          int mid = array.length / 2;
          Comparable[] left = new Comparable[mid];
          for (int i = 0; i < mid; i++) {
            left[i] = array[i];
          }
          Comparable[] right = new Comparable[array.length - mid];
          for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
          }
          sortArray(left);
          sortArray(right);
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
```

a) What is the name of the algorithm?
<br>
<p style="color:steelblue">It appears to be a <strong>"Merge Sort"</strong> algorithm based on its implementation.
In merge sort, the array is continuously divided in half until it cannot be further divided. After sorting the subarrays, they are merged into one sorted array.</p>

b) Reprogram the algorithm with a newer Java version (>= 8)! What would you change and why?
<br>
<p style="color:steelblue">See class <strong>"MergeSort"</strong>.</p>
<p style="color:steelblue">A number of changes have been made, including: </p>

<ul>
<li style="color:steelblue">Splitting the array into left and right halves using Arrays.copyOfRange.</li>

<li style="color:steelblue">The right and left halves of the sort method are called recursively.</li>

<li style="color:steelblue">Using the compareTo method instead of the explicit comparison == 1.</li>

<li style="color:steelblue">SortArray has been renamed to sort.</li>

<li style="color:steelblue">For clarity, the class has been renamed MergeSort.</li>
</ul>

c) Compare the output of the two solutions with the output of Java's standard sort algorithm. What differences can you observe?
<p style="color:steelblue">Both the reprogrammed algorithm and Java's standard sort algorithm produce the same sorted result. Java's Arrays.sort seems to be faster.</p>

## Task 2 - Microbenchmark

As of now, you have three different implementations at your disposal. In this task, you should create a small framework for testing the different sorting algorithms' runtime.

For that, we already have an interface which is implemented like this:

```java
public class LegacySort implements SortAlgorithm<File> {
    @Override
    public File[] sort(File[] input) {
        //..
    }
}
```
a) How could the SortAlgorithm Interface look like? Create a java-File with that interface!
<br>
<p style="color:steelblue">See interface <strong>"SortAlgorithm"</strong>.</p>

b) Create derived classes of that interface for the three existing algorithms!
<br>
<p style="color:steelblue">See class <strong>"SortAlgorithm", "ClassicSort" and "MergeSort"</strong>.</p>

c) For your microbenchmark task, make sure to create an adequate runner to easily add a new algorithm. The runner should be able to create a different amount of random comparable instances (use Integer for that case). Reuse the same input values for all algorithms to optimize compatibility!
<p style="color:steelblue">See class <strong>"Microbenchmark"</strong>.</p>
d) Finally, perform the microbenchmarking, collect, and present the results. What are the issues with such an approach?
<p style="color:steelblue">Results can be viewed by running the application.</p>
<p style="color:steelblue"> There are a few issues to consider when performing microbenchmarking.</p>
<ul>
<li style="color:steelblue">Depending on the input data, sorting algorithms can perform differently. It may not be possible to obtain a comprehensive analysis of the algorithms' performance characteristics by using random input data. Understanding how algorithms behave under various scenarios requires considering different types of input data (e.g., sorted, partially sorted, reversed).</li>

<li style="color:steelblue">The current implementation only measures the execution time of algorithms without considering other factors like memory usage or algorithm stability.</li>

</ul>