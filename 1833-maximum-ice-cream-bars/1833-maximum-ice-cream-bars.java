class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int min = Arrays.stream(costs).min().getAsInt();
        int max = Arrays.stream(costs).max().getAsInt();
        int range = max-min+1;
        int[] freq = new int[range];
        int[] sorted = new int[costs.length];
        for(int i : costs){
            freq[i-min]++;
        }
        for(int i=1;i<freq.length;i++){
            freq[i] = freq[i-1] + freq[i];
        }
        for(int i=costs.length-1;i>=0;i--){
            freq[costs[i]-min]--;
            sorted[freq[costs[i]-min]] = costs[i];
        }
        int sum=0;
        int ans=0;
        for(int i=0;i<sorted.length;i++){
            sum += sorted[i];
            if(sum <= coins){
                ans++;
            }
            else break;
        }
    return ans;
    }
}