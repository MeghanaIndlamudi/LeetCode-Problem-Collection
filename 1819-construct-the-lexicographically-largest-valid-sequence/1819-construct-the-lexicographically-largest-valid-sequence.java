public class Solution {
    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        int[] res = new int[size];
        boolean[] used = new boolean[n + 1];
        backtrack(res, used, 0, n);
        return res;
    }

    private boolean backtrack(int[] res, boolean[] used, int index, int n) {
        while (index < res.length && res[index] != 0) {
            index++;
        }
        if (index == res.length) {
            return true;
        }
        for (int num = n; num >= 1; num--) {
            int secondIndex = index + num;
            if (!used[num] && (num == 1 || (secondIndex < res.length && res[secondIndex] == 0))) {
                res[index] = num;
                if (num > 1) res[secondIndex] = num;
                used[num] = true;
                if (backtrack(res, used, index + 1, n)) {
                    return true;
                }
                res[index] = 0;
                if (num > 1) res[secondIndex] = 0;
                used[num] = false;
            }
        }
        return false;
    }
}