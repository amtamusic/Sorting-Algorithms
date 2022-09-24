package com.andytech.sorting.algorithms.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import com.andytech.sorting.algorithms.pojos.response.SortingResponse;
import com.andytech.sorting.algorithms.services.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class GraphicSortingController {

    @Autowired
    private SortingService sortingService;


    @GetMapping("/graph/selection")
    public String graphSelectionSort(Model model) {
        String algorithm = "Selection Sort";
        SortingResponse sortingResponse = sortingService.selectionSort(new ArrayList<>(Arrays.asList(5, 3, 2, 4, 1)), "asc", true);
        Map<String, Integer> graphData = new TreeMap<>();
        for(int i =0 ; i < sortingResponse.getItemsToSort().size(); i++){
            graphData.put(i+"", (Integer) sortingResponse.getSorted().get(i));
        }
        model.addAttribute("algorithm", algorithm);
        model.addAttribute("chartData", graphData);
        model.addAttribute("steps", sortingResponse.getSteps());
        model.addAttribute("step",0);
        return "google-charts";
    }

    @GetMapping("/graph/bubble")
    public String getBubbleSort(Model model) {
        String algorithm = "Selection Sort";
        SortingResponse sortingResponse = sortingService.selectionSort(new ArrayList<>(Arrays.asList(5, 3, 2, 4, 1)), "asc", true);
        Map<String, Integer> graphData = new TreeMap<>();
        for(int i =0 ; i < sortingResponse.getItemsToSort().size(); i++){
            graphData.put(i+"", (Integer) sortingResponse.getSorted().get(i));
        }
        model.addAttribute("algorithm", algorithm);
        model.addAttribute("chartData", graphData);
        model.addAttribute("steps", sortingResponse.getSteps());
        model.addAttribute("step",0);
        return "google-charts";
    }
}