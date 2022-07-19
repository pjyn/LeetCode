class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();        // [[1],[1, 1]]
        
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(tmp);       // [[1]]
        
        for(int i=1; i<numRows; i++){
            List<Integer> prev = res.get(i-1);
            List<Integer> row = new ArrayList<>();       
            
            // List<Integer> fg = res.get(res.size()-1);
            // row.add(1);
            for(int j=1; j<i; j++){
                row.add(prev.get(j-1)+prev.get(j));
            }
            row.add(0, 1);
            row.add(1);
            res.add(row);
        }
        return res;
    }
}