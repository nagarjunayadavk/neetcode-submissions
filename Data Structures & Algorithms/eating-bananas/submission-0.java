class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Find maximum pile size for upper bound
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        // Binary search bounds: [1, maxPile]
        int left = 1;
        int right = maxPile;
        int firstTrueIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if speed 'mid' is feasible (can finish within h hours)
            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }

            if (totalHours <= h) {
                // Feasible: record answer and try smaller speed
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                // Not feasible: need faster speed
                left = mid + 1;
            }
        }

        return firstTrueIndex;
    }
}
