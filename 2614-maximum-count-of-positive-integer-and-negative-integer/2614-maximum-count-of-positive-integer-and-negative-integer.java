class Solution {
    public int maximumCount(int[] nums) {
        int poscount=nums.length-upperBound(nums);
        int negcount=lowerBound(nums);

        return Math.max(poscount,negcount);
    }
    private int lowerBound(int[] nums){
       int i=0,j=nums.length-1;
       int index=nums.length;
       while(i<=j)
       {
        int mid =(i+j)/2;
        if(nums[mid]<0)
           i=mid+1;
        else if(nums[mid]>=0)
        {
            j=mid-1;
            index=mid;
        }
       }
       return index; 
    }
    private int upperBound(int[] nums){
       int i=0,j=nums.length-1;
       int index=nums.length;
       while(i<=j)
       {
        int mid =(i+j)/2;
        if(nums[mid]<=0)
           i=mid+1;
        else if(nums[mid]>0)
        {
            j=mid-1;
            index=mid;
        }
       }
       return index; 
    }
}