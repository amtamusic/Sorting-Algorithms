package com.andytech.sorting.algorithms.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import com.andytech.sorting.algorithms.pojos.inputs.ArrayString;
import com.andytech.sorting.algorithms.pojos.response.SortingResponse;
import com.andytech.sorting.algorithms.services.SortingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GraphicSortingController {

    Logger logger = LoggerFactory.getLogger(GraphicSortingController.class);

    @Autowired
    private SortingService sortingService;

    @GetMapping("/")
    public String home(Model model)
    {
        ArrayString arrayString = new ArrayString();
        model.addAttribute("arrayString",arrayString);
        return "home";
    }
    @PostMapping("/graph/selection")
    public String graphSelectionSort(Model model,@ModelAttribute(value = "arrayString") ArrayString arrayString) {
        logger.info("Input Array: "+ arrayString.getArray());
        logger.info("Is Ascending: "+ arrayString.isAscending());
        String algorithm = "Selection Sort";
        SortingResponse sortingResponse = sortingService.selectionSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        model.addAttribute("algorithm", algorithm);
        model.addAttribute("steps", sortingResponse.getSteps());
        model.addAttribute("step",0);
        model.addAttribute("sorted",sortingResponse.getSorted().toString());
        return "google-charts";
    }

    @PostMapping("/graph/bubble")
    public String getBubbleSort(Model model,@ModelAttribute(value = "arrayString") ArrayString arrayString) {
        logger.info("Input Array: "+ arrayString.getArray());
        logger.info("Is Ascending: "+ arrayString.isAscending());
        String algorithm = "Bubble Sort";
        SortingResponse sortingResponse = sortingService.bubbleSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        model.addAttribute("algorithm", algorithm);
        model.addAttribute("steps", sortingResponse.getSteps());
        model.addAttribute("step",0);
        model.addAttribute("sorted",sortingResponse.getSorted().toString());
        return "google-charts";
    }

    @PostMapping("/graph/insertion")
    public String getInsertionSort(Model model,@ModelAttribute(value = "arrayString") ArrayString arrayString) {
        logger.info("Input Array: "+ arrayString.getArray());
        logger.info("Is Ascending: "+ arrayString.isAscending());
        String algorithm = "Insertion Sort";
        SortingResponse sortingResponse = sortingService.insertionSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        model.addAttribute("algorithm", algorithm);
        model.addAttribute("steps", sortingResponse.getSteps());
        model.addAttribute("step",0);
        model.addAttribute("sorted",sortingResponse.getSorted().toString());
        return "google-charts";
    }

    @PostMapping("/graph/merge")
    public String getMergeSort(Model model,@ModelAttribute(value = "arrayString") ArrayString arrayString) {
        logger.info("Input Array: "+ arrayString.getArray());
        logger.info("Is Ascending: "+ arrayString.isAscending());
        String algorithm = "Merge Sort";
        SortingResponse sortingResponse = sortingService.mergeSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        model.addAttribute("algorithm", algorithm);
        model.addAttribute("steps", sortingResponse.getSteps());
        model.addAttribute("step",0);
        model.addAttribute("sorted",sortingResponse.getSorted().toString());
        return "google-charts";
    }
}