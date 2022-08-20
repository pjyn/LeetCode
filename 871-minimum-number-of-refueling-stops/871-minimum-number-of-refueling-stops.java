class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        int xCurrent = startFuel;
        int req = 0;
        
        // Max-Heap 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> (b-a));
        
        for(int[] station: stations){
            
            int nextStation = station[0];
            int fuelAtStation = station[1];
            
            while(xCurrent < nextStation){  // exhausted all fuel;
                if(!pq.isEmpty()){
                    int fuel = pq.poll();
                    xCurrent += fuel;
                    req++;
                }else{
                    return -1;
                }
            }
            pq.offer(fuelAtStation);
        }
        while(xCurrent < target){
            if(!pq.isEmpty()){
                int fuel = pq.poll();
                xCurrent += fuel;
                req++;
            }else{
                return -1;
            }
        }
        return req;
        // [10, 60], [20, 30], [30, 30], [60, 40]
        
        /*
    10      60(Y)        40(N)      10(Y)      30          
            90          70          40      -20
            
        */
        
//         int currFuel = startFuel;   // 10
//         int req = 0;
        
//         for(int i=0; i<stations.length-1; i++){
//             int far = stations[i][0];     // 10
//             int refuel = stations[i][1];      // 60
//             int nextFar = stations[i+1][0];
            
//             if(currFuel < far || target > currFuel+refuel){     // 1 < far
//                 return -1;   
//             }
            
//             if(target < far){
//                 return req;
//             }
            
//             target -= far;      // 90
                        
    
//             if(currFuel == far){
//                 req++;
//                 currFuel -= far;
//                 currFuel += refuel;
//             }
//             if(currFuel > nextFar){
//                 currFuel -= far;
//             }
            
            
//         }
//         return req;
//         for(int[] a: stations){
//             int far = a[0];     // 10
//             int fuel = a[1];        // 60
//             target -= far;      // 100 -= 10 => 90
//             if(target < far){
//                 return req;
//             }
            
            
//             if(currFuel < far && target > currFuel){
//                 return -1;
//             }else{
//                 if(currFuel == far){
//                     req++;      
//                     currFuel -= far;        // 10-10
//                     currFuel += fuel;       // 0+60
//                 }else{
//                     currFuel -= far;    
//                 }
//             }
                
//         }
//         return req;
    }
}