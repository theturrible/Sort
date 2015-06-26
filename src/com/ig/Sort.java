package com.ig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ivan on 6/25/2015.
 */
public class Sort {
    private List<String> toSort;

    {


    }

    public List<String> sortMem( List<String> sort) {

        if( sort != null){
            this.toSort = sort;
            quick(0,toSort.size()-1);
            return toSort;
        }else{
            return null;
        }
    }

    public void sortTime() {


    }

    private void quick(int low, int high) {
        int i = low,
            j = high;

        String pivot = toSort.get(low + (high-low)/2);

        // Divide into two lists
        while (i <= j) {
            while (toSort.get(i).length() < pivot.length()) {
                i++;
            }
            while (toSort.get(j).length() > pivot.length()) {
                j--;
            }
            if (i <= j) {
                Collections.swap(toSort, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quick(low, j);
        }
        if (i < high) {
            quick(i, high);
        }
    }



    public  List<String> sortShort(List<String> toBeSorted) {
        Collections.sort(toBeSorted);
        return toBeSorted;
    }
}
