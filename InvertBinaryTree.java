/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Solution for problem: https://leetcode.com/problems/invert-binary-tree/
 */
 
 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
    
        return root;
    }
}