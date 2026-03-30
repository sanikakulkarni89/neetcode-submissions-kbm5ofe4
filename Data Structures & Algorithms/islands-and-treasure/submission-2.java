class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < rows ; r++){
            for(int c = 0; c < cols; c++){
               if(grid[r][c]==0){
                    q.add(new int[] {r, c});
               }                                                   
            }
        }

        if(q.size()==0){
            return;
        }

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];

                if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c]!= Integer.MAX_VALUE){
                    continue;
                }

                q.add(new int[] {r,c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
