class Solution {
    public int longestConsecutive(int[] nums) {
        // List<Integer> arr = new ArrayList<>();

        if(nums.length == 0){
           return 0;
        }


        Set<Integer> unique= new HashSet<>();

        for(int num: nums){
            unique.add(num);
        }
       Set<Integer> sortedSet =  new TreeSet<>(unique);
       List<Integer> list = new ArrayList<>(sortedSet);
        System.out.println(list);
    //     int longest = 1;

    //    for(int i=1; i< list.size(); i++){
    //         if((list.get(i-1) + 1) == list.get(i)){
    //             longest++;
    //         } 
    //    }

    int longest = 1;
    int current = 1;

    for (int i = 1; i < list.size(); i++) {
        if (list.get(i) == list.get(i - 1) + 1) {
            current++;
        } else {
            longest = Math.max(longest, current);
            current = 1;
        }
    }

    longest = Math.max(longest, current);
        
      return longest;
    }
}
