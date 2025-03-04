class Solution{
public boolean checkPowersOfThree(int n) {
    // Calculate a high power of 3, here 3^16.
    int a = (int) Math.pow(3, 16);
    
    // Adjust 'a' to be the highest power of 3 less than or equal to 'n'
    while (n < a) {
        a = a / 3;
    }
    
    // Process the number by checking each base-3 digit.
    while (n != 0) {
        // If the digit in the current position is 2, return false.
        if (n / a == 2) {
            return false;
        }
        // Remove the contribution of the current power of 3.
        n = n % a;
        // Move to the next lower power of 3.
        a = a / 3;
    }
    return true;
}
}