class Solution {
    public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(nums, result, new ArrayList<>(), (1 << nums.length) - 1);
    return result;
}

private void dfs(int[] nums, List<List<Integer>> result, List<Integer> list, int visited) {
    if(visited == 0) {
        result.add(new ArrayList<>(list));
        return;
    }
    for(int i = 0; i < nums.length; i++) {
        int c = 1 << i;
        if((c & visited) > 0) {
            list.add(nums[i]);
            dfs(nums, result, list, visited ^ c);
            list.remove(list.size() - 1);
        }
    }
}
}