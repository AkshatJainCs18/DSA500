package DSA500.Trees;
/*
1261. Find Elements in a Contaminated Binary Tree
Solved
Medium
Topics
Companies
Hint
Given a binary tree with the following rules:

root.val == 0
For any treeNode:
If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

Implement the FindElements class:

FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
bool find(int target) Returns true if the target value exists in the recovered binary tree.


Example 1:


Input
["FindElements","find","find"]
[[[-1,null,-1]],[1],[2]]
Output
[null,false,true]
Explanation
FindElements findElements = new FindElements([-1,null,-1]);
findElements.find(1); // return False
findElements.find(2); // return True
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *//*
class FindElements {
    private treeNode root;
    private HashSet<Integer> set;
    public void fixTree(treeNode root){
        set.add(root.val);
        if(root.left==null && root.right==null){
            return;
        }
        if(root.left!= null){
            root.left.val = root.val * 2 + 1;
            fixTree(root.left);
        }
        if(root.right!= null){
            root.right.val = root.val * 2 + 2;
            fixTree(root.right);
        }
    }
    public FindElements(treeNode root) {
        this.set = new HashSet<>();
        this.root = root;
        this.root.val = 0;
        fixTree(root);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */