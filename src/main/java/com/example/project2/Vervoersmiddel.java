package com.example.project2;

public class Vervoersmiddel {
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
}
