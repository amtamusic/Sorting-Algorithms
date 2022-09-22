package com.andytech.sorting.algorithms.services;

import com.andytech.sorting.algorithms.pojos.response.SortingResponse;

import java.util.ArrayList;

public interface SortingService {
    //Bubble Sort
    SortingResponse<Integer> bubbleSort(ArrayList<Integer>input,String order,boolean returnSteps);
}
