package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tests {

    byte num1 = 2;
    byte num2 = 3;
    float num3 = 2;
    long num5 = 2;
    float num4 = 2;

    long  num7 = num5;



    float sum = num3 + num4;

    public static void main(String[] args) {
        String[] arr = {"Lol", "Book", "Cup", "Rock", "Book"};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.asList(arr));
        List<String> list = new ArrayList<>(List.of(arr));
        Collections.sort(list);
        Collections.reverse(list);
        list.removeIf(s -> s.equalsIgnoreCase("book"));
        System.out.println(list);

        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());


    }
}
