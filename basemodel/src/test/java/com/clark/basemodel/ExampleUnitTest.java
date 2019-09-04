package com.clark.basemodel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150, f5 = 150, f6 = 160;
        System.out.println("result f1 == f2 : " + (f1 == f2));
        System.out.println("result f3 == f4 : " + (f3 == f4));
        System.out.println("result f5 == f6 : " + (f5 == f6));
        assertEquals(4, 2 + 2);
    }
}