class Solution {
    public int findMaxLength(int[] nums) {
        int count=0;
        int maxlen=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                count--;
            else
                count++;
            if(hm.containsKey(count)){
                maxlen=Math.max(maxlen,i-hm.get(count));
            }
            else
                hm.put(count,i);
        }
        return maxlen;
    }
}