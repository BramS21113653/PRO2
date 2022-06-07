package com.example.project2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Table {
    private SimpleStringProperty tableNaam;
    private SimpleIntegerProperty tablePlaats;
    private SimpleIntegerProperty tablePunten;

    public Table(String tableNaam, int tablePlaats, int tablePuten){
        this.tableNaam = new SimpleStringProperty(tableNaam);
        this.tablePlaats = new SimpleIntegerProperty(tablePlaats);
        this.tablePunten = new SimpleIntegerProperty(tablePuten);
    }

    public String getTableNaam() {
        return tableNaam.get();
    }

    public void setTableNaam(String tableNaam) {
        this.tableNaam = new SimpleStringProperty(tableNaam);
    }

    public int getTablePlaats() {
        return tablePlaats.get();
    }

    public void setTablePlaats(int tablePlaats) {
        this.tablePlaats = new SimpleIntegerProperty(tablePlaats);
    }

    public int getTablePunten() {
        return tablePlaats.get();
    }

    public void setTablePunten(int tablePunten) {
        this.tablePunten = new SimpleIntegerProperty(tablePunten);
    }
}

