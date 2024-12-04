class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generateHelper(result, "", 0, 0, n);
        return result;
    }

    private void generateHelper(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Adding open parenthsese
        if (open < max) {
            generateHelper(result, current + '(', open + 1, close, max);
        }
        if (close < open) {
            generateHelper(result, current + ')', open, close + 1, max);
        }

    }
}