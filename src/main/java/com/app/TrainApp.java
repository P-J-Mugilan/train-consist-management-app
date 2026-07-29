package com.app;

import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        
        // UC1: Initialize Train and Display Consist Summary
        runUC1();
    }

    public static void runUC1() {
        System.out.println("\n--- UC1: Initialize Train and Display Consist Summary ---");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized dynamically.");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
    }
}
