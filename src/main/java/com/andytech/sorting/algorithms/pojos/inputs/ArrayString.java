package com.andytech.sorting.algorithms.pojos.inputs;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class ArrayString {
    @Size(min=1,max = 100,message = "Valid input size is between 1 and 100 characters.")
    @Pattern(regexp = "^([0-9]+)(| *, *[0-9]+)+$",message = "Valid input is a comma separated list of numbers.")
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
