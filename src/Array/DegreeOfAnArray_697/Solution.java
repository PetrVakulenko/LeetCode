package Array.DegreeOfAnArray_697;

import java.util.HashMap;

/**
 697. Degree of an Array

 Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum
   frequency of any one of its elements. Your task is to find the smallest possible length of a (contiguous)
   subarray of nums, that has the same degree as nums.

 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.

 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6

 Note:
 nums.length will be between 1 and 50,000.
 nums[i] will be an integer between 0 and 49,999.
 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap();
        HashMap<Integer, Integer> right = new HashMap();
        HashMap<Integer, Integer> countMap = new HashMap();

        int maxDegree = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];

            if (left.get(tmp) == null) left.put(tmp, i);

            right.put(tmp, i);

            countMap.put(tmp, countMap.getOrDefault(tmp, 0) + 1);

            maxDegree = Math.max(countMap.get(tmp), maxDegree);
        }

        int diff = Integer.MAX_VALUE;
        for (int key: countMap.keySet()) {
            if (countMap.get(key) != maxDegree) continue;

            diff = Math.min(right.get(key) - left.get(key) + 1, diff);
        }

        return diff;
    }
}