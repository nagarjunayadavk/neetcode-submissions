class Solution {

    public List<List<String>> loop(List<String> strArr, String str) {

        List<List<String>> finalArr = new ArrayList<>();

        for (int i = 1; i < strArr.size(); i++) {

            if (str.length() == strArr.get(i).length()) {

                Map<Character, Integer> countMap = new HashMap<>();

                // FIX 1: Add all characters to map
                for (char c : str.toCharArray()) {
                    countMap.put(c, countMap.getOrDefault(c, 0) + 1);
                }

                boolean isAnagram = true;

                for (char c : strArr.get(i).toCharArray()) {

                    if (!countMap.containsKey(c)) {
                        isAnagram = false;
                        break;
                    }

                    countMap.put(c, countMap.get(c) - 1);

                    if (countMap.get(c) == 0) {
                        countMap.remove(c);
                    }
                }

                if (isAnagram && countMap.isEmpty()) {
                    List<String> arr = new ArrayList<>();
                    arr.add(strArr.get(i));
                    finalArr.add(arr);
                }
            }
        }

        return finalArr;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> finalList = new ArrayList<>();
        List<String> tempStrs = new ArrayList<>(Arrays.asList(strs));

        while (!tempStrs.isEmpty()) {

            String first = tempStrs.get(0);

            List<String> group = new ArrayList<>();
            group.add(first);

            List<List<String>> tempList = loop(tempStrs, first);

            for (List<String> l : tempList) {
                group.addAll(l);
            }

            finalList.add(group);

            // remove grouped strings
            tempStrs.removeAll(group);
        }

        return finalList;
    }
}