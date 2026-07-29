# Train Consist Management App

A console-based Java application simulating a railway consist management system, illustrating key Java core concepts—from basic collections and data structures to regular expressions, exception handling, custom exceptions, performance benchmarking, and search/sorting algorithms.

## Project Architecture & Package Structure

The project is structured as a Maven application:

```text
train-consist-management-app/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── app/
    │               ├── TrainApp.java (Entry point executing all UCs)
    │               ├── model/
    │               │   ├── Bogie.java (Base entity)
    │               │   ├── PassengerBogie.java (Extends Bogie)
    │               │   └── GoodsBogie.java (Extends Bogie)
    │               └── exception/
    │                   ├── InvalidCapacityException.java (Checked Exception)
    │                   └── CargoSafetyException.java (Runtime Exception)
    └── test/
        └── java/
            └── com/
                └── app/
                    └── TrainAppTest.java (JUnit 5 verification tests)
```

---

## 20 Implemented Use Cases

* **UC1: Initialize Train and Display Consist Summary** — Setting up program entry point and empty dynamic list count.
* **UC2: Add Passenger Bogies to Train** — Basic `ArrayList` operations (`add`, `remove`, `contains`).
* **UC3: Track Unique Bogie IDs** — Deduplicating IDs using `HashSet`.
* **UC4: Maintain Ordered Bogie IDs** — Modeling sequence additions (head/tail/mid) using `LinkedList`.
* **UC5: Preserve Insertion Order of Bogies** — Maintaining connection order + uniqueness using `LinkedHashSet`.
* **UC6: Map Bogie to Capacity** — Associating bogies to seating capacities using `HashMap`.
* **UC7: Sort Bogies by Capacity** — Custom object comparison sorting using `Comparator`.
* **UC8: Filter Passenger Bogies Using Streams** — Pipeline filtering using Stream API.
* **UC9: Group Bogies by Type** — Structured categorization using `Collectors.groupingBy()`.
* **UC10: Count Total Seats in Train** — Integer aggregation using `reduce()`.
* **UC11: Validate Train ID & Cargo Codes** — Format check logic using regular expressions.
* **UC12: Safety Compliance Check** — Stream `allMatch` checks verifying cylindrical container safety constraints.
* **UC13: Performance Comparison** — Micro-benchmarking imperative `for-loops` vs declarative `streams`.
* **UC14: Handle Invalid Bogie Capacity** — Restricting invalid constructs using checked `InvalidCapacityException`.
* **UC15: Safe Cargo Assignment** — Transaction safety using runtime `CargoSafetyException` within `try-catch-finally`.
* **UC16: Sort Passenger Bogies (Bubble Sort)** — Manual O(n²) Bubble Sort implementation.
* **UC17: Sort Bogie Names** — Alphabetical natural ordering using built-in `Arrays.sort()`.
* **UC18: Linear Search** — Sequential search of an array for a target key.
* **UC19: Binary Search** — Optimized O(log n) divide-and-conquer search on sorted data.
* **UC20: Exception Handling During Search** — Defensive checks raising `IllegalStateException` on empty consists.

---

## Prerequisites

* **Java Development Kit (JDK)**: version 21
* **Apache Maven**: version 3.9+

---

## Getting Started

### 1. Compilation
Build the application and test classes:
```bash
mvn compile test-compile
```

### 2. Execution
Run the console application showing all Use Cases in action:
```bash
mvn exec:java -Dexec.mainClass="com.app.TrainApp"
```

### 3. Running Unit Tests
Execute the JUnit 5 test suite validating all use cases:
```bash
mvn test
```

---
*Developed solely by P J Mugilan.*

