class Solution {
    public int possibleStringCount(String word) {
        if(word.isEmpty())
        {
            return 0;
        }
        else
        {
            int count=1;
           for(int i=1;i<word.length();i++)
           {
            if(word.charAt(i-1)!=word.charAt(i))
            {
                count++;
            }
           }
           return word.length()-count+1; 
        }
    }
}