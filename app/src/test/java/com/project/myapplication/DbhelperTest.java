package com.project.myapplication;
import static com.project.myapplication.Dbhelper.*;

import com.project.myapplication.Dbhelper;

import static org.junit.Assert.*;

import android.content.Context;
import android.support.annotation.Nullable;

import org.junit.Test;

public class DbhelperTest {

    @Test

    public void testAgeFactorial() {
        int result = ageFactorial("3");
        int expected = 6;
        assertEquals(expected, result);

        result = ageFactorial("5");
        expected = 120;
        assertEquals(expected, result);
    }



}