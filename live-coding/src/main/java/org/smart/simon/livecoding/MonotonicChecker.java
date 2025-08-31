package org.smart.simon.livecoding;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.IntStream;

public class MonotonicChecker {
    public static boolean increaseOrDecrease(int[] arr) {
        boolean nonIncreasing = true;
        boolean nonDecreasing = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                nonIncreasing = false;
            }
            if (arr[i] <= arr[i - 1]) {
                nonDecreasing = false;
            }
        }

        return nonIncreasing || nonDecreasing;
    }


    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 3, 5, 6},     // true
                {6, 5, 4, 3, 2, 1},  // true
                {12, 12, 15, 17, 66},    // false
                {55, 6, 4, 7}   ,     // false
                {55, 6, 4, 4, 7}        // false
        };
        for (int[] arr : testCases) {
            System.out.println(increaseOrDecrease(arr));
        }
    }
}
