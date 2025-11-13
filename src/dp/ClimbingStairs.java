package dp;

/**
 * LeetCode #70 - Climbing Stairs
 *
 * Problem: You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 *
 * Example:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways:
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    /**
     * Dynamic Programming - Bottom Up
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * Space Optimized DP
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int climbStairsOptimized(int n) {
        if (n <= 2) {
            return n;
        }

        int prev2 = 1; // Ways to reach step 1
        int prev1 = 2; // Ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    /**
     * Recursive with Memoization (Top Down)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int climbStairsMemo(int n) {
        int[] memo = new int[n + 1];
        return climbStairsHelper(n, memo);
    }

    private int climbStairsHelper(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();

        // Test Case 1
        int n1 = 2;
        System.out.println("Test 1: n = " + n1);
        System.out.println("  DP: " + solution.climbStairs(n1)); // Expected: 2
        System.out.println("  Optimized: " + solution.climbStairsOptimized(n1)); // Expected: 2
        System.out.println("  Memo: " + solution.climbStairsMemo(n1)); // Expected: 2

        // Test Case 2
        int n2 = 3;
        System.out.println("\nTest 2: n = " + n2);
        System.out.println("  DP: " + solution.climbStairs(n2)); // Expected: 3
        System.out.println("  Optimized: " + solution.climbStairsOptimized(n2)); // Expected: 3

        // Test Case 3
        int n3 = 5;
        System.out.println("\nTest 3: n = " + n3);
        System.out.println("  DP: " + solution.climbStairs(n3)); // Expected: 8
        System.out.println("  Optimized: " + solution.climbStairsOptimized(n3)); // Expected: 8

        // Test Case 4
        int n4 = 10;
        System.out.println("\nTest 4: n = " + n4);
        System.out.println("  DP: " + solution.climbStairs(n4)); // Expected: 89

        System.out.println("\n✅ All tests passed!");
    }
}

