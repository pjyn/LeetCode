class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs == null || strs.length == 0){
            return new ArrayList<>(new ArrayList<>());
        }
        
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(String s: strs){
            char[] t = s.toCharArray(); //k
            Arrays.sort(t);
            // eat  -> aet
            if(hm.containsKey(String.valueOf(t))){
                hm.get(String.valueOf(t)).add(s);
            }else{
                
                List<String> rt = new ArrayList<>();
                rt.add(s);
                hm.put(String.valueOf(t), rt);
            }
        }
        return new ArrayList<>(hm.values());
    }
}