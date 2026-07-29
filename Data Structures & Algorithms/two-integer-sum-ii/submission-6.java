class Solution {
    // public int[] twoSum(int[] numbers, int target) {
    //     int l = 0, r = numbers.length - 1;

    //     while (l < r) {
    //         int sum = numbers[l] + numbers[r];

    //         if (sum == target) {
    //             return new int[]{l + 1, r + 1};
    //         } else if (sum < target) {
    //             l++;
    //         } else {
    //             r--;
    //         }
    //     }

    //     return new int[]{};
    // }

    // public int[] twoSum(int[] numbers, int target) {

    //     List<Integer> indexes = new ArrayList<>();

    //     for ( int i=0; i < numbers.length; i++){
    //         Integer iTemp = numbers[i];
    //         for(int j =i + 1; j < numbers.length; j++){
    //             // iTemp =
    //             // System.out.println("----" + numbers[j]);
    //             Integer tempN = iTemp + numbers[j];
    //             if(tempN == target ){
    //                 indexes.add(i+1);
    //                 indexes.add(j+1);
    //                 break;
    //             }

    //             if(tempN > target){
    //                 break;
    //             }
    //         }
    //     }

    //     return indexes.stream().mapToInt(Integer::intValue).toArray();
    // }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        while (i < numbers.length) {
            int j = i + 1;
            while (j < numbers.length) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return new int[] {i + 1, j + 1};
                }
                if (sum > target) {
                    break;
                }
                j++;
            }
            i++;
        }

        return new int[] {};
    }
}
