package com.andytech.sorting.algorithms.controllers;


import com.andytech.sorting.algorithms.pojos.response.SortingResponse;
import com.andytech.sorting.algorithms.services.SortingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Andres Toledo on 2/19/18.
 *
 * This class is used to handle the requests for sorting algorithms.
 */
@RestController
public class SortingAlgorithmController {

    Logger logger = LoggerFactory.getLogger(SortingAlgorithmController.class);

    //Sorting Service
    @Autowired
    private SortingService sortingService;

    /**
     * This method is used to handle the request for the selection sort algorithm.
     *
     * @param listToSort The list of integers to sort
     * @param order The order to sort the list in (asc or desc)
     * @param steps Whether to return the steps of the algorithm.
     * @return The response of the sorting algorithm
     */
    @GetMapping("/sorting/selection")
    public ResponseEntity<SortingResponse<Integer>> selectionSort(@RequestBody ArrayList<Integer>listToSort, @RequestParam(name="order",required = false,defaultValue = "asc") String order, @RequestParam(name="steps",defaultValue ="false")boolean steps)
    {
        logger.info("Input values: "+ listToSort.toString());
        return new ResponseEntity<>(sortingService.selectionSort(listToSort,order,steps), HttpStatus.OK);
    }
}
