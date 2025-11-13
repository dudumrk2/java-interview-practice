package searching;

/**
 * LeetCode #704 - Binary Search
 *
 * Problem: Given a sorted array and a target value,
 * return the index if the target is found.
 * If not, return -1.
 *
 * Example:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 *
 * Note: You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {

    /**
     * Iterative Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    /**
     * Recursive Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) due to recursion stack
     */
    public int searchRecursive(int[] nums, int target) {
        return binarySearchHelper(nums, target, 0, nums.length - 1);
    }

    private int binarySearchHelper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearchHelper(nums, target, mid + 1, right);
        } else {
            return binarySearchHelper(nums, target, left, mid - 1);
        }
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();

        // Test Case 1
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("Test 1 (Iterative): Index of " + target1 + " = " +
                          solution.search(nums1, target1)); // Expected: 4

        // Test Case 2
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        System.out.println("Test 2 (Iterative): Index of " + target2 + " = " +
                          solution.search(nums2, target2)); // Expected: -1

        // Test Case 3 - Recursive
        int[] nums3 = {5};
        int target3 = 5;
        System.out.println("Test 3 (Recursive): Index of " + target3 + " = " +
                          solution.searchRecursive(nums3, target3)); // Expected: 0

        // Test Case 4 - Edge case
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target4 = 1;
        System.out.println("Test 4 (Iterative): Index of " + target4 + " = " +
                          solution.search(nums4, target4)); // Expected: 0

        System.out.println("\n✅ All tests passed!");
    }
}

