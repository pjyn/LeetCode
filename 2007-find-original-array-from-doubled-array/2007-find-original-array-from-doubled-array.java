class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        
        // [1, 3, 4, 2, 6, 8]
        
        // [6, 3, 0, 1]    
        
//         Arrays.sort(changed);
//         // [1, 2, 3, 4, 6, 8]
//         List<Integer> clone = new ArrayList<>();
//         for(int i: changed){
//             clone.add(i);
//         }
//         // [1, 2, 3, 4, 6, 8]
        
            
//         Set<Integer> hs = new HashSet<>();
        
//         int[] ans = new int[changed.length/2];
//         int cnt = 0;
        
//         for(int ele: changed){
//             if( clone.contains(ele*2)){     //
//                 if(cnt == changed.length/2){
//                     return new int[0];
//                 }
//                 ans[cnt++] = ele;
//             }
//         }
//         return ans;
        int n = changed.length, i = 0;
        if (n % 2 == 1) 
            return new int[0];
        int[] res = new int[n / 2];
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : changed)
            count.put(a, count.getOrDefault(a, 0) + 1);
        for (int x : count.keySet()) {
            if (count.get(x) > count.getOrDefault(x + x, 0))
                return new int[0];
            for (int j = 0; j < count.get(x); ++j) {
                res[i++] = x;
                count.put(x + x, count.get(x + x) - 1);
            }
        }
        return res;
    }
}