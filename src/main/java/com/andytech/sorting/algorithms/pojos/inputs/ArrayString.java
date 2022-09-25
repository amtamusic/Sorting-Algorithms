package com.andytech.sorting.algorithms.pojos.inputs;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ArrayString {
    private String array;
    private boolean ascending;
    private ArrayList<Integer> arrayInt;

    public ArrayList<Integer> getArrayInt() {
        ArrayList<Integer> arrayInt = new ArrayList<>();
        String[] arrayString = array.split(",");
        for (String s : arrayString) {
            arrayInt.add(Integer.parseInt(s.trim().replace(" ","")));
        }
        return arrayInt;
    }
}
