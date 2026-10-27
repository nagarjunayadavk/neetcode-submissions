class Solution {
    public int trap(int[] height) {
        int total = 0;
        int n = height.length;

        List<Integer> leftValues = new ArrayList<>(n);
        List<Integer> rightValues = new ArrayList<>(n);

        // Direct Fix: Pre-fill the lists with dummy values so .set() won't crash
        for (int i = 0; i < n; i++) {
            leftValues.add(0);
            rightValues.add(0);
        }

        leftValues.set(0, height[0]);
        rightValues.set(n - 1, height[n - 1]);

        for (int i = 1; i < n; i++) {
            // Left to Right: max of current height and the global peak seen so far to the left
            int cleftval = Math.max(leftValues.get(i - 1), height[i]);
            leftValues.set(i, cleftval);
            
            // Right to Left: max of current height and the global peak seen so far to the right
            int rleftval = Math.max(rightValues.get(n - i), height[n - i - 1]);
            rightValues.set(n - i - 1, rleftval);
        }

        // System.out.println(leftValues);
        // System.out.println(rightValues);

        for (int i = 0; i < n; i++) {
            //  System.out.println(leftValues.get(i));
            total += (Math.min(leftValues.get(i), rightValues.get(i)) - height[i]);
        }

        return total;
    }
}
