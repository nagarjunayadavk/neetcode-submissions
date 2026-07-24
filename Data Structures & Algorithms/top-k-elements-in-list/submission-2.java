class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Set<Integer> finalNums = new HashSet<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            // if(countMap.get(num))
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            // if(countMap.get(num) >= k){
            //   finalNums.add(num);
            // }
        }
        // return finalNums.stream().mapToInt(Integer::intValue).toArray();

        return countMap.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
            .limit(k)
            .map(Map.Entry::getKey)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
