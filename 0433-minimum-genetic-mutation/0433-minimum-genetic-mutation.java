class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        char[] c = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int count = 0;
        q.add(startGene);
        visited.add(startGene);
        while(!q.isEmpty()){
            int size = q.size();
            while(size--> 0){
                String tmp = q.poll();
                if(tmp.equals(endGene)){
                    return count;
                }
                for(char ele: c){
                    for(int i=0; i<8; i++){
                        String tmpstring = tmp.substring(0, i) + ele + tmp.substring(i+1);
                        if(!visited.contains(tmpstring) && Arrays.asList(bank).contains(tmpstring)){
                            q.add(tmpstring);
                            visited.add(tmpstring);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}