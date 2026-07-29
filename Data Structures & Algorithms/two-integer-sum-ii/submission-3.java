class Solution {
    public int[] twoSum(int[] numbers, int target) {

        List<Integer> indexes = new ArrayList<>();
        
        for ( int i=0; i < numbers.length; i++){
            Integer iTemp = numbers[i]; 
            for(int j =i + 1; j < numbers.length; j++){
                // iTemp = 
                // System.out.println("----" + numbers[j]);
                Integer tempN = iTemp + numbers[j];
                if(tempN == target ){
                    indexes.add(i+1);
                    indexes.add(j+1);
                    break;
                }

                if(tempN > target){
                    break;
                }
            }
        }


        return indexes.stream().mapToInt(Integer::intValue).toArray();
    }
}
