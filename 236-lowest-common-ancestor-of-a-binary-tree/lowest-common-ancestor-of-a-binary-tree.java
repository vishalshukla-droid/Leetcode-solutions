/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean exist(TreeNode root,TreeNode node){
 if(node==root) return true;
 if(root==null) return false;
 return exist(root.left,node) || exist(root.right,node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root||q==root)  return root;
        //does p lies in LST
        boolean pliesinLST = exist(root.left,p);
         boolean qliesinLST = exist(root.left,q);
        
         if(pliesinLST==true && qliesinLST==true) return lowestCommonAncestor(root.left,p,q);
         if(pliesinLST==false && qliesinLST==false) return lowestCommonAncestor(root.right,p,q);
         return root;
    }
}