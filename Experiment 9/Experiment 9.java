class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        lcs.reverse();
        StringBuilder result = new StringBuilder();
        i = 0;
        j = 0;
        for (char c : lcs.toString().toCharArray()) {
            while (str1.charAt(i) != c) {
                result.append(str1.charAt(i));
                i++;
            }
            while (str2.charAt(j) != c) {
                result.append(str2.charAt(j));
                j++;
            }
            result.append(c);
            i++;
            j++;
        }
        while (i < n) {
            result.append(str1.charAt(i++));
        }
        while (j < m) {
            result.append(str2.charAt(j++));
        }
        return result.toString();
    }
}