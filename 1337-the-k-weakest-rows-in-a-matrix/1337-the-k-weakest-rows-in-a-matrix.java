class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
     
        /*
            0-> civilians
            1-> soldiers
            
            1=> left of 0 in each row
            
            i < j
            
            1-> no.of soldiers in row i is less than in j
            2-> both rows have same no. of soldiers & i < j.
        */
        List<Integer> soldiers = new ArrayList<>();
        int cnt;
        int[] res = new int[k];
        
        for(int[] a: mat){
            cnt = 0;
            for(int ele: a){
                if(ele == 1)
                    cnt++;
            }
            soldiers.add(cnt);
        }
        // [2, 4, 1, 2, 5]
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b)-> a[0] == b[0] ? a[1]-b[1]: a[0]-b[0]);
        
        /*
            2 -> 0
            4 -> 1
            1 -> 2
            2 -> 3
            5 -> 4
        */
        
        cnt = 0;
        for(int ele: soldiers){
            pq.add(new int[]{ele, cnt++});  // [2, 0], [4, 1], [1, 2], [2, 3]
        }
        
        
        // [1, 2], [2, 0], [2, 3], [4, 1], [5, 4]
        
        cnt = 0;

        while(k-- > 0){
            int[] tmp = pq.poll();
            res[cnt++] = tmp[1];
        }
        return res;
    }
}