package org.example.colatasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DigitCounterMain {

    public static void main(String[] args) throws Exception {

        int start;
        int end;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter series start point: ");
        if(scanner.hasNextInt()) {
            start = scanner.nextInt();
        } else {
            throw new Exception("Not a number");
        }

        System.out.println("Enter series end point: ");
        if(scanner.hasNextInt()) {
            end = scanner.nextInt();
        } else {
            throw new Exception("Not a number");
        }

        System.out.println("Enter digits to count: ");
        String stringOfKeys = scanner.next();

        int[] keys;
        if(stringOfKeys.contains(",")) {
            keys = Arrays.stream(stringOfKeys.split(",")).mapToInt(Integer::parseInt).toArray();
        } else {
            keys = new int[] {Integer.parseInt(stringOfKeys)};
        }

        DigitCounter digitCounter = new DigitCounter(start, end, keys);
        digitCounter.count();
    }

    public static class DigitCounter {
        private int start;
        private int end;
        private int[] keys;

        public DigitCounter(int start, int end, int[] keys) {
            this.start = start;
            this.end = end;
            this.keys = keys;
        }

        public void count() {
            List<Integer> digitArray = getDigits();
            List<Integer> sortedList = digitArray.stream().sorted().toList();

            for (int target : keys) {
                System.out.println(target + " occurs "
                        + Collections.frequency(sortedList, target)
                        + " times");
            }
        }

        private List<Integer> getDigits() {
            List<Integer> digitArray = new ArrayList<>();
            for(int i = start; i <= end; i++) {
                for(int j = 10; j > 1; j *= 10) {
                    int digit = i % j / (j / 10);
                    if(digit <= 0) {
                        break;
                    } else {
                        digitArray.add(digit);
                    }
                }
            }
            return digitArray;
        }
    }
}
