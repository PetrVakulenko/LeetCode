package Tree.SymmetricTree_101;

import Utils.TreeNode;

/**
 101. Symmetric Tree

 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

     1
    / \
   2   2
  / \ / \
 3  4 4  3

 But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
  \   \
  3    3

 Follow up: Solve it both recursively and iteratively.
 */

public class Solution {
    private boolean check(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return check(left.left,right.right) && check(right.left,left.right);

    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return check(root.left,root.right);
    }
}
