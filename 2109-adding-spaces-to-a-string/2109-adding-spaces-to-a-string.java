class Solution {
    public String addSpaces(final String s, final int[] spaces) {
        final StringBuilder sb = new StringBuilder();
        int i = 0;

        for(int j = 0; j < s.length(); ++j) {
            if(i < spaces.length && j == spaces[i]) {
                sb.append(' ');
                i++;
            }
            
            sb.append(s.charAt(j));
        }

        return sb.toString();
    }
}