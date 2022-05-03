public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        
        System.out.println("Minimum is: "+min);
        
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        
        System.out.println("Maximum is: "+max);
        
        int l, r;
        
        // 4 < 6, l=1
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        // l=5
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}

/* 
            [2, 6, 4, 8, 10, 9, 15]  (j-i+1)
            [2, 4, 6, 8, 9, 10, 15]
*/