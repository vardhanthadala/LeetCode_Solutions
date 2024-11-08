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
                ans = 0;// Reset `ans` for the expression inside the parentheses
                sign = 1;
            } else if (s.charAt(i) == ')') {// If the character is ')', end the current expression
                int prevSign = stack.pop();// Retrieve the last `sign` before the parentheses
                ans = prevSign * ans; // Apply the sign to the result of the inner expression
                int prevAns = stack.pop();// Retrieve the last result stored before the parentheses
                ans = ans + prevAns;

            }

        }
        return ans;
    }
}
