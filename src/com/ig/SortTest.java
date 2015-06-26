package com.ig;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Ivan on 6/25/2015.
 */
public class SortTest {


    static int SIZE_OF_TEST_LIST = 1000;  //touch this.

    static List<String> expected = new ArrayList<String>();
    static List<String> actual = new ArrayList<String>();

    {
        actual.add("a");
        expected.add("a");
        for(int i = 1; i < SIZE_OF_TEST_LIST; i++) {
            actual.add("a" + actual.get(i - 1));
            expected.add("a" + expected.get(i - 1));
        }
        Collections.shuffle(expected, new Random(System.nanoTime()));
    }

    @Test
    public void testSortMem() throws Exception {

    }

    @Test
    public void testSortTime() throws Exception {

    }

    @Test
    public void testSortShort() throws Exception {

        Sort s = new Sort();
        //assertThat(actual, is(s.sortShort(expected)));
    }

}