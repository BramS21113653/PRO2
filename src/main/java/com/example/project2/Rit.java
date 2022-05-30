package com.example.project2;

import java.util.*;

public class Rit {
    private Integer id;
    private Integer gerbuikersid;
    private String vervoersmiddel;
    private Integer afstand;
    public Rit(Integer id, Integer gebruikersid, String vervoersmiddel, Integer afstand){
        this.id = id;
        this.gerbuikersid = gebruikersid;
        this.vervoersmiddel = vervoersmiddel;
        this.afstand = afstand;
    }
}