class Solution {
    public int removeDuplicates(int[] nums) {
        int read=1,write=1;
        while(read<nums.length&&write<nums.length)
        {
            if(nums[read]!=nums[write-1])
            {
                nums[write]=nums[read];
                write++;
            }
            read++;
        }
        return write;
    }
}