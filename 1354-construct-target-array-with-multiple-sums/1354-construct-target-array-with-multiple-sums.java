class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> (b-a));
        
        long totalSum = 0l;
        for(int i: target){
            pq.offer(i);
            totalSum += i;
        }
        // totalSum = 17
        // [9, 5, 3]
        
        while(!pq.isEmpty()){
            int maxEle = pq.poll();     // [1, 3, 5] -> 5
            
            long remainingSum = totalSum - maxEle;       // 17 - 9 => 8      ; 9-5 => 4
            
            if(maxEle == 1 || remainingSum == 1){
                return true;
            }
            
            if(remainingSum == 0 || maxEle < remainingSum ){
                return false;
            }
            
            int newNumberToBeAdded = (int)(maxEle % remainingSum);
                
            if(newNumberToBeAdded == 0)
                return false;
            
            totalSum = remainingSum + newNumberToBeAdded;
            pq.offer(newNumberToBeAdded);
        }
        return true;
    }
}