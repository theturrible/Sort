package com.ig;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Ivan on 6/25/2015.
 */
public class SortTest {


    static int SIZE_OF_TEST_LIST = 1000;  //touch this.

    private List<String> expected = new ArrayList<String>();
    private List<String> actual = new ArrayList<String>();


    @Before
    public void setUp() throws Exception {
            actual.add("a");
            expected.add("a");
            for(int i = 1; i < SIZE_OF_TEST_LIST; i++){
                actual.add("a" + actual.get(i-1));
                expected.add("a" + expected.get(i-1));
            }
            long seed = System.nanoTime();

            Collections.shuffle(expected, new Random(seed));
            Collections.shuffle(expected, new Random(seed));
    }

    @Test
    public void testNullList() {
        Sort s = new Sort();
        s.sortMem(null);
    }

    @Test
    public void testEmpty() {
        Sort s = new Sort();
        s.sortMem(new ArrayList<String>());
    }


    @Test
    public void testSortMem() throws Exception {
        Sort s = new Sort();
        assertThat(actual, is(s.sortMem(expected)));
    }

    @Test
    public void testSortTime() throws Exception {

    }

    @Test
    public void testSortShort() throws Exception {
        Sort s = new Sort();
        assertThat(actual, is(s.sortShort(expected)));
    }

}