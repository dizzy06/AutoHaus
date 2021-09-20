package com.company;

public class StopWatch {

    long start, end;

    public void stopTime(int x) {
        if (x == 0) {
            start = System.nanoTime();
        }
        if (x == 1) {
            end = System.nanoTime();
        }
    }

    public String getElapsedTime() {
        long elapsed = end - start; // vergangene Zeit
        double seconds = (double) elapsed / 1000000000; // von Nano zu Sekunden
        double minutes = seconds / 60;
        int minutesInt = (int) minutes;
        int secondsRest = ((int) ((minutes - minutesInt) * 60));
        String z = "Minuten: " + minutesInt + " Sekunden: " + secondsRest;
        return z;
    }

    public StopWatch() {
    }

}
