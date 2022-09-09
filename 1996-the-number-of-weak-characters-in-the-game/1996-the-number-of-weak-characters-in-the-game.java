class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        Arrays.sort(properties, (a, b)-> b[0] == a[0] ? b[1]-a[1] : a[0] - b[0]);
        int ans = 0;
        int maxDefence = Integer.MIN_VALUE;
        
        for(int i=properties.length-1; i>=0; i--){
            if(properties[i][1] < maxDefence){
                ans++;
            }else{
                maxDefence = properties[i][1];
            }
        }
        return ans;
    }
}