class Solution {
    public int findMin(int[] nums) {
        // Basic without using sort
        Arrays.sort(nums);
        int min = nums[0];
        return min;
    }
}
