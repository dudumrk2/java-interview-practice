package strings;

/**
 * LeetCode #125 - Valid Palindrome
 *
 * Problem: Determine if a string is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 *
 * Example:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {

    /**
     * Two Pointer Approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Alternative: Clean String First
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isPalindromeClean(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        // Test Case 1
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Test 1: \"" + s1 + "\" -> " + solution.isPalindrome(s1));
        // Expected: true

        // Test Case 2
        String s2 = "race a car";
        System.out.println("Test 2: \"" + s2 + "\" -> " + solution.isPalindrome(s2));
        // Expected: false

        // Test Case 3
        String s3 = " ";
        System.out.println("Test 3: \"" + s3 + "\" -> " + solution.isPalindrome(s3));
        // Expected: true

        // Test Case 4
        String s4 = "0P";
        System.out.println("Test 4: \"" + s4 + "\" -> " + solution.isPalindrome(s4));
        // Expected: false

        System.out.println("\n✅ All tests passed!");
    }
}

