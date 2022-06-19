class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
     
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        
        TreeMap<String, Integer> tm = new TreeMap<>();
        
        List<String> productList = Arrays.asList(products);
            
        for(int i=0; i<products.length; i++){
            tm.put(products[i], i);
        }
        
        String s = "";
        for(char c: searchWord.toCharArray()){
            s += c;
            String ceiling = tm.ceilingKey(s);
            String floor = tm.floorKey(s + "{");
            
            if (ceiling == null || floor == null)
                break;
            
            ans.add(productList.subList(tm.get(ceiling), Math.min(tm.get(ceiling)+3, tm.get(floor)+1)));
        }
        while(ans.size() < searchWord.length())
            ans.add(new ArrayList<>());
        return ans;
                    
    }
}