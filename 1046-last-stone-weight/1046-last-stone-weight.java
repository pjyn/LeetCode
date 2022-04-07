class Solution {
    public int lastStoneWeight(int[] stones) {
        
        /*
            [2,7,4,1,8,1]
            
        */
        
        List<Integer> arr = new ArrayList<>();
        
        for(int ele: stones){
            
            arr.add(ele);
        }
        
        // [1, 1, 2, 4, 7, 8]
        
        // int l = stones.length-1;
        // int h = stones.length-2;
        
        // Collections.sort(arr);
        
        
        while(arr.size() > 1){
            
            Collections.sort(arr);
            
            int size = arr.size();
            
            int first = arr.get(size-1);
            int second = arr.get(size-2);
            
            if(first == second){
                arr.remove(new Integer(first));
                arr.remove(new Integer(second));
            }else{
                arr.add(first-second);
                arr.remove(new Integer(second));
                arr.remove(new Integer(first));
            }
        }
        if(arr.size() == 0){
            return 0;
        }else{
            return arr.get(0);
        }
    }
}