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

    //globals
    static int SIZE_OF_TEST_LIST = 1000;  //touch this. - heap space limits on 50000
    private List<String> expected = new ArrayList<String>();
    private List<String> actual = new ArrayList<String>();


    //actual and expected, expected shuffled twice with nanotime seed(random dist)

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


    //sort tests with timers
    @Test
    public void testSortMem() throws Exception {
        long startTime = System.nanoTime();


        Sort s = new Sort();
        assertThat(actual, is(s.sortMem(expected)));

        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        System.out.println((double) elapsed / 1000000000.0 + "s to run SortMem");
    }

    @Test
    public void testSortTime() throws Exception {
        long startTime = System.nanoTime();


        Sort s = new Sort();
        assertThat(actual, is(s.sortTime(expected)));

        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        System.out.println((double) elapsed / 1000000000.0 + "s to run SortTime");
    }

    @Test
    public void testSortShort() throws Exception {
        long startTime = System.nanoTime();


        Sort s = new Sort();
        assertThat(actual, is(s.sortShort(expected)));

        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        System.out.println((double) elapsed / 1000000000.0 + "s to run SortShort");
    }


    //null/empty checks
    @Test
    public void testNullList() {
        Sort s = new Sort();
        s.sortTime(null);
    }
    @Test
    public void testEmpty() {
        Sort s = new Sort();
        s.sortTime(new ArrayList<String>());
    }
    @Test
    public void testNullListMemory() {
        Sort s = new Sort();
        s.sortMem(null);
    }
    @Test
    public void testEmptyMemory() {
        Sort s = new Sort();
        s.sortMem(new ArrayList<String>());
    }
    @Test
    public void testNullListShort() {
        Sort s = new Sort();
        s.sortShort(null);
    }
    @Test
    public void testEmptyShort() {
        Sort s = new Sort();
        s.sortShort(new ArrayList<String>());
    }


    //

}