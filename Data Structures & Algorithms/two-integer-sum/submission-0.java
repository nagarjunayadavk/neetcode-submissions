class Solution {
    public int[] twoSum(int[] nums, int target) {
        // List<Integer> indices = new ArrayList<>();
        int[] indices = new int[2];

        for(int i=0; i < nums.length; i++){
            for (int j= i+1; j < nums.length; j++){
                int finalInt = nums[i]+nums[j];
                if(finalInt == target){
                    indices[0] =i;
                    indices[1] = j;
                    break;
                }
            }
        }
        return indices;
        
    }
}
