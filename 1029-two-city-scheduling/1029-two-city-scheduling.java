class Solution {
    
    // TC:- O(nlogn)
    // SC:- O(1)
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (a, b)-> (a[0]-a[1]) - (b[0]-b[1]));
        int n = costs.length/2;
        
        int sum = 0;
        int tmp;
        
        for(int i=0; i<costs.length; i++){
            if(i < n){
                sum += costs[i][0];
            }else{
                sum += costs[i][1];
            }
        }
        return sum;        
    }
}