package com.example.project2;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class VervoersmiddelTest {

    @org.junit.Test
    public void getMultiplier() {
        Vervoersmiddel vervoersmiddel = new Vervoersmiddel("test", 3.0);
        double multiplier = vervoersmiddel.getMultiplier();
        assertEquals(3.0, multiplier, 0.00000001);
    }

    @org.junit.Test
    public void getVervoersmiddel() {
        Vervoersmiddel vervoersmiddel = new Vervoersmiddel("test", 3);
        String test = vervoersmiddel.getVervoersmiddel();
        assertEquals("test", test);
    }

    @org.junit.Test
    public void getVervoersmiddelen() {
        Vervoersmiddel vervoersmiddel = new Vervoersmiddel("test", 3);
        ArrayList test = vervoersmiddel.getVervoersmiddelen();
        assertTrue(0 < test.size() );
    }
}