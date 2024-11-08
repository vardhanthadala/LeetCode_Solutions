class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>(); 

        char prevSign = '+'; // Tracks the last operator seen; initialized as `+` to handle the first number
        int num = 0;         // Temporary variable to build multi-digit numbers

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // Process the current `num` when we encounter an operator or reach the end of the string
            if (isOperator(c) || i == s.length() - 1) {
                if (prevSign == '+') {
                    stack.push(num);  // Push `num` to the stack for addition
                } else if (prevSign == '-') {
                    stack.push(-num); // Push `-num` to the stack for subtraction
                } else if (prevSign == '*') {
                    int top = stack.pop();      // Pop the last number for multiplication
                    stack.push(top * num);      // Multiply and push the result back onto the stack
                } else if (prevSign == '/') {
                    int top = stack.pop();      // Pop the last number for division
                    stack.push(top / num);      // Divide and push the result back onto the stack
                }
                
                num = 0;          // Reset `num` for the next number
                prevSign = c;     // Update `prevSign` to the current operator
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;  
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*';
    }
}
