class Solution {

    public int maxTwoEvents(int[][] events) {
        if(events == null || events.length < 1) {
            return 0;
        }
		
		// Sort the event array based on the starting time
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? b[2] - a[2] : a[0] - b[0]);
        
		// Use an array to record the maximum value
        int[] maxArr = new int[events.length];
        
        maxArr[events.length - 1] = events[events.length - 1][2];
        for(int i = events.length - 2; i >= 0; i--) {
            maxArr[i] = Math.max(maxArr[i + 1], events[i][2]);
        }
        
		// The current maximum value is the last event
        int ans = events[events.length - 1][2];
        
        for(int i = 0; i < events.length - 1; i++) {
            int index = find(events, events[i][1], i + 1);
            
            if(index == -1) {
			// If we cannot find a non-overlapping event, the maximum so far is the current event value
                ans = Math.max(ans, events[i][2]);
            } else {
			// The maximum is the current event value plus the nonoverlapping event value
                ans = Math.max(ans, events[i][2] + maxArr[index]);
            }
        }
        
        return ans;
    }
    
    private int find(int[][] events, int target, int left) {
	// Binary search to find the first nonoverlapping event
        int right = events.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if(events[mid][0] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if(events[left][0] > target) {
            return left;
        }
        
        if(events[right][0] > target) {
            return right;
        }
        
        return -1;
    }
}