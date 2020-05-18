package BinarySearch.Heaters_475;

import java.util.Arrays;

/**
 475. Heaters

 Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 Now, you are given positions of houses and heaters on a horizontal line,
   find out minimum radius of heaters so that all houses could be covered by those heaters.
 So, your input will be the positions of houses and heaters seperately,
   and your expected output will be the minimum radius standard of heaters.

 Note:
 Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 As long as a house is in the heaters' warm radius range, it can be warmed.
 All the heaters follow your radius standard and the warm radius will the same.

 Example 1:
 Input: [1,2,3],[2]
 Output: 1
 Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.

 Example 2:
 Input: [1,2,3,4],[1,4]
 Output: 1
 Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int max = 0;
        for(int i=0; i<houses.length; ++i){
            if(houses[i] <= heaters[0]) {
                max = max < (heaters[0] - houses[i])? (heaters[0] - houses[i]): max;
            } else if(houses[i] >= heaters[heaters.length-1]) {
                max = max < (houses[i] - heaters[heaters.length-1])? (houses[i] - heaters[heaters.length-1]): max;
            } else {
                int cur = helper(heaters, houses[i]);
                max = max < cur? cur: max;
            }
        }
        return max;
    }

    private int helper(int[] heaters, int house){
        int lo = 0, hi = heaters.length-1;
        while(lo <= hi){
            int mid = lo + ((hi - lo) >> 1);
            if(house == heaters[mid]) return 0;
            else if(house > heaters[mid] && house < heaters[mid + 1]){
                return (heaters[mid + 1] - house) < (house - heaters[mid])? (heaters[mid + 1] - house): (house - heaters[mid]);
            }
            else if(house < heaters[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
}