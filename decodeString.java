class Solution {
    public String decodeString(String s) {
        Stack<String> stStr = new Stack<>();
        Stack<Integer> stInt = new Stack<>();
        String currStr = "";
        int currInt = 0 ;

        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currInt = currInt*10 + ch - '0';
            }
            else if(ch == '['){
                stStr.push(currStr);
                stInt.push(currInt);
                currStr="";
                currInt=0;
            }
            else if(ch == ']'){
                String prev = stStr.pop();
                int times = stInt.pop();
                String temp = "";
                temp = temp+prev;
                for(int j=0;j<times;j++){
                    temp = temp+currStr;
                }
                currStr = temp;
            }
            else{
                currStr = currStr + ch;
            }

        }
        return currStr;
    }
}