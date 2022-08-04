class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length <= 1){
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b)-> (a[0]-b[0]));
        
        List<int[]> res = new ArrayList<>();
        
        int n = intervals.length;
        
        // [[1,3],[2,6],[8,10],[15,18]]
        
        int[] current = intervals[0];
        
        res.add(current);
        
        for(int i=0; i<n; i++){
            int curr_begin = current[0];
            int curr_end = current[1];
            int next_begin = intervals[i][0];
            int next_end = intervals[i][1];
            
            if(curr_end >= next_begin){
                current[1] = Math.max(curr_end, next_end);
            }else{
                current = intervals[i];
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}