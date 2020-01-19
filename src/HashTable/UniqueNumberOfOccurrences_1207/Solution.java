package HashTable.UniqueNumberOfOccurrences_1207;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 1207. Unique Number of Occurrences

 Given an array of integers arr, write a function that returns true
   if and only if the number of occurrences of each value in the array is unique.

 Example 1:
 Input: arr = [1,2,2,1,1,3]
 Output: true
 Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

 Example 2:
 Input: arr = [1,2]
 Output: false

 Example 3:
 Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 Output: true

 Constraints:
 1 <= arr.length <= 1000
 -1000 <= arr[i] <= 1000
 */

public class Solution {
    public boolean uniqueOccurrences1(int[] arr) {
        Map<Integer, Integer> h = new HashMap<>();

        for(int entry: arr) {
            if (h.containsKey(entry)) {
                h.put(entry, h.get(entry) + 1);
            } else {
                h.put(entry, 1);
            }
        }

        Set<Integer> s = new HashSet<>();
        for (int entry: h.values()) {
            if (s.contains(entry)) {
                return false;
            }

            s.add(entry);
        }

        return true;
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer>map = new HashMap<>();

        for(int entry:arr) {
            map.put(entry, map.getOrDefault(entry,0)+1);
        }

        Set<Integer>set = new HashSet(map.values());
        return set.size() == map.size();
    }
}
