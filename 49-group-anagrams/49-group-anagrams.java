class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs == null || strs.length == 0)
            return new ArrayList<>();
        
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(String s: strs){
            // eat     
            char[] a = s.toCharArray(); //['e', 'a', t]
            Arrays.sort(a); // ['a', 'e', 't']
            String pl = String.valueOf(a);  // aet
            
            if(!hm.containsKey(pl)){
                List<String> t = new ArrayList<>();
                t.add(s);
                hm.put(pl, t);
            }else{
                hm.get(pl).add(s);
            }
        }
        
        return new ArrayList<>(hm.values());
        
        /*
            'aet'-> [eat, tea, ate]
        */
    }
}