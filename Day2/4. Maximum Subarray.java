class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0, start = -1, startIndex = -1, endIndex = -1;
        for(int i = 0; i < nums.length; ++i){
            //In order to get the sub-array with max sum
            //everytime sum is set to 0, start point for max sub-array would change
            if(sum == 0)
                start = i;
            sum += nums[i];
            
            //given that sum is greater than maximum sum
            //when ever sum is set to 0, that will be considered as starting index 
            //i value in current iteration would be last index for max sum sub-array
            if(sum > maxSum){
                startIndex = start;
                endIndex = i;
            }
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) sum = 0;
        }
        System.out.print(startIndex +" "+ endIndex);
        return maxSum;
    }
}
// TC: O(N)
// SC: O(1)
