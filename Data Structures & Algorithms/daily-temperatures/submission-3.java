class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentIndex = n - 1; currentIndex >= 0; currentIndex--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[currentIndex]) {
                stack.pop();
            }

            // Calculate the difference in days
            if (!stack.isEmpty()) {
                res[currentIndex] = stack.peek() - currentIndex;
            }
            // If stack is empty, res[currentIndex] remains 0 (default value)

            // Push current index to stack for future comparisons
            stack.push(currentIndex);
        }
        return res;
    }
}
