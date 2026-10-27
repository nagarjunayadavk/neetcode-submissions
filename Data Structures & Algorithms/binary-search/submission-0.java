class Solution {
    public int search(int[] nums, int target) {
         
         for(int n =0; n < nums.length; n++){
            if ( nums[n] == target){
                return n;
            }
         }

        return -1;
    }
}
