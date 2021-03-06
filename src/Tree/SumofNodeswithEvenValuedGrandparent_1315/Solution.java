package Tree.SumofNodeswithEvenValuedGrandparent_1315;

import Utils.TreeNode;

/**
 1315. Sum of Nodes with Even-Valued Grandparent

 Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
 If there are no nodes with an even-valued grandparent, return 0.

 Example 1:
 Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 Output: 18
 Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

 Constraints:
 The number of nodes in the tree is between 1 and 10^4.
 The value of nodes is between 1 and 100.
 */

public class Solution {
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        helper(root, -1, -1);

        return sum;
    }

    private void helper(TreeNode root, int parent, int grandparent)
    {
        if (root == null) return;

        if (grandparent != -1 && grandparent % 2 == 0) {
            sum += root.val;
        }

        helper(root.left, root.val, parent);
        helper(root.right, root.val, parent);
    }
}
