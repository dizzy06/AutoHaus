package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Datenbank {

   private Auto[] collection;
   private Auto[] collectionTemp;
   private int counter = 1;
   private Auto[] dbTemp;
   private Auto autoTemp;

    public Datenbank(int x) {
        collection = new Auto[x];
        for (int i = 0; i < collection.length; i++) {
            collection[i] = null;
        }

    }

    public void createAuto (String h, String f, double p, double ps) {
        //collection[counter-1] = new Auto(h,f,p,ps);
        //counter++;
        // Sucht sich die nächste freie Stelle
        for(int i = 0; i < collection.length; i++) {
            if(collection[i] == null) {
                collection[i] = new Auto(h,f,p,ps);
                break;
            }
        }

    }

    public void callAuto(int id) {
        if (collection[id-1] != null) {
            System.out.println("ID: "+collection[id-1].getAutoId());
            System.out.println("Hersteller: "+collection[id-1].getHersteller());
            System.out.println("Farbe: "+collection[id-1].getFarbe());
            System.out.println("PS: "+collection[id-1].getPs());
            System.out.println("Preis: "+collection[id-1].getPreis());
            System.out.println("");
        } else {
            System.out.println("NOCH KEIN EINTRAG");
        }

    }

    public void deleteAuto(int id) {

        collection[id-1] = null;
    }

    public void callAllAuto() {
        for(int i = 0; i < collection.length; i++) {
            if(collection[i] != null ) {
                System.out.println((i+1)+". Eintrag:\n");
                System.out.println("ID: "+collection[i].getAutoId());
                System.out.println("Hersteller: "+collection[i].getHersteller());
                System.out.println("Farbe: "+collection[i].getFarbe());
                System.out.println("PS: "+collection[i].getPs());
                System.out.println("Preis: "+collection[i].getPreis());
                System.out.println("");
            } else {
                //System.out.println((i+1)+" Eintrag: LEER");
            }
        }
    }

    public void searchByID(int id) {
        boolean gibtEs = false;
        for(int i = 0 ; i < collection.length; i++) {
            if(collection[i] != null) {
                if(collection[i].getAutoId() == id) {
                    System.out.println((i+1)+". Eintrag:\n");
                    System.out.println("ID: "+collection[i].getAutoId());
                    System.out.println("Hersteller: "+collection[i].getHersteller());
                    System.out.println("Farbe: "+collection[i].getFarbe());
                    System.out.println("PS: "+collection[i].getPs());
                    System.out.println("Preis: "+collection[i].getPreis());
                    System.out.println("");
                    gibtEs = true;
                }
            }
        }
        if(gibtEs == false) {
            System.out.println("Kein Eintrag gefunden");
        }
    }

    public void searchByHersteller(String x) {
        String temp = x.toLowerCase();
        boolean gibtEs = false;
        for(int i = 0 ; i < collection.length; i++) {
            if(collection[i] != null) {
                if(collection[i].getHersteller().toLowerCase().equals(temp)) {
                    System.out.println((i+1)+". Eintrag:\n");
                    System.out.println("ID: "+collection[i].getAutoId());
                    System.out.println("Hersteller: "+collection[i].getHersteller());
                    System.out.println("Farbe: "+collection[i].getFarbe());
                    System.out.println("PS: "+collection[i].getPs());
                    System.out.println("Preis: "+collection[i].getPreis());
                    System.out.println("");
                    gibtEs = true;
                }
            }

        }
        if(gibtEs == false) {
            System.out.println("Kein Eintrag gefunden");
        }
    }
    public void sortByAlphabet() {
        dbTemp = new Auto[50];
        Auto temp = new Auto();
        dbTemp = collection;
        //Bubble-Sort
        for (int i = 0; i < dbTemp.length; i++) {
            if (dbTemp[i] != null) {
                for(int j = i+1; j < dbTemp.length; j++) {
                    if(dbTemp[j] != null) {
                        if(dbTemp[j].getHersteller().toLowerCase().compareTo(dbTemp[i].getHersteller().toLowerCase()) < 0) {
                            temp = dbTemp[i];
                            dbTemp[i]  = dbTemp[j];
                            dbTemp[j] = temp;
                         }
                    }
                }
            }

        }
        collection = dbTemp;
    }

    public void killGaps() {
        int tempIndex;
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] != null) {
                tempIndex = i;
                autoTemp = collection[i];
                for (int j = 0; j < collection.length; j++) {
                    if (collection[j] == null) {
                        collection[j] = autoTemp;
                        collection[tempIndex] = null;
                        break;
                    }
                }
            }
        }
    }

    public void deleteById(int id) {
        for(int i = 0; i < collection.length; i++) {
            if(collection[i] != null) {
                if(collection[i].getAutoId() == id){
                    collection[i] = null;
                }
            }
        }
    }

    public void sortAlternate () {
        killGaps(); // entfernt Lücken
        int counter = 0;
        for(int i = 0; i < collection.length; i++) { // zaehlt Anzahl der Taschen
            if(collection[i] != null) counter++;
        }
        Auto[] temp = new Auto[counter];  // neues Array so groß wie viel Tacshen voll sind
        for(int i = 0; i < counter; i++) {
            temp[i] = collection[i];
        }
        Arrays.sort(temp, Comparator.comparing(Auto::getHersteller)); // sortiert Array Temp
        for(int i = 0; i < collection.length; i++) {
            collection[i] = null;
        }
        for(int i = 0; i < temp.length; i++) { // zurückkopieren auf das orig. Array
            collection[i] = temp[i];
        }
    }

    public void fillAuto() {
        collection[0] = new Auto("Mazda","Rot",12000,156);
        collection[1] = new Auto("Ford","Lila",1200,144);
        collection[2] = new Auto("Renault","Blau",1070,100);
        collection[3] = new Auto("VW","Rot",2499,189);
        collection[4] = new Auto("Ford","Rot",8700,123);
        collection[5] = new Auto("Nissan","Weiss",10999,156);
        collection[6] = new Auto("Toyota","Gruen",33443,934);
        collection[7] = new Auto("Mitsubishi","Orange",98870,444);
        collection[8] = new Auto("Ford","Rot",12000,100);
        collection[9] = new Auto("Chevrolet","Gelb",33000,233);

        collection[10] = new Auto("BMW","Gold",99999,232);
        collection[11] = new Auto("Ford","Grün",14569,555);
        collection[12] = new Auto("Renault","Blau",66333,100);
        collection[13] = new Auto("VW","Schwarz",98544,236);
        collection[14] = new Auto("Chevrolett","Grau",987444,555);
        collection[15] = new Auto("Ferrari","Weiss",89000,333);
        collection[16] = new Auto("Toyota","Rot",19999,145);
        collection[17] = new Auto("Mitsubishi","Rot",10999,447);
        collection[18] = new Auto("Jeep","Blau",12000,258);
        collection[19] = new Auto("Mercedes","Gelb",47887,233);
    }
}
