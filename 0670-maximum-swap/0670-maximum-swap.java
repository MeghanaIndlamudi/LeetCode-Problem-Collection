class Solution {
    public int maximumSwap(int num) {
        int originNum = num;
        
        // 0-based index from right to represent which index we are currently extracting
        int index = 0;
        
        // Keep track of max value to the right and its index 
        int rightMax = 0;
        int rightMaxIndex = 0;
        
        // variables we need to take a snapshot of when a candidate appears
        int candidate = 0;       // snapshot of current digit
        int candidateIndex = 0;  // snapshot of current index
        int max = 0;             // snapshot of current rightMax
        int maxIndex = 0;        // snapshot of current rightMaxIndex
        
        while (num > 0) {
            int digit = num % 10;
            if (digit > rightMax) {        // update max value to the right and its index 
                rightMax = digit;
                rightMaxIndex = index;
            } else if (digit < rightMax) { // found a candidate, take a snapshot of all needed variables
                candidate = digit;
                candidateIndex = index;
                max = rightMax;
                maxIndex = rightMaxIndex;
            }
            num /= 10;
            index++;
        }
        return originNum + (max - candidate) * (int)Math.pow(10, candidateIndex) - (max - candidate) * (int)Math.pow(10, maxIndex);
    }
}