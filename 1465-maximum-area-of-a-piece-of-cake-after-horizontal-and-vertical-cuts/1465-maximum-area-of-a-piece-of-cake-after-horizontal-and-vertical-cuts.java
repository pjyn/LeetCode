class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        /*
            [1, 2, 4]
            [1, 3]
            
        */
        
        List<Integer> hc = new ArrayList<>();
        List<Integer> vc = new ArrayList<>();
        
        for(int i: horizontalCuts){
            hc.add(i);
        }
        hc.add(0);
        hc.add(h);
        
        for(int i: verticalCuts){
            vc.add(i);
        }
        vc.add(0);
        vc.add(w);
        
        Collections.sort(hc);
        Collections.sort(vc);
        long l = 0;
        long b = 0;
        
        for(int i=1; i<hc.size(); i++){
            
            l = Math.max(l, hc.get(i)-hc.get(i-1));
        }
        for(int i=1; i<vc.size(); i++){
            
            b = Math.max(b, vc.get(i)-vc.get(i-1));
        }
        
        return (int)((l*b)%(1000000007));
    }
}