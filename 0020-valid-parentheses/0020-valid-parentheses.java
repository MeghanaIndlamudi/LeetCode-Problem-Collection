class Solution {
    public boolean isValid(String s) {
      Stack stk=new Stack<>();
        char b;
        for (int i=0;i<s.length();i++)
        {
            char a=s.charAt(i);
            if(a=='('||a=='['||a=='{')
            {
                stk.push(s.charAt(i));
            }
            else if(a==')'||a==']'||a=='}')
            {
                if(!stk.isEmpty())
                    b=(char)stk.peek();
                    else
                        return false;
                    if(b=='('&&a==')')
                        stk.pop();
                    else if(b=='{'&&a=='}')
                        stk.pop();
                    else if(b=='['&&a==']')
                        stk.pop();
                    else
                        return false;
                
            }
            else
                return false;
        }
        if(stk.isEmpty())
            return true;
        return false;
    }
}