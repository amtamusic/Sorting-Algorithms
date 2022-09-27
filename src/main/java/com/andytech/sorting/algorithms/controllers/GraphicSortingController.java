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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@Validated
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
    public String graphSelectionSort(@Validated @ModelAttribute(value = "arrayString") ArrayString arrayString,BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "home";
        }
        printInputs(arrayString);
        SortingResponse sortingResponse = sortingService.selectionSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        setCommonModelAttributes(model,"Selection Sort",sortingResponse);
        return "google-charts";
    }

    @PostMapping("/graph/bubble")
    public String getBubbleSort(@Validated @ModelAttribute(value = "arrayString") ArrayString arrayString,BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "home";
        }
        printInputs(arrayString);
        SortingResponse sortingResponse = sortingService.bubbleSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        setCommonModelAttributes(model, "Bubble Sort", sortingResponse);
        return "google-charts";
    }

    @PostMapping("/graph/insertion")
    public String getInsertionSort(@Validated @ModelAttribute(value = "arrayString") ArrayString arrayString,BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "home";
        }
        printInputs(arrayString);
        SortingResponse sortingResponse = sortingService.insertionSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        setCommonModelAttributes(model, "Insertion Sort", sortingResponse);
        return "google-charts";
    }

    @PostMapping("/graph/merge")
    public String getMergeSort(@Validated @ModelAttribute(value = "arrayString") ArrayString arrayString,BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "home";
        }
        printInputs(arrayString);
        SortingResponse sortingResponse = sortingService.mergeSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        setCommonModelAttributes(model, "Merge Sort", sortingResponse);
        return "google-charts";
    }

    @PostMapping("/graph/quick")
    public String getQuickSort(@Validated @ModelAttribute(value = "arrayString") ArrayString arrayString,BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "home";
        }
        printInputs(arrayString);
        SortingResponse sortingResponse = sortingService.quickSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", true);
        setCommonModelAttributes(model, "Quick Sort", sortingResponse);
        return "google-charts";
    }

    @PostMapping("/metrics/all")
    public String getMetricsAll(Model model,@ModelAttribute(value = "arrayString") ArrayString arrayString) {
        printInputs(arrayString);
        SortingResponse selectionResponse = sortingService.selectionSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", false);
        SortingResponse bubbleResponse = sortingService.bubbleSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", false);
        SortingResponse insertionResponse = sortingService.insertionSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", false);
        SortingResponse mergeResponse = sortingService.mergeSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", false);
        SortingResponse quickResponse = sortingService.quickSort(arrayString.getArrayInt(), arrayString.isAscending()?"asc":"desc", false);
        ArrayList<SortingResponse>responses = new ArrayList<>();
        responses.add(selectionResponse);
        responses.add(bubbleResponse);
        responses.add(insertionResponse);
        responses.add(mergeResponse);
        responses.add(quickResponse);
        model.addAttribute("responses",responses);
        return "metrics";
    }

    public void printInputs(ArrayString arrayString)
    {
        logger.info("Input Array: "+ arrayString.getArray());
        logger.info("Is Ascending: "+ arrayString.isAscending());
    }

    public void setCommonModelAttributes(Model model, String algorithm, SortingResponse sortingResponse)
    {
        if(sortingResponse.getItemsToSort().size()<=100)
        {
            model.addAttribute("algorithm", algorithm+" Input Over 100 Too Large To Show Steps");
        }
        model.addAttribute("algorithm", algorithm);
        model.addAttribute("steps", sortingResponse.getSteps());
        model.addAttribute("step",0);
        model.addAttribute("sorted",sortingResponse.getSorted().toString());
    }
}