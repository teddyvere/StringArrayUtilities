package com.zipcodewilmington;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {

        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {

        return Arrays.stream(array).anyMatch(value ::equals);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Swap elements
            String temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Move towards the middle
            left++;
            right--;
        }
        return array;
    }
    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
            int left = 0;
            int right = array.length - 1;

            while (left < right) {
                if (!array[left].equals(array[right])) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        Set<Character> alphabetSet = new HashSet<>();

        for (String str : array) {
            for (char c : str.toLowerCase().toCharArray()) {
                if (Character.isLetter(c)) {
                    alphabetSet.add(c);
                }
            }
        }

        // Check if the set contains all letters from 'a' to 'z'
        for (char c = 'a'; c <= 'z'; c++) {
            if (!alphabetSet.contains(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (String element : array) {
            if (element.equals(value)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        // Count occurrences of 'value' to determine new array size
        int count = 0;
        for (String str : array) {
            if (!str.equals(valueToRemove)) {
                count++;
            }
        }

        // Create new array excluding 'value'
        String[] newArray = new String[count];
        int index = 0;
        for (String str : array) {
            if (!str.equals(valueToRemove)) {
                newArray[index++] = str;
            }
        }
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        // Handle edge case of empty or single-element array
        if (array == null || array.length == 0) {
            return new String[0];
        }

        List<String> list = new ArrayList<>();
        list.add(array[0]); // Add the first element as it's always unique

        // Iterate through the array and add only non-consecutive duplicates
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(array[i - 1])) {
                list.add(array[i]);
            }
        }

        // Convert list to array
        return list.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        // Handle edge case of empty or single-element array
        if (array == null || array.length == 0) {
            return new String[0];
        }

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(array[0]);

        // Iterate through the array to concatenate consecutive duplicates
        for (int i = 1; i < array.length; i++) {
            if (array[i].equals(array[i - 1])) {
                sb.append(array[i]); // Concatenate current element to StringBuilder
            } else {
                list.add(sb.toString()); // Add concatenated string to list
                sb = new StringBuilder(array[i]); // Reset StringBuilder for new sequence
            }
        }

        // Add last concatenated sequence to the list
        list.add(sb.toString());

        // Convert list to array
        return list.toArray(new String[0]);
    }

}
