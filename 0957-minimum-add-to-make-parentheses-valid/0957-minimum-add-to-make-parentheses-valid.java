class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                count++;
            }
        }
            // Count the remaining unmatched opening parentheses
        count += stack.size();
        return count;
    }
}
