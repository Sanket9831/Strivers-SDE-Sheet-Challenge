class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(low,mid,nums);
                low++; 
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else if(nums[mid] == 2){
                swap(mid,high,nums);
                high--;
            }
        }
    }
    public void swap(int l, int r, int[] nums){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
/*
DNF Alogroitm - Dutch National flag algorithm. 

nums[0...low-1] = 0 ==>> Extreme left portion
nums[low...mid-1] = 1 >> Mid Portion
nums[mid to high] ====>> Unsorted Area
nums[high+1...n-1] = 2>> Extreme right portion

TC: O(N)
SC: O(1)

*/ 
