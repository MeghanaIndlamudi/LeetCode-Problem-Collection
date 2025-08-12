class Solution {
       public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            long power = 1;
            for (int j = 0; j < x; ++j) {
                power *= i;
            }
            for (int j = n; j >= power; --j) {
                dp[j] += dp[j - (int)power];
                dp[j] %= 1_000_000_007;
            }
        }
        return dp[n];
    }
}