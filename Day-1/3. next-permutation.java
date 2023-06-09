class Solution {
    public void nextPermutation(int[] nums) {
        int breakPointIndex = -1;
        // STEP-1
        for(int i = nums.length-2; i>=0; --i){
            if(nums[i] < nums[i+1]){
                breakPointIndex = i;
                System.out.println(breakPointIndex);
                break;
            }
        }
        // IF provided array is last permutation i.e max one 
        if(breakPointIndex == -1){
            for(int i=0; i < nums.length/2; ++i){
                swap(i, nums.length-1-i, nums);
            }
        }else{
            // STEP-2
            for(int i = nums.length-1; i >= breakPointIndex; --i){
                if(nums[i] > nums[breakPointIndex]){
                    swap(i,breakPointIndex,nums);
                    break;
                }
            }
            //STEP-3
            reverse(breakPointIndex+1, nums.length-1, nums);  
        }
    }
    public void swap(int l, int r, int[] nums){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    public void reverse(int l, int r, int[] nums){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
}
// TC: O(3N)
// SC: O(1)

/*
Intution:

Arr=====>>[2,1,5,4,3,0,0]
idx=====>>[0,1,2,3,4,5,6]

Next Permutation: [2,3,0,0,1,4,5]

Next Permutation: [2,3,0,0,1,5,4]

Next Permutation: [2,3,0,0,4,5,1]


Optimal Solution:
1. Find Break Point: Start from left, find the point where left element is less than right, index of left is break point.
2. Swap Break Point with Just Greater on right: Find the element just greater than element at break point, on right side of break point.
3. Reverse the element after break point: Reverse the right part and return the array.
*/ 
