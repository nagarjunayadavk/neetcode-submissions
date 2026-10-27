class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;

                } else if (sum > 0) { //
                    right--;
                } else {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // skip duplicates

                    // if used while it will skip only 1
                    //  while - Changed 'if' to 'while' to skip ALL consecutive duplicates
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // while - Adjusted index comparison to look at the previously processed element
                    //Compare right with right + 1 (the element it just moved away from)
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
