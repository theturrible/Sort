package com.ig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ivan on 6/25/2015.
 */
public class Sort {
    private List<String> toSort;

    //call ins sort
    public List<String> sortMem( List<String> sort) {
        //empty checks
        if(sort == null || sort.isEmpty()){
            return null;
        }

        this.toSort = sort;
        ins();
        return toSort;
    }
    //call quick sort
    public List<String> sortTime(List<String> sort) {
        //empty checks
        if(sort == null || sort.isEmpty()){
            return null;
        }

        this.toSort = sort;
        quick(0,toSort.size()-1);

        return toSort;
    }
    //insertion sort implementation,
    // InPlace alg, good for memory, not good on massive lists, but adaptive(for half-sorted
    private void ins(){
        int N = toSort.size();
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (toSort.get(j-1).compareTo(toSort.get(j)) > 0) {
                    Collections.swap(toSort, j-1, j);
                }
                else break;
            }
        }
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
    // one liner using Collections.sort and a simple comparator.
    public  List<String> sortShort(List<String> toBeSorted) {

        Collections.sort(toBeSorted, Comparator.comparing(String::length));
        return toBeSorted;
    }
}
