package com.app;

import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        
        // UC1: Initialize Train and Display Consist Summary
        runUC1();

        // UC2: Add Passenger Bogies to Train (ArrayList Operations)
        runUC2();
    }

    public static void runUC1() {
        System.out.println("\n--- UC1: Initialize Train and Display Consist Summary ---");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized dynamically.");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
    }

    public static void runUC2() {
        System.out.println("\n--- UC2: Add Passenger Bogies to Train (ArrayList Operations) ---");
        List<String> passengerBogies = new ArrayList<>();
        
        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        System.out.println("Passenger bogies added: " + passengerBogies);
        
        // Remove AC Chair
        passengerBogies.remove("AC Chair");
        System.out.println("After removing AC Chair: " + passengerBogies);
        
        // Check if Sleeper exists
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Is 'Sleeper' present in consist? " + hasSleeper);
        
        // Print final list state
        System.out.println("Final passenger bogies list: " + passengerBogies);
    }
}
