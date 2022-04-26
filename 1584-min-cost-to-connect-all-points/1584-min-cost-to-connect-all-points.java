class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> (a[2] - b[2]));
        
        int cost = 0;
        
        pq.offer(new int[]{0, 0, 0});
        
        Set<Integer> visited = new HashSet<>();
        
        int num = points.length;
        
        while(!pq.isEmpty() && visited.size() < num){
            int[] curr = pq.poll();
            int endId = curr[1];
            int currCost = curr[2];
            if(visited.contains(endId)){
               continue; 
            }
            cost += currCost;
            visited.add(endId);
            for(int i=0; i<num; i++){
                if(!visited.contains(i)){
                    pq.offer(new int[]{endId, i, distance(points, endId, i)});
                }
            }
        }
        return cost;
    }
    
    private int distance(int[][] points, int i, int j){
        return Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
    }
}