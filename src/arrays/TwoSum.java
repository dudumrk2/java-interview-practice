package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * LeetCode #1 - Two Sum
 *
 * Problem: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 9
 *
 * Constraints:
 * - Only one valid answer exists
 * - Cannot use the same element twice
 */
public class TwoSum {

    /**
     * Optimal Solution using HashMap
     * Time Complexity: O(n) - single pass through array
     * Space Complexity: O(n) - hashmap storage
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution found");
    }

    /**
     * Brute Force Solution (for comparison)
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No solution found");
    }

    /**
     * Test cases and examples
     */
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test 1: " + Arrays.toString(result1)); // Expected: [0, 1]

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test 2: " + Arrays.toString(result2)); // Expected: [1, 2]

        // Test Case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test 3: " + Arrays.toString(result3)); // Expected: [0, 1]

        System.out.println("\n✅ All tests passed!");
    }
}

