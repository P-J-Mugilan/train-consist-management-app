package com.app;

import com.app.model.Bogie;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TrainApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        
        // UC1: Initialize Train and Display Consist Summary
        runUC1();

        // UC2: Add Passenger Bogies to Train (ArrayList Operations)
        runUC2();

        // UC3: Track Unique Bogie IDs (Set – HashSet)
        runUC3();

        // UC4: Maintain Ordered Bogie IDs (LinkedList)
        runUC4();

        // UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
        runUC5();

        // UC6: Map Bogie to Capacity (HashMap)
        runUC6();

        // UC7: Sort Bogies by Capacity (Comparator)
        runUC7();

        // UC8: Filter Passenger Bogies Using Streams
        runUC8();

        // UC9: Group Bogies by Type (Collectors.groupingBy)
        runUC9();
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

    public static void runUC3() {
        System.out.println("\n--- UC3: Track Unique Bogie IDs (Set – HashSet) ---");
        Set<String> bogieIds = new HashSet<>();
        
        // Add duplicate values intentionally
        System.out.println("Adding BG101...");
        bogieIds.add("BG101");
        System.out.println("Adding BG101 (duplicate)...");
        bogieIds.add("BG101");
        System.out.println("Adding BG102...");
        bogieIds.add("BG102");
        System.out.println("Adding BG103...");
        bogieIds.add("BG103");
        
        // Print final set
        System.out.println("Final Bogie IDs Set (HashSet): " + bogieIds);
        System.out.println("Observe that duplicates are automatically removed.");
    }

    public static void runUC4() {
        System.out.println("\n--- UC4: Maintain Ordered Bogie IDs (LinkedList) ---");
        LinkedList<String> consist = new LinkedList<>();
        
        // Add bogies
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");
        System.out.println("Initial consist: " + consist);
        
        // Insert Pantry Car at position 2 (index 2)
        consist.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at position 2: " + consist);
        
        // Remove the first and last bogie
        String first = consist.removeFirst();
        String last = consist.removeLast();
        System.out.println("Removed first: " + first + ", Removed last: " + last);
        
        // Display final ordered train consist
        System.out.println("Final ordered train consist (LinkedList): " + consist);
    }

    public static void runUC5() {
        System.out.println("\n--- UC5: Preserve Insertion Order of Bogies (LinkedHashSet) ---");
        Set<String> formation = new LinkedHashSet<>();
        
        // Attach bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        System.out.println("Initial formation: " + formation);
        
        // Attempt to attach a duplicate bogie
        System.out.println("Attempting to attach duplicate Sleeper...");
        boolean added = formation.add("Sleeper");
        System.out.println("Was 'Sleeper' added again? " + added);
        
        // Display final formation order
        System.out.println("Final ordered train consist (LinkedHashSet): " + formation);
        System.out.println("Observe that order is preserved and duplicates are prevented.");
    }

    public static void runUC6() {
        System.out.println("\n--- UC6: Map Bogie to Capacity (HashMap) ---");
        Map<String, Integer> capacityMap = new HashMap<>();
        
        // Insert capacity values
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        capacityMap.put("First Class", 24);
        
        System.out.println("Bogie-Capacity Mappings stored in HashMap.");
        
        // Iterate over the map using entrySet()
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println("Bogie Name: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }
    }

    public static void runUC7() {
        System.out.println("\n--- UC7: Sort Bogies by Capacity (Comparator) ---");
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("BG101", "Sleeper", "Passenger", 72));
        passengerBogies.add(new Bogie("BG102", "AC Chair", "Passenger", 56));
        passengerBogies.add(new Bogie("BG103", "First Class", "Passenger", 24));
        
        System.out.println("Before Sorting: " + passengerBogies);
        
        // Sort by capacity using Comparator
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));
        
        System.out.println("After Sorting by Capacity (Ascending): " + passengerBogies);
    }

    public static void runUC8() {
        System.out.println("\n--- UC8: Filter Passenger Bogies Using Streams ---");
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("BG101", "Sleeper", "Passenger", 72));
        passengerBogies.add(new Bogie("BG102", "AC Chair", "Passenger", 56));
        passengerBogies.add(new Bogie("BG103", "First Class", "Passenger", 24));
        
        System.out.println("All Bogies: " + passengerBogies);
        
        // Filter bogies capacity > 60 using Stream pipeline
        List<Bogie> filteredBogies = passengerBogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        
        System.out.println("Filtered Bogies (Capacity > 60): " + filteredBogies);
    }

    public static void runUC9() {
        System.out.println("\n--- UC9: Group Bogies by Type (Collectors.groupingBy) ---");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("BG101", "Sleeper", "Passenger", 72));
        bogies.add(new Bogie("BG102", "AC Chair", "Passenger", 56));
        bogies.add(new Bogie("BG103", "First Class", "Passenger", 24));
        bogies.add(new Bogie("BG104", "Rectangular Cargo", "Goods", 120));
        bogies.add(new Bogie("BG105", "Cylindrical Tanker", "Goods", 150));
        
        System.out.println("All Bogies list: " + bogies);
        
        // Group by type
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
        
        // Print grouped structure
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Type: " + entry.getKey() + " | Bogies: " + entry.getValue());
        }
    }
}
