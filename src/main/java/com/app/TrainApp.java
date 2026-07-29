package com.app;

import com.app.exception.CargoSafetyException;
import com.app.exception.InvalidCapacityException;
import com.app.model.Bogie;
import com.app.model.GoodsBogie;
import com.app.model.PassengerBogie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        // UC10: Count Total Seats in Train (reduce)
        runUC10();

        // UC11: Validate Train ID & Cargo Codes (Regex)
        runUC11();

        // UC12: Safety Compliance Check for Goods Bogies
        runUC12();

        // UC13: Performance Comparison (Loops vs Streams)
        runUC13();

        // UC14: Handle Invalid Bogie Capacity (Custom Exception)
        runUC14();

        // UC15: Safe Cargo Assignment Using try-catch-finally
        runUC15();

        // UC16: Sort Passenger Bogies by Capacity (Bubble Sort)
        runUC16();

        // UC17: Sort Bogie Names Using Arrays.sort()
        runUC17();

        // UC18: Linear Search for Bogie ID (Array-Based Searching)
        runUC18();

        // UC19: Binary Search for Bogie ID (Optimized Searching)
        runUC19();

        // UC20: Exception Handling During Search Operations
        runUC20();
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

    public static void runUC10() {
        System.out.println("\n--- UC10: Count Total Seats in Train (reduce) ---");
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("BG101", "Sleeper", "Passenger", 72));
        passengerBogies.add(new Bogie("BG102", "AC Chair", "Passenger", 56));
        passengerBogies.add(new Bogie("BG103", "First Class", "Passenger", 24));
        
        System.out.println("Passenger Bogies: " + passengerBogies);
        
        // Calculate total capacity using map() and reduce()
        int totalSeats = passengerBogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        
        System.out.println("Total seating capacity calculated via reduction: " + totalSeats);
    }

    public static void runUC11() {
        System.out.println("\n--- UC11: Validate Train ID & Cargo Codes (Regex) ---");
        
        // RegEx patterns
        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";
        
        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);
        
        // Test data
        String[] testTrainIds = {"TRN-1234", "TRN-9999", "TRN-12A4", "TRAIN-1234", "TRN-123"};
        String[] testCargoCodes = {"PET-AB", "PET-ZX", "PET-12", "CARGO-AB", "PET-A"};
        
        System.out.println("Enforcing Train ID Pattern: " + trainIdRegex);
        for (String id : testTrainIds) {
            Matcher m = trainIdPattern.matcher(id);
            System.out.println("Train ID: '" + id + "' | Valid: " + m.matches());
        }
        
        System.out.println("\nEnforcing Cargo Code Pattern: " + cargoCodeRegex);
        for (String code : testCargoCodes) {
            Matcher m = cargoCodePattern.matcher(code);
            System.out.println("Cargo Code: '" + code + "' | Valid: " + m.matches());
        }
    }

    public static void runUC12() {
        System.out.println("\n--- UC12: Safety Compliance Check for Goods Bogies ---");
        
        // Compliant Train consist
        List<GoodsBogie> compliantTrain = new ArrayList<>();
        compliantTrain.add(new GoodsBogie("GB101", "Oil Tanker", "Cylindrical", 100, "Petroleum"));
        compliantTrain.add(new GoodsBogie("GB102", "Coal Container", "Rectangular", 120, "Coal"));
        compliantTrain.add(new GoodsBogie("GB103", "Grain Container", "Rectangular", 80, "Wheat"));
        
        // Non-compliant Train consist (Cylindrical carrying Coal)
        List<GoodsBogie> nonCompliantTrain = new ArrayList<>();
        nonCompliantTrain.add(new GoodsBogie("GB201", "Oil Tanker", "Cylindrical", 100, "Petroleum"));
        nonCompliantTrain.add(new GoodsBogie("GB202", "Coal Tanker", "Cylindrical", 120, "Coal")); // VIOLATION!
        nonCompliantTrain.add(new GoodsBogie("GB203", "Grain Container", "Rectangular", 80, "Wheat"));
        
        System.out.println("Testing Compliant Train goods consist: " + compliantTrain);
        boolean isCompliant1 = checkSafety(compliantTrain);
        System.out.println("Is Compliant Train safe? " + isCompliant1);
        
        System.out.println("\nTesting Non-Compliant Train goods consist: " + nonCompliantTrain);
        boolean isCompliant2 = checkSafety(nonCompliantTrain);
        System.out.println("Is Non-Compliant Train safe? " + isCompliant2);
    }
    
    private static boolean checkSafety(List<GoodsBogie> train) {
        return train.stream().allMatch(b -> {
            if (b.getType().equalsIgnoreCase("Cylindrical")) {
                return b.getCargoType().equalsIgnoreCase("Petroleum");
            }
            return true;
        });
    }

    public static void runUC13() {
        System.out.println("\n--- UC13: Performance Comparison (Loops vs Streams) ---");
        
        // Create a large dataset of bogies (50,000 items)
        List<Bogie> largeBogieList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            largeBogieList.add(new Bogie("BG" + i, "Bogie_" + i, (i % 2 == 0 ? "Passenger" : "Goods"), (i % 150)));
        }
        
        System.out.println("Initialized test dataset with " + largeBogieList.size() + " bogies.");
        
        // 1. Loop-based processing
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : largeBogieList) {
            if (b.getCapacity() > 100) {
                loopFiltered.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;
        
        // 2. Stream-based processing
        long startTimeStream = System.nanoTime();
        List<Bogie> streamFiltered = largeBogieList.stream()
                .filter(b -> b.getCapacity() > 100)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;
        
        System.out.println("Loop-Based Filter Duration: " + durationLoop + " ns (" + (durationLoop / 1_000_000.0) + " ms)");
        System.out.println("Stream-Based Filter Duration: " + durationStream + " ns (" + (durationStream / 1_000_000.0) + " ms)");
        System.out.println("Filtered Count: " + loopFiltered.size() + " (Streams: " + streamFiltered.size() + ")");
        System.out.println("Benchmarking complete.");
    }

    public static void runUC14() {
        System.out.println("\n--- UC14: Handle Invalid Bogie Capacity (Custom Exception) ---");
        List<PassengerBogie> consist = new ArrayList<>();
        
        // 1. Create a valid Passenger Bogie
        try {
            System.out.println("Creating valid Passenger Bogie with capacity 72...");
            PassengerBogie pb1 = new PassengerBogie("PB101", "Sleeper", "Passenger", 72);
            consist.add(pb1);
            System.out.println("Successfully added: " + pb1);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // 2. Create an invalid Passenger Bogie (capacity <= 0)
        try {
            System.out.println("Creating invalid Passenger Bogie with capacity -10...");
            PassengerBogie pb2 = new PassengerBogie("PB102", "AC Chair", "Passenger", -10);
            consist.add(pb2);
            System.out.println("Successfully added: " + pb2);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("Consist Bogie list after exception validation: " + consist);
    }

    public static void runUC15() {
        System.out.println("\n--- UC15: Safe Cargo Assignment Using try-catch-finally ---");
        GoodsBogie rectangularBogie = new GoodsBogie("GB104", "Boxcar", "Rectangular", 120, "Coal");
        System.out.println("Initial Bogie: " + rectangularBogie);
        
        // 1. Assign safe cargo
        try {
            System.out.println("Assigning 'Grain' to Rectangular bogie...");
            rectangularBogie.assignCargo("Grain");
            System.out.println("Assignment successful. Updated Bogie: " + rectangularBogie);
        } catch (CargoSafetyException e) {
            System.out.println("Safety violation caught: " + e.getMessage());
        } finally {
            System.out.println("[Finally Block] Logging: Cargo assignment transaction (Safe check) completed.");
        }
        
        // 2. Assign unsafe cargo (Petroleum to Rectangular)
        try {
            System.out.println("\nAssigning 'Petroleum' to Rectangular bogie...");
            rectangularBogie.assignCargo("Petroleum");
            System.out.println("Assignment successful. Updated Bogie: " + rectangularBogie);
        } catch (CargoSafetyException e) {
            System.out.println("Safety violation caught: " + e.getMessage());
        } finally {
            System.out.println("[Finally Block] Logging: Cargo assignment transaction (Unsafe check) completed.");
        }
        
        System.out.println("\nFinal Bogie state: " + rectangularBogie);
        System.out.println("Application continues executing safely after transaction logic.");
    }

    public static void runUC16() {
        System.out.println("\n--- UC16: Sort Passenger Bogies by Capacity (Bubble Sort) ---");
        int[] capacities = {72, 56, 24, 100, 80};
        System.out.println("Unsorted Capacities: " + Arrays.toString(capacities));
        
        // Manual Bubble Sort
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap capacities[j] and capacities[j+1]
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
        
        System.out.println("Sorted Capacities (Bubble Sort): " + Arrays.toString(capacities));
    }

    public static void runUC17() {
        System.out.println("\n--- UC17: Sort Bogie Names Using Arrays.sort() ---");
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "Pantry Car", "Engine", "Guard"};
        System.out.println("Unsorted Bogie Types Array: " + Arrays.toString(bogieTypes));
        
        // Sort using Arrays.sort()
        Arrays.sort(bogieTypes);
        
        System.out.println("Sorted Bogie Types Array (Alphabetical): " + Arrays.toString(bogieTypes));
    }

    public static void runUC18() {
        System.out.println("\n--- UC18: Linear Search for Bogie ID (Array-Based Searching) ---");
        String[] bogieIds = {"BG101", "BG103", "BG105", "BG102", "BG104"};
        System.out.println("Bogie IDs Array: " + Arrays.toString(bogieIds));
        
        // Test search 1: Present element
        String searchKey1 = "BG105";
        int index1 = linearSearch(bogieIds, searchKey1);
        if (index1 != -1) {
            System.out.println("Search Key '" + searchKey1 + "' found at index " + index1 + ".");
        } else {
            System.out.println("Search Key '" + searchKey1 + "' not found.");
        }
        
        // Test search 2: Absent element
        String searchKey2 = "BG109";
        int index2 = linearSearch(bogieIds, searchKey2);
        if (index2 != -1) {
            System.out.println("Search Key '" + searchKey2 + "' found at index " + index2 + ".");
        } else {
            System.out.println("Search Key '" + searchKey2 + "' not found.");
        }
    }
    
    private static int linearSearch(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) {
                return i; // Found - stop search and return index
            }
        }
        return -1; // Not found
    }

    public static void runUC19() {
        System.out.println("\n--- UC19: Binary Search for Bogie ID (Optimized Searching) ---");
        String[] bogieIds = {"BG101", "BG103", "BG105", "BG102", "BG104"};
        System.out.println("Unsorted Bogie IDs Array: " + Arrays.toString(bogieIds));
        
        // Precondition: Sort the array first
        Arrays.sort(bogieIds);
        System.out.println("Sorted Bogie IDs Array: " + Arrays.toString(bogieIds));
        
        // Test search 1: Present element
        String searchKey1 = "BG104";
        int index1 = binarySearch(bogieIds, searchKey1);
        if (index1 != -1) {
            System.out.println("Search Key '" + searchKey1 + "' found at index " + index1 + ".");
        } else {
            System.out.println("Search Key '" + searchKey1 + "' not found.");
        }
        
        // Test search 2: Absent element
        String searchKey2 = "BG109";
        int index2 = binarySearch(bogieIds, searchKey2);
        if (index2 != -1) {
            System.out.println("Search Key '" + searchKey2 + "' found at index " + index2 + ".");
        } else {
            System.out.println("Search Key '" + searchKey2 + "' not found.");
        }
    }
    
    private static int binarySearch(String[] array, String key) {
        int low = 0;
        int high = array.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2; // Midpoint index
            int cmp = key.compareTo(array[mid]);
            
            if (cmp == 0) {
                return mid; // Match found
            } else if (cmp < 0) {
                high = mid - 1; // Search left half
            } else {
                low = mid + 1; // Search right half
            }
        }
        return -1; // Range exhausted, not found
    }

    public static void runUC20() {
        System.out.println("\n--- UC20: Exception Handling During Search Operations ---");
        
        // Create an empty list of bogie IDs
        List<String> emptyBogieIds = new ArrayList<>();
        System.out.println("Empty Bogies List: " + emptyBogieIds);
        
        // Attempt search on empty collection
        try {
            System.out.println("Attempting search on empty list...");
            searchInList(emptyBogieIds, "BG101");
            System.out.println("Search succeeded.");
        } catch (IllegalStateException e) {
            System.out.println("Validation Exception caught: " + e.getMessage());
        }
        
        System.out.println("Application continues executing safely after defensive empty checking.");
    }
    
    private static int searchInList(List<String> list, String key) {
        // Defensive check: Throw exception if empty
        if (list == null || list.isEmpty()) {
            throw new IllegalStateException("Cannot perform search operation: The train consist has no bogies loaded.");
        }
        return list.indexOf(key);
    }
}
