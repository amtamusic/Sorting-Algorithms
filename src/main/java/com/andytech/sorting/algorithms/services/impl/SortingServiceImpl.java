package com.andytech.sorting.algorithms.services.impl;

import com.andytech.sorting.algorithms.pojos.response.SortingResponse;
import com.andytech.sorting.algorithms.services.SortingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SortingServiceImpl implements SortingService {

    //Selection Sort
    @Override
    public SortingResponse<Integer> selectionSort(ArrayList<Integer> input, String order, boolean returnSteps) {
        //validate input
        if (input == null || input.size() == 0) {
            return new SortingResponse<>(null, null, null, "Input is null or empty", null, null, null, null, null);
        }
        //Initialize response object
        SortingResponse<Integer> response = new SortingResponse<>();
        ArrayList<ArrayList<Integer>> steps = new ArrayList<>();
        response.setAlgorithm("Selection Sort");
        response.setItemsToSort(copyList(input));
        steps.add(copyList(input));
        response.setNumSteps(0L);
        response.setNumSwaps(0L);
        //Record start time
        long start = System.currentTimeMillis();
        //Sort
        for (int index1 = 0; index1 < input.size() - 1; index1++) {
            //If the list is already sorted, break out of the loop
            int minMaxIndex = index1;
            for (int index2 = index1 + 1; index2 < input.size(); index2++) {
                //If the list is in ascending order, swap if the first element is greater than the second
                if (order.equals("asc")) {
                    if (input.get(index2) < input.get(minMaxIndex)) {
                        minMaxIndex = index2;
                    }
                } else {
                    if (input.get(index2) > input.get(minMaxIndex)) {
                        minMaxIndex = index2;
                    }
                }
                response.setNumSteps(response.getNumSteps() + 1);
            }

            Collections.swap(input, index1, minMaxIndex);
            steps.add(copyList(input));
            response.setNumSwaps(response.getNumSwaps() + 1);
        }
        //Record end time
        long end = System.currentTimeMillis();
        //If the user wants to see the steps, add them to the response
        if (returnSteps) {
            response.setSteps(steps);
        }
        response.setMessage("Sorting Completed");
        response.setTimeTakenMillis(end - start);
        //Add the sorted list to the response
        response.setSorted(input);
        response.setInputSize((long) input.size());
        return response;
    }

    @Override
    public SortingResponse<Integer> bubbleSort(ArrayList<Integer> input, String order, boolean returnSteps) {
        //validate input
        if (input == null || input.size() == 0) {
            return new SortingResponse<>(null, null, null, "Input is null or empty", null, null, null, null, null);
        }
        //Initialize response object
        SortingResponse<Integer> response = new SortingResponse<>();
        ArrayList<ArrayList<Integer>> steps = new ArrayList<>();
        response.setAlgorithm("Bubble Sort");
        response.setItemsToSort(copyList(input));
        steps.add(copyList(input));
        response.setNumSteps(0L);
        response.setNumSwaps(0L);
        //Record start time
        long start = System.currentTimeMillis();
        //Sort
        int swaps = 1;
        // If the list is already sorted, break out of the loop
        while (swaps > 0) {
            swaps = 0;
            //If the list is in ascending order, swap if the first element is greater than the second
            for (int index = 0; index < input.size() - 1; index++) {
                if (order.equals("asc")) {
                    if (input.get(index) > input.get(index + 1)) {
                        Collections.swap(input, index, index + 1);
                        steps.add(copyList(input));
                        response.setNumSwaps(response.getNumSwaps() + 1);
                        swaps++;
                    }
                } else {
                    if (input.get(index) < input.get(index + 1)) {
                        Collections.swap(input, index, index + 1);
                        steps.add(copyList(input));
                        response.setNumSwaps(response.getNumSwaps() + 1);
                        swaps++;
                    }
                }
                response.setNumSteps(response.getNumSteps() + 1);
            }
        }
        //Record end time
        long end = System.currentTimeMillis();
        //If the user wants to see the steps, add them to the response
        if (returnSteps) {
            response.setSteps(steps);
        }
        response.setMessage("Sorting Completed");
        response.setTimeTakenMillis(end - start);
        //Add the sorted list to the response
        response.setSorted(input);
        response.setInputSize((long) input.size());
        return response;
    }

    @Override
    public SortingResponse<Integer> insertionSort(ArrayList<Integer> input, String order, boolean returnSteps) {
        //validate input
        if (input == null || input.size() == 0) {
            return new SortingResponse<>(null, null, null, "Input is null or empty", null, null, null, null, null);
        }
        //Initialize response object
        SortingResponse<Integer> response = new SortingResponse<>();
        ArrayList<ArrayList<Integer>> steps = new ArrayList<>();
        response.setAlgorithm("Insertion Sort");
        response.setItemsToSort(copyList(input));
        steps.add(copyList(input));
        response.setNumSteps(0L);
        response.setNumSwaps(0L);
        //Record start time
        long start = System.currentTimeMillis();
        //Sort
        long swaps = 0;
        for (int i = 1; i < input.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (order.equals("asc")) {
                    if (input.get(j) < input.get(j - 1)) {
                        Collections.swap(input, j, j - 1);
                        steps.add(copyList(input));
                        response.setNumSwaps(response.getNumSwaps() + 1);
                        swaps++;
                    }
                } else {
                    if (input.get(j) > input.get(j - 1)) {
                        Collections.swap(input, j, j - 1);
                        steps.add(copyList(input));
                        response.setNumSwaps(response.getNumSwaps() + 1);
                        swaps++;
                    }
                }
                response.setNumSteps(response.getNumSteps() + 1);
            }
        }
        //Record end time
        long end = System.currentTimeMillis();
        //If the user wants to see the steps, add them to the response
        if (returnSteps) {
            response.setSteps(steps);
        }
        response.setNumSwaps(swaps);
        response.setMessage("Sorting Completed");
        response.setTimeTakenMillis(end - start);
        //Add the sorted list to the response
        response.setSorted(input);
        response.setInputSize((long) input.size());
        return response;
    }

    @Override
    public SortingResponse<Integer> mergeSort(ArrayList<Integer> input, String order, boolean returnSteps) {
        //validate input
        if (input == null || input.size() == 0) {
            return new SortingResponse<>(null, null, null, "Input is null or empty", null, null, null, null, null);
        }
        //Initialize response object
        SortingResponse<Integer> response = new SortingResponse<>();
        ArrayList<ArrayList<Integer>> steps = new ArrayList<>();
        response.setAlgorithm("Insertion Sort");
        response.setItemsToSort(copyList(input));
        steps.add(copyList(input));
        response.setNumSteps(0L);
        response.setNumSwaps(0L);
        //Record start time
        long start = System.currentTimeMillis();
        //Sort
        long swaps = 0;
        return doMergesort(input, 0, input.size() - 1, order, steps, response, swaps, start, returnSteps);
    }

    //Recursive method to split the list into smaller lists
    public SortingResponse doMergesort(ArrayList<Integer> input, int low, int high, String order, ArrayList<ArrayList<Integer>> steps, SortingResponse<Integer> response, long swaps, long start,boolean returnSteps) {
        if (low < high) {
            int mid = (low + high) / 2;
            doMergesort(input, low, mid, order, steps, response, swaps, start, returnSteps);
            doMergesort(input, mid + 1, high, order, steps, response, swaps, start, returnSteps);
            return merge(input, low, mid, high, order, steps, response, swaps, start, returnSteps);
        }
        return response;
    }

    //Merge function
    private SortingResponse merge(ArrayList<Integer> input, int low, int mid, int high, String order, ArrayList<ArrayList<Integer>> steps, SortingResponse<Integer> response, long swaps, long start,boolean returnSteps) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = input.get(low + i);
        }
        for (int j = 0; j < n2; j++) {
            right[j] = input.get(mid + 1 + j);
        }
        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (order.equals("asc")) {
                if (left[i] <= right[j]) {
                    input.set(k, left[i]);
                    i++;
                } else {
                    input.set(k, right[j]);
                    j++;
                }
            } else {
                if (left[i] >= right[j]) {
                    input.set(k, left[i]);
                    i++;
                } else {
                    input.set(k, right[j]);
                    j++;
                }
            }
            steps.add(copyList(input));
            response.setNumSteps(response.getNumSteps() + 1);
            k++;
        }
        while (i < n1) {
            input.set(k, left[i]);
            i++;
            k++;
        }
        while (j < n2) {
            input.set(k, right[j]);
            j++;
            k++;
        }
        long end = System.currentTimeMillis();
        response.setSorted(input);
        if (returnSteps){
            response.setSteps(steps);
        }
        response.setNumSteps((long) steps.size());
        response.setNumSwaps(0L);
        response.setInputSize((long) input.size());
        response.setMessage("Sorting Completed (Swaps not available for Merge Sort)");
        response.setTimeTakenMillis(end - start);
        response.setAlgorithm("Merge Sort");
        return response;
    }


    public ArrayList<Integer> copyList(ArrayList<Integer> list) {
        return (new ArrayList<>(List.copyOf(list)));
    }
}
