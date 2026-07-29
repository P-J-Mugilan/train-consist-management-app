package com.app;

import com.app.exception.CargoSafetyException;
import com.app.exception.InvalidCapacityException;
import com.app.model.Bogie;
import com.app.model.GoodsBogie;
import com.app.model.PassengerBogie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class TrainAppTest {

    @Test
    public void testPassengerBogieValidCapacity() {
        assertDoesNotThrow(() -> {
            PassengerBogie pb = new PassengerBogie("PB101", "Sleeper", "Passenger", 72);
            assertEquals(72, pb.getCapacity());
        });
    }

    @Test
    public void testPassengerBogieInvalidCapacity() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("PB102", "AC Chair", "Passenger", 0);
        });

        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("PB103", "First Class", "Passenger", -5);
        });
    }

    @Test
    public void testGoodsBogieValidCargo() {
        assertDoesNotThrow(() -> {
            GoodsBogie gb = new GoodsBogie("GB101", "Oil Tanker", "Cylindrical", 100, "Petroleum");
            assertEquals("Petroleum", gb.getCargoType());

            GoodsBogie gb2 = new GoodsBogie("GB102", "Coal Container", "Rectangular", 120, "Coal");
            assertEquals("Coal", gb2.getCargoType());
        });
    }

    @Test
    public void testGoodsBogieUnsafeCargo() {
        assertThrows(CargoSafetyException.class, () -> {
            new GoodsBogie("GB103", "Coal Tanker", "Rectangular", 100, "Petroleum");
        });

        GoodsBogie gb = new GoodsBogie("GB104", "Boxcar", "Rectangular", 120, "Coal");
        assertThrows(CargoSafetyException.class, () -> {
            gb.assignCargo("Petroleum");
        });
    }

    @Test
    public void testRegexPatterns() {
        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

        assertTrue(trainIdPattern.matcher("TRN-1234").matches());
        assertTrue(trainIdPattern.matcher("TRN-0000").matches());
        assertFalse(trainIdPattern.matcher("TRAIN-1234").matches());
        assertFalse(trainIdPattern.matcher("TRN-123").matches());
        assertFalse(trainIdPattern.matcher("TRN-123A").matches());

        assertTrue(cargoCodePattern.matcher("PET-AB").matches());
        assertTrue(cargoCodePattern.matcher("PET-ZZ").matches());
        assertFalse(cargoCodePattern.matcher("PET-12").matches());
        assertFalse(cargoCodePattern.matcher("CARGO-AB").matches());
        assertFalse(cargoCodePattern.matcher("PET-ABC").matches());
    }

    @Test
    public void testLinearSearch() {
        String[] ids = {"BG101", "BG103", "BG105", "BG102"};
        assertEquals(2, linearSearch(ids, "BG105"));
        assertEquals(-1, linearSearch(ids, "BG109"));
    }

    @Test
    public void testBinarySearch() {
        String[] ids = {"BG101", "BG103", "BG105", "BG102"};
        Arrays.sort(ids); // ids: {"BG101", "BG102", "BG103", "BG105"}
        assertEquals(2, binarySearch(ids, "BG103"));
        assertEquals(-1, binarySearch(ids, "BG109"));
    }

    @Test
    public void testBubbleSort() {
        int[] capacities = {72, 56, 24, 100, 80};
        bubbleSort(capacities);
        int[] expected = {24, 56, 72, 80, 100};
        assertArrayEquals(expected, capacities);
    }

    @Test
    public void testComparatorSort() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("BG1", "Sleeper", "Passenger", 72));
        list.add(new Bogie("BG2", "AC Chair", "Passenger", 56));
        list.add(new Bogie("BG3", "First Class", "Passenger", 24));

        list.sort(Comparator.comparingInt(Bogie::getCapacity));

        assertEquals(24, list.get(0).getCapacity());
        assertEquals(56, list.get(1).getCapacity());
        assertEquals(72, list.get(2).getCapacity());
    }

    private int linearSearch(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(String[] array, String key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(array[mid]);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
