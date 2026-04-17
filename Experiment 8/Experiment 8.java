class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1]; 
        for (int i = n - 1; i >= 0; i--) {
            int currMax = 0;
            for (int len = 1; len <= k && i + len <= n; len++) {
                currMax = Math.max(currMax, arr[i + len - 1]);
                dp[i] = Math.max(dp[i], currMax * len + dp[i + len]);
            }
        }
        return dp[0];
    }
}