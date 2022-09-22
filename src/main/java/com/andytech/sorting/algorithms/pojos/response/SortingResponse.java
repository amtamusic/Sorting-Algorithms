package com.andytech.sorting.algorithms.pojos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Andres Toledo on 2/19/18.
 *
 * This class is used to return the response of a sorting algorithm.
 */
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortingResponse<T> {
    private ArrayList<T> itemsToSort;
    private ArrayList<ArrayList<T>>steps;
    private ArrayList<T> sorted;
    private String message;
    private String algorithm;
    private Long numSteps;
    private Long timeTakenMillis;
    private Long inputSize;
}
