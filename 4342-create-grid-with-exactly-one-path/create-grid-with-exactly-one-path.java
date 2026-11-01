class Solution {
    public String[] createGrid(int m, int n) {
        String[][] s = new String[m][n];
        for(int i=0;i<n;i++){
       s[0][i] = ".";
        }
        for(int i=0;i<m;i++){
            s[i][n-1] = ".";
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!".".equals(s[i][j])) s[i][j] = "#";
            }
        }
        String[] ans = new String[m];
        for(int i=0;i<m;i++){
       ans[i] = String.join("",s[i]);
        }
        return ans;
    }
}