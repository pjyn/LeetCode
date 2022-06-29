public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        // don't know
        
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        
//         for(int[] a: people){
            
//             System.out.println(a[0]+" "+a[1]);    
//         }
        
        
        for (int[] p : people) {
            list.add(p[1], p);      // (index, element)
        }
        return list.toArray(new int[list.size()][]);
    }
}