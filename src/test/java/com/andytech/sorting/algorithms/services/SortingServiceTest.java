package com.andytech.sorting.algorithms.services;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith( SpringRunner.class )
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SortingServiceTest {

    @Autowired
    private SortingService sortingService;

    //Sorting Null List Test
    @Test
    public void sortingNullTest() {
        assert(sortingService.selectionSort(null, null, false) != null);
        assert(sortingService.bubbleSort(null, null, false) != null);
        assert(sortingService.insertionSort(null, null, false) != null);
        assert(sortingService.mergeSort(null, null, false) != null);

    }

    //Sorting Ascending List Test
    @Test
    public void sortingAscTest() {
        assert(sortingService.selectionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", false).getSorted().toString().equals("[1, 5, 6, 7, 11]"));
        assert(sortingService.bubbleSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", false).getSorted().toString().equals("[1, 5, 6, 7, 11]"));
        assert(sortingService.insertionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", false).getSorted().toString().equals("[1, 5, 6, 7, 11]"));
        assert(sortingService.mergeSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", false).getSorted().toString().equals("[1, 5, 6, 7, 11]"));
    }

    //Sorting Descending List Test
    @Test
    public void sortingDescTest() {
        assert(sortingService.selectionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "desc", false).getSorted().toString().equals("[11, 7, 6, 5, 1]"));
        assert(sortingService.bubbleSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "desc", false).getSorted().toString().equals("[11, 7, 6, 5, 1]"));
        assert(sortingService.insertionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "desc", false).getSorted().toString().equals("[11, 7, 6, 5, 1]"));
        assert(sortingService.mergeSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "desc", false).getSorted().toString().equals("[11, 7, 6, 5, 1]"));
    }

    //Sorting Steps In Response Test
    @Test
    public void sortingStepsTest() {
        assert(sortingService.selectionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", true).getSteps().size() > 0);
        assert(sortingService.bubbleSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", true).getSteps().size() > 0);
        assert(sortingService.insertionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", true).getSteps().size() > 0);
        assert(sortingService.mergeSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", true).getSteps().size() > 0);
    }

    //Sorting Steps Not In Response Test
    @Test
    public void sortingStepsNullTest() {
        assert(sortingService.selectionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", false).getSteps() == null);
        assert(sortingService.bubbleSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", false).getSteps() == null);
        assert(sortingService.insertionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", false).getSteps() == null);
        assert(sortingService.mergeSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", false).getSteps() == null);
    }

}
