class Solution {
    public String reorganizeString(String s) {
     
        
        /*
            aabggteefc
            aga
            
            a-> 2
            b-> 1
            c-> 3
            r-> 2            
        */
        
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch: s.toCharArray()){
            
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b)-> hm.get(b)-hm.get(a));
        
        maxHeap.addAll(hm.keySet());
        
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1){
            char current = maxHeap.remove();
            char next = maxHeap.remove();
            
            sb.append(current);
            sb.append(next);
            hm.put(current, hm.get(current)-1);
            hm.put(next, hm.get(next)-1);
            
            if(hm.get(current) > 0){
                maxHeap.add(current);
            }
            if(hm.get(next) > 0){
                maxHeap.add(next);
            }
        }
        
        if(!maxHeap.isEmpty()){
            char last = maxHeap.remove();
            if(hm.get(last) > 1){
                return "";
            }
            sb.append(last);
        }
        return sb.toString();
    }
}