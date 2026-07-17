
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int i=0; i < nums.length; i++){
               if(seen.contains(nums[i])){
                 return true;
               }
               seen.add(nums[i]);
        }
        // for (int num : nums) {
        //     if (seen.contains(num)) {
        //         return true;
        //     }
        //     seen.add(num);
        // }

        return false;
    }
}