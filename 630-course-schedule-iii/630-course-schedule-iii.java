class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a, b)-> (a[1]-b[1]));
        
        int timeElapsed = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> (b-a));
        
        for(int[] course: courses){
            if(timeElapsed + course[0] <= course[1]){
                pq.offer(course[0]);
                timeElapsed += course[0];
            }else if(!pq.isEmpty() && pq.peek() > course[0]){
                timeElapsed -= pq.remove();
                pq.offer(course[0]);
                timeElapsed += course[0];
            }else{
                continue;
            }
        }
        return pq.size();
    }
}