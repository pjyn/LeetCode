class Solution {
    public String getPermutation(int n, int k) {
        
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<n; i++){         
            fact = fact * i;                // "" + 1 *2 *3 = > "6"
            numbers.add(i);     // [1, 2, 3]
        }
        numbers.add(n);     // [1, 2, 3, 4];
        
        String ans = "";
        k = k - 1;  // k = 16
        while(true){
            ans = ans + numbers.get(k / fact);      // "" + 3 
            numbers.remove(k / fact);       // remove 16/6 -> [1, 2 4]
            if(numbers.size() == 0){
                break;
            }
            k = k % fact;       // 16 % 6 => 4
            fact = fact / numbers.size();       // 
        }
        return ans;
    }
}