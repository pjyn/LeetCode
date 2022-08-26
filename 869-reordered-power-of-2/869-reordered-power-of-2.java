class Solution {
    public boolean reorderedPowerOf2(int n) {
        
        int[] freqNumbers = freq(n);
        
        for(int i=0; i<31; i++){
            int tmp = (int)Math.pow(2, i);
            int[] arr = freq(tmp);
            if(isValid(arr, freqNumbers)){
                return true;
            }
        }
        return false;
    }
    private boolean isValid(int[] arr, int[] freqNumbers){
        for(int i=0; i<9; i++){
            if(arr[i] != freqNumbers[i]){
                return false;
            }
        }
        return true;
    }
    
    private int[] freq(int n){
        int[] count = new int[10];
        
        while(n > 0){
            count[n%10]++;
            n /= 10;
        }
        return count;
    }
}