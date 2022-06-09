package com.example.project2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Table {

    private String name;
    private int plaats;
    private int punten;

    public Table(String name, int plaats, int punten) {
        this.name = name;
        this.plaats = plaats;
        this.punten = punten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaats() {
        return plaats;
    }

    public void setPlaats(int plaats) {
        this.plaats = plaats;
    }

    public int getPunten() {
        return punten;
    }

    public void setPunten(int punten) {
        this.punten = punten;
    }
}

