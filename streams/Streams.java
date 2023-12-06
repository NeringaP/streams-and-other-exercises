package org.example.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {

//        filteringAndPrinting();
//        mapping();
//        sortingAndCollecting();
//        groupingAndCounting();
//        calculateAverage();
//        calculateSumOfOddNumbers();
//        calculateSumOfEvenNumbers();
//        removeDuplicates();
//        countStringsThatStartWithSpecificLetter();
//        sortStringsDescending();
//        findMax();
        findSecondSmallest();
        findSecondLargest();

    }

    private static void findSecondLargest() {
        List<Integer> numbers = Arrays.asList(11, 25, 83, 24, 55, 63, 17, 80, 9, 47);
        Integer secondLargest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println(secondLargest);
    }

    private static void findSecondSmallest() {
        List<Integer> numbers = Arrays.asList(11, 25, 83, 24, 55, 63, 17, 80, 9, 47);
        Integer secondSmallest = numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println(secondSmallest);
    }

    private static void findMax() {
        List<Integer> numbers = Arrays.asList(11, 25, 83, 24, 55, 63, 17, 80, 9, 47);
        int max = numbers.stream()
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);

//        Integer max_val = numbers.stream()
//                .max(Integer::compare)
//                .orElse(null);

        System.out.println(max);
    }

    private static void sortStringsDescending() {
        List<String> strings = Arrays.asList("Alpes", "Miskai", "Upes", "Gyvunai", "Geles", "Kalnai", "Pievos");
        List<String> sortedDescending = strings.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(sortedDescending);
    }

    private static void countStringsThatStartWithSpecificLetter() {
        List<String> strings = Arrays.asList("Alpes", "Miskai", "Upes", "Gyvunai", "Geles", "Kalnai", "Pievos");
        char letter = 'g';
        int counted = (int) strings.stream()
                .map(String::toLowerCase)
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .count();

        System.out.println(counted);
    }

    private static void removeDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 3, 4, 5, 6, 7, 9, 10, 8, 8, 8, 8);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);
    }

    private static void calculateSumOfEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sumOfEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println(sumOfEvenNumbers);
    }

    private static void calculateSumOfOddNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sumOfOddNumbers = numbers.stream()
                .filter(num -> num % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println(sumOfOddNumbers);
    }

    private static void calculateAverage() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       Double average = numbers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));

//        double average = numbers.stream()
//                .mapToDouble(Integer::doubleValue)
//                .average()
//                .orElse(0.0);

        System.out.println(average);
    }

    private static void groupingAndCounting() {
//        Create a list of strings representing names.
        String[] strings = {"Alpes", "Miskai", "Upes", "Gyvunai", "Geles", "Kalnai", "Pievos"};

//        Use a stream to group names by their length.
//        Print the counts of names for each length.
        Arrays.stream(strings)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                .forEach((k,v) -> System.out.println("String length - " + k + " : Count - " + v));
    }

    private static void sortingAndCollecting() {
//        Create a list of custom objects (e.g., Person with name and age).
        Plant plant1 = new Plant("Primrose", "yellow", true, 2);
        Plant plant2 = new Plant("Daffodil", "while", true, 1);
        Plant plant3 = new Plant("Iris", "violet", false, 5);
        Plant[] plants = {plant1, plant2, plant3};

//        Use a stream to sort the objects based on age.
//        Collect the sorted objects into a new list.
        Collection<Plant> sortedPlantsBasedOnAge = Arrays.stream(plants)
                .sorted(Comparator.comparing(Plant::getAge))
                .toList();

        //        Print the sorted list.
        sortedPlantsBasedOnAge
                .forEach(System.out::println);
    }

    private static void mapping() {
//        Create a list of strings.
        String[] strings = {"Alpes", "Miskai", "Upes", "Gyvunai", "Geles", "Kalnai", "Pievos"};

//        Use a stream to convert each string to uppercase.
//        Print the modified strings.
        Arrays.stream(strings)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static void filteringAndPrinting() {
        //        Create a list of integers.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        Use a stream to filter out even numbers.
//        Print the resulting numbers.
        numbers.stream()
                .filter(number -> ((number % 2) == 0))
                .forEach(System.out::println);
    }
}
