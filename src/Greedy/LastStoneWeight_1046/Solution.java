package Greedy.LastStoneWeight_1046;

import java.util.TreeMap;

/**
 1046. Last Stone Weight

 We have a collection of rocks, each rock has a positive integer weight.
 Each turn, we choose the two heaviest rocks and smash them together.
 Suppose the stones have weights x and y with x <= y. The result of this smash is:
 If x == y, both stones are totally destroyed;
 If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

 Example 1:
 Input: [2,7,4,1,8,1]
 Output: 1
 Explanation:
 We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.


 Note:
 1 <= stones.length <= 30
 1 <= stones[i] <= 1000
 */

public class Solution {
    public int lastStoneWeight(int[] stones) {
        TreeMap<Integer, Integer> tree = new TreeMap();

        for (int i = 0; i < stones.length; i++) {
            tree.put(stones[i], tree.getOrDefault(stones[i], 0) + 1);
        }

        while (tree.size() > 1) {
            int key1 = tree.lastKey();

            int tmp1 = tree.get(key1);

            if (tmp1 % 2 == 0) {
                tree.remove(key1);
            } else {
                tree.remove(key1);

                int key2 = tree.lastKey();
                int tmp2 = tree.get(tree.lastKey());

                if (tmp2 > 1) {
                    tree.put(key2, tmp2 - 1);
                } else {
                    tree.remove(key2);
                }

                int key = Math.abs(key2 - key1);

                tree.put(key, tree.getOrDefault(key, 0) + 1);
            }
        }

        return tree.get(tree.firstKey()) % 2 == 0 ? 0 : tree.firstKey();
    }
}
