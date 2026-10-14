class Solution {
     public class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    private int levels(TreeNode root){
        if(root==null) return 0;
        return 1+ Math.max(levels(root.left),levels(root.right));
    }
    private void BFS(TreeNode root,List<List<Integer>> ans){
      
    Queue<Pair> q = new ArrayDeque<>();
    if(root!=null) q.add(new Pair(root,0));
    while(q.size()>0){
        Pair front = q.remove();
        TreeNode temp = front.node;
        int lvl = front.level;
      
       ans.get(lvl).add(temp.val);
      
      
        if(temp.left!=null) q.add(new Pair(temp.left,lvl+1));
        if(temp.right!=null) q.add(new Pair(temp.right,lvl+1));
      
    }  
    for(int i=0;i<ans.size();i++){
        if(i%2!=0){
            Collections.reverse(ans.get(i));
        }
    }
    }
     
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i=0;i<=lvl-1;i++){
            List<Integer> arr = new ArrayList<>();
            ans.add(arr);
        }
        BFS(root,ans);
        return ans;
    }
}