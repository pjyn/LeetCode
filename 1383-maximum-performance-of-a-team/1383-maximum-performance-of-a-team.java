class Solution {
    
    private class Engineer{
        private int speed;
        private int efficiency;
        
        public Engineer(int speed, int efficiency){
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        /*
            performance = speed 
            
            10+5 * 4 => 60
            
            0, 2, 1, 0, 0, 4
            
            [2, 10, 3, 1, 5, 8]
            [5,  4, 3, 9, 7, 2]
        */
        List<Engineer> engineers = new ArrayList<>();
        for(int i=0; i<n; i++){
            
            engineers.add(new Engineer(speed[i], efficiency[i]));
        }
        
        engineers.sort((a, b)-> b.efficiency - a.efficiency);
        
        PriorityQueue<Engineer> currentTeam = new PriorityQueue<>((a, b)-> a.speed - b.speed);
        
        long teamSpeed = 0;
        long maxPerformance = 0;
        
        for(Engineer newHire : engineers){
            
            if(currentTeam.size() == k){
                Engineer slowGuy = currentTeam.poll();
                
                teamSpeed -= slowGuy.speed;
            }
            currentTeam.add(newHire);
            
            teamSpeed += newHire.speed;
            
            long performanceWithNewGuy = teamSpeed * (long) newHire.efficiency;
            maxPerformance = Math.max(maxPerformance, performanceWithNewGuy);
        }
        return (int)(maxPerformance % 1000000007);
    }
}