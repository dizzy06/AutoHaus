package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private boolean loop = true;
    private Datenbank db1 = new Datenbank(50);
    private final String regex = "[0-9]{1,10}"; // Reguläre Ausdruck
    private final String regex2 = "[0-9]{2}";
    private final String regex3 = "([1-9]|[1-4][0-9]|50)";
    private StopWatch timer = new StopWatch(); // Klasse um die Zeit zu stoppen

    //private static ArrayList<Auto> collection = new ArrayList<>();

    public UserInterface() {
        timer.stopTime(0); // start des Timers
        String eingabe;
        while (loop) {
            switch (menu()) {
                case "N":
                    createAuto();
                    break;
                case "L":
                    //deleteAuto();
                    deleteByParameter();
                    break;
                case "A":
                    //callAuto();
                    db1.killGaps();
                    break;
                case "B":
                    loop = false; // Schleife wird abgebrochen, weil kein Code mehr folgt, endet die Klasse UserInterface
                    timer.stopTime(1); // stop des Timers
                    System.out.println("Verbrachte Zeit im Programm: " + timer.getElapsedTime());
                    break;
                case "P":
                    callByParamter();
                    break;
                case "S":
                    db1.sortByAlphabet();
                    break;
                case "ALL":
                    db1.callAllAuto();
                    break;
                case "F":
                    db1.fillAuto();
                    break;
                case "X":
                    db1.sortAlternate();
                    break;
                default:
                    break;
            }
        }
        //db1.searchByID(1);
        //db1.searchByHersteller("Mazda");
    }

    // Hauptmenu
    public String menu () {
        String eingabe = "";
        Scanner sc = new  Scanner(System.in);
        boolean matches = false;
        while (!matches) {
            System.out.println("######## <HAUPTMENU> ########:");
            System.out.println("(N)   --> Neues Auto anlegen");
            System.out.println("(L)   --> Löschen eines Autos");
            System.out.println("(A)   --> Alle luecken entfernen");
            System.out.println("(P)   --> Nach Parameter suchen");
            System.out.println("(ALL) --> Zeige alles");
            System.out.println("(S)   --> Sortiere nach Hersteller");
            System.out.println("(F)   --> Fuelle mit 20 Beispiel-Daten");
            System.out.println("(X)   --> alternatives Sortieren");
            System.out.println("(B)   --> Beenden");
            eingabe = sc.next().toUpperCase();
            if (eingabe.equals("N") ||
                    eingabe.equals("L") ||
                    eingabe.equals("A") ||
                    eingabe.equals("B") ||
                    eingabe.equals("P") ||
                    eingabe.equals("S") ||
                    eingabe.equals("F") ||
                    eingabe.equals("X") ||
                    eingabe.equals("ALL")) {
                matches = true;
            } else {
                System.out.println("Falsche Eingabe");
            }
        }
        return eingabe;
    }
    // Erstellt neues Autos
    public void createAuto() {
        Scanner sc = new Scanner(System.in);
        String h;
        String f;
        String check;
        double p = 0;
        double ps = 0;
        boolean matches = false;
        System.out.println("Hersteller:");
        h = sc.nextLine();
        System.out.println("Farbe:");
        f = sc.nextLine();

        while(!matches) {
            System.out.println("Preis");
            //p = sc.nextDouble();
            check = sc.next();
            matches = check.matches(regex);
            if(matches) {
                p = Double.parseDouble(check);
            } else {
                System.out.println("Keine nummerische Eingabe !!!");
            }
        }
        matches = false;

        while(!matches) {
            System.out.println("PS");
            //ps = sc.nextDouble();
            check = sc.next();
            matches = check.matches(regex);
            if(matches) {
                ps = Double.parseDouble(check);
            } else {
                System.out.println("Keine nummerische Eingabe !!!");
            }
        }
        matches = false;


        db1.createAuto(h,f,p,ps);
    }

    public void callAuto() {
        Scanner sc = new Scanner(System.in);
        boolean matches = false;
        String check;
        int id = 0;

        while(!matches) {
            System.out.println("ID eingeben");
            //int id  = sc.nextInt();
            check = sc.next();
            matches = check.matches(regex);
            if(matches) {
                id = Integer.parseInt(check);
            } else {
                System.out.println("Keine nummerische Eingabe !!!");
            }
        }
        matches = false;
        db1.searchByID(id);
    }

    public void deleteAuto() {
        Scanner sc = new Scanner(System.in);
        String check;
        boolean matches = false;
        int id = 0;
        while(!matches) {
            System.out.println("Nummer des Eintrags eingeben");
            //int id  = sc.nextInt();
            check = sc.next();

            matches = check.matches(regex3);

            if(matches) {
                id = Integer.parseInt(check);
            } else {
                System.out.println("Keine nummerische Eingabe oder außerhalb des Wertebereichs !!!");
            }
        }
        db1.deleteAuto(id);
    }

    public void deleteById() {
        Scanner sc = new Scanner(System.in);
        String check;
        boolean matches = false;
        int id = 0;
        while(!matches) {
            System.out.println("ID eingeben");
            //int id  = sc.nextInt();
            check = sc.next();

            matches = check.matches(regex);

            if(matches) {
                id = Integer.parseInt(check);
            } else {
                System.out.println("Keine nummerische Eingabe");
            }
        }
        db1.deleteById(id);
    }

    public void callByHersteller() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hersteller eingeben:");
        String temp = sc.nextLine();
        db1.searchByHersteller(temp);
    }

    public void callByRegister() {
        Scanner sc = new Scanner(System.in);
        String check;
        boolean matches = false;
        int id = 0;

        while(!matches) {
            System.out.println("Eintragsnummer eingeben!:");
            //int temp = sc.nextInt();
            check = sc.next();
            matches = check.matches(regex3);
            if(matches) {
                id = Integer.parseInt(check);
            } else {
                System.out.println("Keine nummerische Eingabe oder außerhalb des Wertebereichs(1-50) !!!");
            }
        }
        db1.callAuto(id);
    }

    public void deleteByParameter() {
        String eingabe = "";
        boolean matches = false;
        Scanner sc = new Scanner(System.in);
        while(!matches) {
            System.out.println("Bitte waehlen Sie ein Parameter:\n");
            System.out.println("(1) --> Eintragsnummer");
            System.out.println("(2) --> ID");
            eingabe = sc.next();
            if(     eingabe.equals("1")
                    ||  eingabe.equals("2")) {
                matches = true;
            } else {
                System.out.println("Falsche Eingabe!!");
            }
        }
        switch (eingabe) {
            case "1":
                deleteAuto();
                break;
            case "2":
                deleteById();
                break;
            default:
                break;
        }
    }

    public void callByParamter() {
        String eingabe = "";
        boolean matches = false;
        Scanner sc = new Scanner(System.in);
        while(!matches) {
            System.out.println("Bitte waehlen Sie ein Parameter:\n");
            System.out.println("(1) --> Hersteller");
            System.out.println("(2) --> ID");
            System.out.println("(3) --> Listeneintrag");
            eingabe = sc.next();
            if(     eingabe.equals("1")
                ||  eingabe.equals("2")
                ||  eingabe.equals("3")) {
                matches = true;
            } else {
                System.out.println("Falsche Eingabe!!");
            }
        }
        switch (eingabe) {
            case "1":
                callByHersteller();
                break;
            case "2":
                callAuto();
                break;
            case "3":
                callByRegister();
                break;
            default:
                break;
        }

    }

}
