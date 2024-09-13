class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedChars=new HashSet<>();
        
        for(int i=0;i<allowed.length();i++)
        {
            allowedChars.add(allowed.charAt(i));
        }
        int count=0;
        for(String word:words){
            boolean isConsistent=true;
        for(int i=0;i<word.length();i++)
        {
            char currentChar=word.charAt(i);
            
            if(!allowedChars.contains(currentChar))
            {
                isConsistent=false;
                break;
            }
        }
        if(isConsistent)
        {
            count++;
        }
    }
        return count;
        }
}