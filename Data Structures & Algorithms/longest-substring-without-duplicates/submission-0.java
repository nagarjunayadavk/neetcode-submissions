class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charsCount = new int[128];

        int left = 0;
        int maxLen = 0;
        int stringLength = s.length();

        for (int right = 0; right < stringLength; right++) {

            char currentChar = s.charAt(right);
            charsCount[currentChar]++;
            // System.out.println(charsCount[currentChar]);
            while(charsCount[currentChar] > 1){
                // System.out.println("-- while loop");
                charsCount[s.charAt(left)]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left +1);
        }

        return maxLen;
    }
}