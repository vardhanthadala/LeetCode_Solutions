class Solution {
    public int calculate(String s) {
        int len = s.length();
        int sign = 1;
        int ans = 0;
        int currNum = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {// check if i is number then add to currNum
                currNum = s.charAt(i) - '0';

                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {// while i+1 also a number then add to
                                                                           // currNum
                    currNum = currNum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                currNum *= sign;
                ans += currNum;
                currNum = 0;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                int prevSign = stack.pop();
                ans = prevSign * ans;
                int prevAns = stack.pop();
                ans = ans + prevAns;

            }

        }
        return ans;
    }
}
//Explaination : initially we  create ans,currNum,sign
//index i is digit ,add to currNum
//index i+1 is digit ? add to currNum by multiplying currNum*10+(i+1)
//we add currNum to ans
//if sign is + then we mutliply currNum with +1 or 1
//else  we mutliply currNum with -1 
//if i is ( then we push ans to stack then we push sign ,we makes ans as zero and sign as +1
//else if i is ) then we pop out elements in stack and we do add to ans