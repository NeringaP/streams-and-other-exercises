package org.example.colatasks;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CommonWordsMain {
    public static void main(String[] args) throws IOException {
        String input = getContentFromFile("src/main/resources/declaration_of_independence.txt");

        String[] array = cleanAndTokenizeString(input);

        Map<String, Integer> occurrenceOfStrings = countOccurrences(array);

        occurrenceOfStrings.remove("of");
        occurrenceOfStrings.remove("the");
        occurrenceOfStrings.remove("to");
        occurrenceOfStrings.remove("and");
        occurrenceOfStrings.remove("for");

        Map<String, Integer> sortedHashMap = getSortedHashMap(occurrenceOfStrings);

        printToCsvMostCommonWords(sortedHashMap, 100);

    }

    private static Map<String, Integer> countOccurrences(String[] array) {
        Map<String, Integer> occurrenceOfStrings = new HashMap<>();

        for(String str: array) {
            Integer currentValue = occurrenceOfStrings.get(str);
            if(currentValue == null) {
                occurrenceOfStrings.put(str, 1);
            } else {
                occurrenceOfStrings.put(str, currentValue + 1);
            }
        }
        return occurrenceOfStrings;
    }

    private static String[] cleanAndTokenizeString(String input) {
        String string = input.replaceAll("[,.:;-]", "");
        String[] array = string.toLowerCase().split("\\s+");
        return array;
    }

    private static String getContentFromFile(String file) throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);

        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    private static void printToCsvMostCommonWords(Map<String, Integer> sortedHashMap, int numOfWords) throws IOException {
        int count = 0;

        String csvFilePath = "src/main/resources/result.csv";

        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(csvFilePath), CSVFormat.DEFAULT)) {

            csvPrinter.printRecord("Word", "Frequency");

            for (Map.Entry<String, Integer> entry : sortedHashMap.entrySet()) {
                csvPrinter.printRecord(entry.getKey(), entry.getValue());
                count++;
                if (count == numOfWords) {
                    break;
                }
            }

            System.out.println("CSV file was written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }

    private static Map<String, Integer> getSortedHashMap(Map<String, Integer> occurrenceOfStrings) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(occurrenceOfStrings.entrySet());

        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        Map<String, Integer> sortedHashMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : entryList) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
