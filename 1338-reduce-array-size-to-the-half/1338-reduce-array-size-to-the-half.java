class Solution {
    public int minSetSize(int[] arr) {
        
        int n = arr.length;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int ele: arr){
            hm.put(ele, hm.getOrDefault(ele, 0)+1);
        }
        
        /*
            3-> 4
            5-> 3
            2-> 2
            7-> 1
            
            [4, 3, 2, 1]
            
            totalEl = 10
            i=0
            totalEl = totalEl - 4
            c = 1
            
            totalEl = 6
            i=1
            totalEl = totalEl - 3
            c = 2
            
            
        */
        List<Integer> freqs = new ArrayList<>(hm.values());
        Collections.sort(freqs, Collections.reverseOrder());
        int totalEl = n;
        int i=0;
        int cnt = 0;
        
        while(totalEl > n/2){
            totalEl -= freqs.get(i);        // 10 - 4
            i++;
            cnt++;
        }
        return cnt;
    }
}