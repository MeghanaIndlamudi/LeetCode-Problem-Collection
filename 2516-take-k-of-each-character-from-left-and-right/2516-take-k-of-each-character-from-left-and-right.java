class Solution {
    int k; // Required count of each character


    public int takeCharacters(String s, int k) {
        this.k = k; // Store `k` for use in validation
        int[] count = new int[3]; // Array to track counts of 'a', 'b', and 'c'

        // Calculate the total count of each character in the string
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++; // Increment count for the respective character
        }

        // Check if it's possible to have at least `k` occurrences of each character
        if (!valid(count)) return -1;

        // If we reach here, it is possible to satisfy the condition.
        // Use a sliding window approach to find the maximum length of an "invalid" substring.

        int begin = 0, end = 0; // Sliding window pointers
        int max = -1; // Maximum length of a valid window (i.e., invalid substring)

        while (end < s.length()) {
            // Expand the window by including the character at `end`
            char ch = s.charAt(end);
            count[ch - 'a']--; // Decrement the count of the character in the window

            // Shrink the window from the left until the window becomes valid again
            while (!valid(count) && begin <= end) {
                count[s.charAt(begin) - 'a']++; // Restore the count for the character being removed
                begin++; // Move the left pointer forward
            }

            // Update the maximum length of the valid window
            max = Math.max(max, end - begin + 1);
            end++; // Move the right pointer forward
        }

        // The result is the total length of the string minus the maximum valid window size
        return s.length() - max;
    }


    private boolean valid(int[] count) {
        for (int i : count) { // Check each character's count
            if (i < k) return false; // If any count is less than `k`, return false
        }
        return true; // All counts are valid
    }
}
