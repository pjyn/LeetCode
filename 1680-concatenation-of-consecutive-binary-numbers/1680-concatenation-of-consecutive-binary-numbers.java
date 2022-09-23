class Solution {
    public int concatenatedBinary(int n) {
        
        // 168421
        // 1 1011
        int newNo = 0;
        int mod = 1000000007;
        
        for(int i=1; i<=n; i++){
            
            String binaryRep = Integer.toBinaryString(i);
            for(char c: binaryRep.toCharArray()){
                int val = (c == '0') ? 0 : 1;
                newNo = ((newNo*2)%mod + val)%mod; 
            }
        }
        return newNo;
    }
}