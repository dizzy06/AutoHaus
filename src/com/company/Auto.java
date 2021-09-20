package com.company;

public class Auto {
    // Klassenvariable
    //public static int autoId;
    private static int counter = 1;
    // Instanzvariablen, Eigenschaften
    private int autoId;
    private String hersteller, farbe;
    private double preis, ps;
    // Verhalten
    public Auto() {

    }

    public Auto(String hersteller, String farbe, double preis, double ps) {
        this.autoId = counter;
        this.hersteller = hersteller;
        this.farbe = farbe;
        this.preis = preis;
        this.ps = ps;
        counter++;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public double getPs() {
        return ps;
    }

    public void setPs(double ps) {
        this.ps = ps;
    }
}
