package DSA500.Trees;

/*

Code


Testcase
Testcase
Test Result
1028. Recover a Tree From Preorder Traversal
Solved
Hard
Topics
Companies
Hint
We run a preorder depth-first search (DFS) on the root of a binary tree.

At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.

If a node has only one child, that child is guaranteed to be the left child.

Given the output traversal of this traversal, recover the tree and return its root.
Input: traversal = "1-2--3---4-5--6---7"
Output: [1,2,5,3,null,6,null,4,null,7]

Solution:
Reset number of dashes before every function call. In every call increase dashes till it becomes equal to depth.

 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
  }
public class RecoverTreeFromPreorder {
    private static int idx;
    private static int dash;
    public static void makeTree(TreeNode root,String s,int depth){
        if(idx==s.length())
            return;
        while(s.charAt(idx)=='-'){
            dash++;
            idx++;
        }
        if(dash==depth){
            int sum = 0;
            while(idx<s.length() && s.charAt(idx)!='-'){
                int num = s.charAt(idx)-48;
                sum = sum*10 + num;
                idx++;
            }
            dash = 0;
            TreeNode curr = new TreeNode(sum);
            if(root.val == 0){
                root.val = curr.val;
            }
            else if(root.left == null){
                root.left = curr;
                root = root.left;
            }
            else {
                root.right = curr;
                root = root.right;
            }
            makeTree(root,s,depth+1);
            makeTree(root,s,depth+1);
        }
    }
    public static TreeNode recoverFromPreorder(String traversal) {
        TreeNode root = new TreeNode(0);
        root.left = null;
        root.right = null;
        idx = 0;
        dash = 0;
        makeTree(root,traversal,0);
        return root;
    }
    public static void main(String[] args) {
        String traversal = "1-2--3--4-5--6--7";
        recoverFromPreorder(traversal);
    }
}
