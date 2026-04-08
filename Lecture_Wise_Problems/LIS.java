public class LIS { 
    public static int longestIncreasingSubsequence(int[] arr) { 
        int n = arr.length; 
        int[] dp = new int[n]; 
        for (int i = 0; i < n; i++) { 
            dp[i] = 1; 
            for (int j = 0; j < i; j++) { 
                if (arr[i] > arr[j]) { 
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                } 
            } 
        } 
        int maxLength = 0; 
        for (int length : dp) { 
            maxLength = Math.max(maxLength, length); 
        } 
        return maxLength; 
    } 
    public static void main(String[] args) { 
        int[] arr = {10, 20, 10, 30, 20, 50}; 
        System.out.println("Length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr)); 
    } 
}