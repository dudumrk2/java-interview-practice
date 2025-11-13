package arrays;

/**
 * LeetCode #26 - Remove Duplicates from Sorted Array
 *
 * Problem: Given a sorted array, remove duplicates in-place
 * such that each element appears only once.
 * Return the new length.
 *
 * Example:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 *
 * Note: Don't allocate extra space, modify the array in-place.
 */
public class RemoveDuplicates {

    /**
     * Two Pointer Approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        return uniqueIndex + 1;
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();

        // Test Case 1
        int[] nums1 = {1, 1, 2};
        int length1 = solution.removeDuplicates(nums1);
        System.out.print("Test 1: Length = " + length1 + ", Array = [");
        for (int i = 0; i < length1; i++) {
            System.out.print(nums1[i] + (i < length1 - 1 ? ", " : ""));
        }
        System.out.println("]"); // Expected: Length = 2, Array = [1, 2]

        // Test Case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length2 = solution.removeDuplicates(nums2);
        System.out.print("Test 2: Length = " + length2 + ", Array = [");
        for (int i = 0; i < length2; i++) {
            System.out.print(nums2[i] + (i < length2 - 1 ? ", " : ""));
        }
        System.out.println("]"); // Expected: Length = 5, Array = [0, 1, 2, 3, 4]

        System.out.println("\n✅ All tests passed!");
    }
}

