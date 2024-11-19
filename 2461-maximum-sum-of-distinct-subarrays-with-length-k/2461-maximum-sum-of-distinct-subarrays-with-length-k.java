class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
		int i = 0, j = 0;
		long sum = 0;
		long maxSum = 0;

		while (j < arr.length) {
			map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);          // add it to map
			sum += arr[j];                                             // add to local sum
			if (j - i + 1 == k) {                                      // if window length == K
				if (map.size() == k) {                                 // if size of map is k, that means there are k unique elements
					maxSum = Math.max(maxSum, sum);                    // take the max sum
				}
				sum -= arr[i];                                         // remove calculation of arr[i]
				map.put(arr[i], map.get(arr[i])-1);                    // remove arr[i] from map. If arr[i] is duplicate in window, decrease the freq by 1
				if (map.get(arr[i]) == 0) map.remove(arr[i]);
				i++;                                                   // shift the window to the right
			}
			j++;                                                       // expand the window
		}

		return maxSum;
    }
}