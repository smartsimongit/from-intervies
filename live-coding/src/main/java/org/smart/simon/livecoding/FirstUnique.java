package org.smart.simon.livecoding;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUnique {
    public static Integer findFirstUnique(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 0, 4, 1, 2};
        System.out.println(findFirstUnique(arr)); // 5
    }
}
