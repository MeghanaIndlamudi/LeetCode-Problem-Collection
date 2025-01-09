class Solution {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        res[0]=0;
        for(int i=1;i<=n;i++)
        {
            // base 1>>1 is 0 so from there everything is done using dynamic programming and also right shifting means removing last bit which means 2^0 which means everything is shifted so divides number by 2 half of it so dp works by checking half of its number +1 (in odd case)
            res[i]= res[i>>1]+(i&1);
        }
        return res;
    }
}