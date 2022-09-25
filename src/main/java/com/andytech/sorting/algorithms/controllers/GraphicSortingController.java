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
        printInputs(arrayString);
        SortingResponse sortingResponse = sortingService.selectionSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        setCommonModelAttributes(model,"Selection Sort",sortingResponse);
        return "google-charts";
    }

    @PostMapping("/graph/bubble")
    public String getBubbleSort(Model model,@ModelAttribute(value = "arrayString") ArrayString arrayString) {
        printInputs(arrayString);
        SortingResponse sortingResponse = sortingService.bubbleSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        setCommonModelAttributes(model, "Bubble Sort", sortingResponse);
        return "google-charts";
    }

    @PostMapping("/graph/insertion")
    public String getInsertionSort(Model model,@ModelAttribute(value = "arrayString") ArrayString arrayString) {
        printInputs(arrayString);
        SortingResponse sortingResponse = sortingService.insertionSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        setCommonModelAttributes(model, "Insertion Sort", sortingResponse);
        return "google-charts";
    }

    @PostMapping("/graph/merge")
    public String getMergeSort(Model model,@ModelAttribute(value = "arrayString") ArrayString arrayString) {
        printInputs(arrayString);
        SortingResponse sortingResponse = sortingService.mergeSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        setCommonModelAttributes(model, "Merge Sort", sortingResponse);
        return "google-charts";
    }

    @PostMapping("/graph/quick")
    public String getQuickSort(Model model,@ModelAttribute(value = "arrayString") ArrayString arrayString) {
        printInputs(arrayString);
        SortingResponse sortingResponse = sortingService.quickSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        setCommonModelAttributes(model, "Quick Sort", sortingResponse);
        return "google-charts";
    }

    public void printInputs(ArrayString arrayString)
    {
        logger.info("Input Array: "+ arrayString.getArray());
        logger.info("Is Ascending: "+ arrayString.isAscending());
    }

    public void setCommonModelAttributes(Model model, String algorithm, SortingResponse sortingResponse)
    {
        model.addAttribute("algorithm", algorithm);
        model.addAttribute("steps", sortingResponse.getSteps());
        model.addAttribute("step",0);
        model.addAttribute("sorted",sortingResponse.getSorted().toString());
    }
}