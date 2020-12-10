class Solution {
    public int numIslands(char[][] grid) {
        
        int count=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    helper(grid,i,j);
                }
            }
        }
        
        return count;
    }
    int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public void helper(char grid[][],int i, int j){
        
        if( i<0 || j<0  || i>=grid.length ||j>=grid[0].length|| grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            helper(grid,r,c);
        }
    }
}