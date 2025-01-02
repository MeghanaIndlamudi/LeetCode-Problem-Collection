class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Map<Integer,Integer> nm=new HashMap<>();
        int i=0;
        int b[]=new int[words.length];
        for(String p:words)
        {
            int f=0;
            char c=p.charAt(0);
            char d=p.charAt(p.length()-1);
            if((c=='a' || c=='e' || c=='i' || c=='o' || c=='u') && (d=='a' || d=='e' || d=='i' || d=='o' || d=='u'))
            {
                nm.put(i,1);
                f++;
            }
            if(f==1)
            {
                b[i]=1;
            }
            if(i>0)
            {
                b[i]+=b[i-1];
            }
            i++;
        }
        int m=0;
        int a[]=new int[queries.length];
        for(int p[]: queries)
        {
            int c=0;
            if(p[1]==0)
            {
                if(nm.containsKey(p[1]))
                {
                    c++;
                }
                a[m++]=c;
            }
            else if(p[0]==0)
            {
                a[m++]=b[p[1]];
            }
            else
            {
                a[m++]=b[p[1]]-(b[p[0]-1]);
            }
        }
        return a;
    }
}