class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> (b-a));
        
        long totalSum = 0l;
        for(int i: target){
            totalSum += i;
            pq.offer(i);
        }
        
        while(!pq.isEmpty()){
            int maxEle = pq.poll();     // 9
            
            long remainingSum = totalSum - maxEle;      // 17-9 => 8
            
            if(remainingSum == 1 || maxEle == 1){
                return true;
            }
            
            if(remainingSum == 0 || maxEle < remainingSum){
                return false;
            }
            
            if(maxEle%remainingSum == 0){
                return false;
            }
            int numberToBeAdded = (int)(maxEle % remainingSum); // 9 % 8 = 1
            pq.offer(numberToBeAdded);
            totalSum = remainingSum + numberToBeAdded;
        }
        return true;
    }
}