class Solution {
    // public String encode(List<String> strs) {
    //     String finalStr = "";
    //     for (String str : strs) {
    //         finalStr += str + "#" + str.length();
    //     }
    //     return finalStr;
    // }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;

            while (s.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(s.substring(i, j));
            j++; // skip '#'

            res.add(s.substring(j, j + len));

            i = j + len;
        }

        return res;
    }

    // public List<String> decode(String str) {
    //     List<String> arr = new ArrayList<>();
    //     String[] list = str.split("#");

    //     for (String strl : list) {
    //         if (!strl.isEmpty()) {
    //             arr.add(strl.substring(0, strl.length() - 1));
    //         }
    //     }

    //     return arr;
    // }
}
