package com.syntax.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(12, 12, 7, 7, 7, 7, 7));

        System.out.println(countDuplicates(numbers));
        //System.out.println(dupCount); // if we want to see total duplicate values
    }

    static int dupCount = 0;

    static int countDuplicates(List<Integer> numbers) {
        HashSet<Integer> duplicates = new HashSet<>();
        HashSet<Integer> nonDupList = new HashSet<>();
        for (int num : numbers) {
            if (!duplicates.add(num)) {
                nonDupList.add(num);
                dupCount += 1;
            }
        }
        return nonDupList.size();
    }

}



