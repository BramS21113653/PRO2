package com.example.project2;

import java.util.ArrayList;

public class Vervoersmiddel {
    private static ArrayList<Vervoersmiddel> vervoersmiddelen;
    private String vervoersmiddel;
    private Integer uitstootPerLiter;

    public Vervoersmiddel (String vervoersmiddel, Integer uitstootPerLiter) {
        this.vervoersmiddel = vervoersmiddel;
        this.uitstootPerLiter = uitstootPerLiter;
    }

    public Integer getUitstootPerLiter() {
        return this.uitstootPerLiter;
    }

    public String getVervoersmiddel() {
        return this.vervoersmiddel;
    }

    public static ArrayList<Vervoersmiddel> getVervoersmiddelen() {
        return vervoersmiddelen;
    }
}
