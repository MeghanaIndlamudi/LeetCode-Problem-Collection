class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long absSum = 0;       // Total sum of absolute values
        int negCount = 0;      // Count of negative numbers
        int absMin = Integer.MAX_VALUE; // Minimum absolute value in the matrix

        for (int[] row : matrix) {
            for (int num : row) {
                absSum += Math.abs(num);          // Add absolute value to total sum
                absMin = Math.min(absMin, Math.abs(num)); // Track the smallest absolute value
                if (num < 0) negCount++;          // Count negatives
            }
        }

        // If negative count is odd, subtract twice the smallest absolute value
        return (negCount % 2 == 1) ? absSum - 2L * absMin : absSum;
    }
}
