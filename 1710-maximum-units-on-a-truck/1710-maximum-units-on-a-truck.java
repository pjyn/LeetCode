class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        /*
            boxTypes[i] = [number of Boxes, numberOfUnitsPerBox]
            
            trucksize
            
            maximum no of boxes that can be put on truck
            
            5*10 + 2*7 + 3*9 => 50+28+9 = 87
            
            [5,10], [4, 7], [3, 9], [2, 5] 
            
            2, 2, 1, 3
            3*9 + 2*5 + 5*10 => 27+10+50 => 87
        */
        
        Arrays.sort(boxTypes, (a, b)-> b[1]-a[1]);
        
        // 
        int boxCnt = 0;
        
        for(int[] box: boxTypes){
            int noOfBoxes = box[0];
            int noOfUnits = box[1];
            
            if(truckSize >= box[0]){
                boxCnt += noOfBoxes * noOfUnits;
                truckSize -= noOfBoxes;
            }else{
                boxCnt += (truckSize*noOfUnits);
                return boxCnt;
            }
        }
        return boxCnt;
    }
}