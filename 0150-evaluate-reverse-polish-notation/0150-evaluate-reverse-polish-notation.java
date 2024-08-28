class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            switch (c) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first - second);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.parseInt(c));
                    break;
            }
        }
        return stack.peek();
    }
}
