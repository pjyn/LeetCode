class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        /*
            power = 50
            score = 0       -> maximize
            
            (power >= tokens[i]) -> power -= tokens[i] & score += 1;
            
            (score >= 1)         -> power += tokens[i] & score -= 1;
            
            power = 50, score = 1
            power = 250, score = 0
            
            ++++++++++++++++
            power = 100, score=1
            if(power+tokens[i] >= power){
                score--;
                power++;
            }
        */
        Arrays.sort(tokens);
        
        int score = 0;
        int maxScore = 0;
        int i = 0; 
        int j = tokens.length-1;
        while(i <= j){
            
            if(power >= tokens[i]){
                power -= tokens[i++];
                score += 1;
                maxScore = Math.max(maxScore, score);
            }
            //&& (power+tokens[i] >= power)
            else if(score >= 1){
                power += tokens[j--];
                score -= 1;
            }else{
                return maxScore;
            }
        }
        
        return maxScore;
    }
}