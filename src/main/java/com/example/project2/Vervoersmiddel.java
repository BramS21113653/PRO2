package com.example.project2;

// singleton pattern

import java.util.ArrayList;

public class Vervoersmiddel {
    private String vervoersmiddel;
    private double multiplier;
    private static ArrayList<Vervoersmiddel> vervoersmiddelen;

    public Vervoersmiddel (String vervoersmiddel, double multiplier) {
        this.vervoersmiddel = vervoersmiddel;
        this.multiplier = multiplier;
        getVervoersmiddelen().add(this);
    }

    public double getMultiplier() {
        return this.multiplier;
    }

    public String getVervoersmiddel() {
        return this.vervoersmiddel;
    }

    public static ArrayList<Vervoersmiddel> getVervoersmiddelen() {
                if (vervoersmiddelen == null) {
                vervoersmiddelen = new ArrayList<>();
                }
        return vervoersmiddelen;
    }
}
