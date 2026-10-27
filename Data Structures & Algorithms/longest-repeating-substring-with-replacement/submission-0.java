class Solution {
    public int characterReplacement(String s, int k) {
        int[] charFrequency = new int[26];

        int left = 0;
        int maxCount = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {
            int currentCharIndex = s.charAt(right) - 'A';
            charFrequency[currentCharIndex]++;
            maxCount = Math.max(maxCount, charFrequency[currentCharIndex]);
            
            int windowSize = right - left + 1;
            int charactersToReplace = windowSize - maxCount;
          
            if (charactersToReplace > k) {

                int leftCharIndex = s.charAt(left) - 'A';
                charFrequency[leftCharIndex]--;
                left++;
            }


        }

       return n - left;
    }
}
