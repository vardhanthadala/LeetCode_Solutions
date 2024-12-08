class Solution {
    public String removeKdigits(String num, int k) {//T:O(2N)+O(K) S:O(N)+)(N)
        // Edge case: if we need to remove all digits
        if (k == num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            // Push the current digit to the stack
            stack.push(digit);
        }

        // Remove remaining digits from the end if k > 0
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        result.reverse();

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}
