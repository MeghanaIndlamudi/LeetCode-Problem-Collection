class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        int tot = a + b + c;
        int currA = 0, currB = 0, currC = 0;
        for(int i = 0;i< tot;i++){
            if((a >= b && a >= c && currA !=2) || (a>0 && (currB == 2 || currC == 2))){
                res.append("a");
                a--;
                currA++;
                currB = 0;
                currC = 0;
            } else if((b >= a && b >= c && currB !=2) || (b>0 && (currC == 2 || currA == 2))){
                res.append("b");
                b--;
                currB++;
                currA = 0;
                currC = 0;
            } else if((c >= b && c >= a && currC != 2) || (c>0 && (currB == 2 || currA == 2))){
                res.append("c");
                c--;
                currC++;
                currA = 0;
                currB = 0;
            }
        }
        return res.toString();
    }
}