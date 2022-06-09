package com.example.project2;

import java.util.ArrayList;

public class Vervoersmiddel {
    private String vervoersmiddel;
    private Integer uitstootPerLiter;
    private ArrayList<Vervoersmiddel> vervoersmiddelen = new ArrayList<Vervoersmiddel>();

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

    public ArrayList<Vervoersmiddel> getVervoersmiddelen() {
        return vervoersmiddelen;
    }
}
