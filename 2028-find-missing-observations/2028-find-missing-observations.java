class Solution {
public int[] missingRolls(int[] rolls, int mean, int n) {
    mean *= (n + rolls.length);  // total desired sum of all rolls
    for (int r : rolls) mean -= r;  // subtract the sum of given rolls
    
    // Check if the remaining sum is valid
    if (mean < n || mean > n * 6) return new int[0];//no valid solution
    
    // Initialize result array with all 1's
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) ans[i] = 1;
    
    mean -= n;  // we already assigned 1 to each, so reduce mean by n
    
    // Distribute the remaining mean across the array
    int i = 0;
    while (mean > 0) {
        if (mean > 5) {
            ans[i] = 6;  // assign maximum value
            mean -= 5;   // reduce mean accordingly
        } else {
            ans[i] += mean;  // distribute remaining mean
            mean = 0;
        }
        i++;
    }
    return ans;
}
}