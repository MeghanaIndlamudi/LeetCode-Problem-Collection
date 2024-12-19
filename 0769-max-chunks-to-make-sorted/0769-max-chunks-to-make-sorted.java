class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans=0;
        int cur=arr[0];
        for(int i=0;i<arr.length;i++){
            cur=Math.max(cur,arr[i]);
            if(cur==i) ans++;
        }
        return ans; 
    }
}