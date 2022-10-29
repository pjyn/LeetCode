class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        //  plantTime = [1,4,3], growTime = [2,3,1]
        
        /*
        -> go with the one having maximum growTime
        3 -> 4 
        2 -> 1
        1 -> 3
        */
        
        List<Seed> plant = new ArrayList<>();
        for(int i=0; i<plantTime.length; i++){
            plant.add(new Seed(plantTime[i], growTime[i]));     //brownie points oops concept   [1, 2], [4, 3], [3, 1]
        }
        
        Collections.sort(plant, (a,b) -> (b.growTime - a.growTime));        // Collections.sort(plant, (a,b) -> ())
        
        int time = 0;
        int max = 0;
        
        for(int i=0; i<plantTime.length; i++){
            time += plant.get(i).plantTime;
            max = Math.max(max, time+plant.get(i).growTime);
        }
        return max;
    }
    private class Seed{
        int plantTime;
        int growTime;
            
        public Seed(int p, int g){
            this.plantTime = p;
            this.growTime = g;
        }
    }
}