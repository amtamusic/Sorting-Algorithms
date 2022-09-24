package com.andytech.sorting.algorithms.services;

import com.andytech.sorting.algorithms.pojos.response.SortingResponse;

import java.util.ArrayList;

public interface SortingService {
    //Selection Sort
    SortingResponse<Integer> selectionSort(ArrayList<Integer>input, String order, boolean returnSteps);

    //Bubble Sort
    SortingResponse<Integer> bubbleSort(ArrayList<Integer>input, String order, boolean returnSteps);

    //Insertion Sort
    SortingResponse<Integer> insertionSort(ArrayList<Integer>input, String order, boolean returnSteps);

    //Merge Sort
    SortingResponse<Integer> mergeSort(ArrayList<Integer>input, String order, boolean returnSteps);
}
