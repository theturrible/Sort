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
        //empty checks
        if(sort == null || sort.isEmpty()){
            return null;
        }

        this.toSort = sort;
        quick(0,toSort.size()-1);

        return toSort;
    }

    public void sortTime() {


    }


    //quick sort impl.

    private void quick(int low, int high) {
        int i = low, j = high;
        String p = toSort.get(low + (high-low)/2);
        while (i <= j) {
            while (toSort.get(i).length() < p.length()){ i++; }
            while (toSort.get(j).length() > p.length()){ j--; }
            if (i <= j){
                Collections.swap(toSort, i, j);
                i++; j--;
            }
        }
        if (low < j) { quick(low, j); }
        if (i < high) { quick(i, high); }
    }



    public  List<String> sortShort(List<String> toBeSorted) {
        Collections.sort(toBeSorted);
        return toBeSorted;
    }
}
