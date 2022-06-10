package com.example.project2;

import java.util.ArrayList;

public class Vervoersmiddel {
    private static ArrayList<Vervoersmiddel> vervoersmiddelen;
    private String vervoersmiddel;
    private double multiplier;
    private static ArrayList<Vervoersmiddel> vervoersmiddelen = new ArrayList<Vervoersmiddel>();;

    public Vervoersmiddel (String vervoersmiddel, double multiplier) {
        this.vervoersmiddel = vervoersmiddel;
        this.multiplier = multiplier;
        vervoersmiddelen.add(this);
    }

    public double getMultiplier() {
        return this.multiplier;
    }

    public String getVervoersmiddel() {
        return this.vervoersmiddel;
    }

    public static ArrayList<Vervoersmiddel> getVervoersmiddelen() {
        return vervoersmiddelen;
    }
}
