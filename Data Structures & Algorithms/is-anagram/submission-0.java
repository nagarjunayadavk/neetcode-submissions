class Solution {
    public boolean isAnagram(String s, String t) {
         if(s.length() != t.length()){
            return false;
         }
         Map<Character, Integer> counterMap = new HashMap<>();
         for (char cha: s.toCharArray()){
            counterMap.put(cha, counterMap.getOrDefault(cha, 0)+1);
         }

         for (char c : t.toCharArray()) {
            if (!counterMap.containsKey(c)) {
                return false;
            }
            counterMap.put(c, counterMap.get(c) - 1);
            if (counterMap.get(c) == 0) {
                counterMap.remove(c);
            }
        }
        
        return counterMap.isEmpty();
    }
}
