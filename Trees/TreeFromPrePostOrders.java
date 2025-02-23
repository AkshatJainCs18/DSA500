/*
889. Construct Binary Tree from Preorder and Postorder Traversal
Solved
Medium
Topics
Companies
Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.
 */


package DSA500.Trees;

  class treeNode {
      int val;
      treeNode left;
      treeNode right;
      treeNode() {}
      treeNode(int val) { this.val = val; }
      treeNode(int val, treeNode left, treeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
 }

public class TreeFromPrePostOrders {
    private static int i;
    private static int j;
    public static void makeTree(treeNode root,int[] pre, int[] post){
        if(i == pre.length || j == post.length){
            return;
        }
        if(root.val == post[j]){
            j++;
            return;
        }
        treeNode node = new treeNode(pre[i++]);
        root.left = node;
        makeTree(root.left,pre,post);
        if(j!=post.length && root.val == post[j]){
            j++;
            return;
        }
        if(i<pre.length){
            treeNode newnode = new treeNode(pre[i++]);
            root.right = newnode;
            makeTree(root.right,pre,post);
            if(j!=post.length && root.val == post[j]){
                j++;
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        treeNode root = new treeNode(0);
        i = j = 0;
        root.val = pre[i++];
        if(pre.length>1)
            makeTree(root,pre,post);

    }
}
