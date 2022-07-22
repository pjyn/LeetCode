class Solution {
    
    private class Point{
        private int x;
        private int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length - 1;
        if(grid[0][0] == 1 || grid[n][n] == 1){
            return -1;
        }
        int level = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Point head = q.poll();
                int x = head.x;
                int y = head.y;
                
                if(x == n && y == n){
                    return level+1;
                }
                if(x < 0 || y < 0 || x>n || y>n || grid[x][y] >= 1)
                    continue;
                
                grid[x][y] = 2;
                q.offer(new Point(x-1, y));
                q.offer(new Point(x+1, y));
                q.offer(new Point(x, y-1));
                q.offer(new Point(x, y+1));
                
                
                q.offer(new Point(x-1, y-1));
                q.offer(new Point(x-1, y+1));
                q.offer(new Point(x+1, y-1));
                q.offer(new Point(x+1, y+1));
            }
            level++;
        }
        return -1;
    }
}