class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCritical = -1;
        int lastCritical = -1;
        int minDistance = Integer.MAX_VALUE;
        
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1; // 0-indexed position of curr
        
        while (curr != null && curr.next != null) {
            ListNode nextNode = curr.next;
            
            // Check if curr is a local maxima or local minima
            boolean isLocalMaxima = curr.val > prev.val && curr.val > nextNode.val;
            boolean isLocalMinima = curr.val < prev.val && curr.val < nextNode.val;
            
            if (isLocalMaxima || isLocalMinima) {
                if (firstCritical == -1) {
                    firstCritical = index;
                } else {
                    // Min distance is between adjacent critical points
                    minDistance = Math.min(minDistance, index - lastCritical);
                }
                lastCritical = index;
            }
            
            prev = curr;
            curr = nextNode;
            index++;
        }
        
        // If fewer than two critical points are found
        if (firstCritical == lastCritical) {
            return new int[]{-1, -1};
        }
        
        int maxDistance = lastCritical - firstCritical;
        return new int[]{minDistance, maxDistance};
    }
}