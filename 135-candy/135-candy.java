class Solution {
    public int candy(int[] ratings) {
        
        int[] distribution = new int[ratings.length];
        // [1, 0, 2]
        
        Arrays.fill(distribution, 1);
        // [1, 1, 1]
        for(int i=0; i<ratings.length-1; i++){
            if(ratings[i] < ratings[i+1]){
                distribution[i+1] = distribution[i]+1;
            }
        }
        
        for(int i=ratings.length-1; i>0; i--){
            if(ratings[i] < ratings[i-1]){
                if(distribution[i-1] <= distribution[i]){
                    distribution[i-1] = distribution[i]+1;    
                }
            }
        }
        
        int totalCandies = 0;
        for(int i: distribution){
            totalCandies += i;
        }
        return totalCandies;
    }
}