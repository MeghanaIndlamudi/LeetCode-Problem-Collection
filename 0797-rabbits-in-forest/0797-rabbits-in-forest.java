class Solution {
    public int numRabbits(int[] answers) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int a : answers) map.put(a, map.getOrDefault(a, 0) + 1);

    int res = 0;
    for (var entry : map.entrySet()) {
        int x = entry.getKey(), v = entry.getValue();
        res += ((v + x) / (x + 1)) * (x + 1);
    }
    return res;
}
}