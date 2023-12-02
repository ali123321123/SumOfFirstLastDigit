package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DetermineOrder {
    private static int part1(String line) {
        boolean foundFirst = false;
        int first = 0, last = 0;

        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!foundFirst) {
                    first = Character.getNumericValue(c);
                    foundFirst = true;
                }
                last = Character.getNumericValue(c);
            }
        }

        return first * 10 + last;
    }

    private static int part2(String line) {
          final Map<String, String> numberMap = new HashMap<>();
          {
            numberMap.put("zero", "zero0zero");
            numberMap.put("one", "one1one");
            numberMap.put("two", "two2two");
            numberMap.put("three", "three3three");
            numberMap.put("four", "four4four");
            numberMap.put("five", "five5five");
            numberMap.put("six", "six6six");
            numberMap.put("seven", "seven7seven");
            numberMap.put("eight", "eight8eight");
            numberMap.put("nine", "nine9nine");
        }
        for (Map.Entry<String, String> entry : numberMap.entrySet()) {
            String word = entry.getKey();
            String digit = entry.getValue();

            if (line.contains(word)) {
                line = line.replace(word, digit);
            }
        }

        return part1(line);
    }

    public static void main(String[] args) {

        String fileName = "C:\\testutvikling\\SumOfFirstLastDigit\\src\\main\\java\\org\\example\\input.txt";
        int sumPart1 = 0;
        int sumPart2 = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sumPart1 += part1(line);
                sumPart2 += part2(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Sum of Part 1: " + sumPart1);
        System.out.println("Sum of Part 2: " + sumPart2);
    }
}


