package com.ig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ivan on 6/25/2015.
 */
public class Sort {

    //used to store the arg passed in for recursive calls.
    private List<String> toSort;

    //call ins sort
    public List<String> sortMem( List<String> sort) {
        if(isValid(sort)) {
            this.toSort = sort;
            ins();

            return toSort;
        }else{
            return null;
        }
    }
    //call quick sort
    public List<String> sortTime(List<String> sort) {
        //empty checks
        if(isValid(sort)) {
            this.toSort = sort;
            quick(0, toSort.size() - 1);

            return toSort;
        }else{
            return null;
        }
    }
    // one liner using Collections.sort and a simple comparator.
    public  List<String> sortShort(List<String> toBeSorted) {
        if(isValid(toBeSorted)) {
            Collections.sort(toBeSorted, Comparator.comparing(String::length));

            return toBeSorted;
        }else{
            return null;
        }
    }


    /*
        Algorithms.
     */

    /**
     * @param none
     * @return void
     */
    //insertion sort implementation,
    // InPlace alg, good for memory, not good on massive lists, but adaptive(for half-sorted
    private void ins(){
        for (int i = 1; i < toSort.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (toSort.get(j-1).compareTo(toSort.get(j)) > 0) { Collections.swap(toSort, j-1, j); }
                else {break;}
            }
        }
    }

    /**
     * @param low, high
     * @return void
     */
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

    /*
        Util
     */

    /**
     * @param sort
     * @return true is valid, false if invalid
     */
    // checks if the list is populated
    private boolean isValid(List<String> sort){
        if(sort == null || sort.isEmpty()){
            return false;
        }else{
            return true;
        }

    }
}
