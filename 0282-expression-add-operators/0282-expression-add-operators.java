 class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, num, target, 0, 0, 0, "");
        return result;
    }

    private void backtrack(List<String> result, String num, int target, int index, long currentValue, long lastValue, String expression) {
        
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expression);
            }
            return;
        }

       
        for (int i = index; i < num.length(); i++) {
            // Extract the current substring
            String currentSubstring = num.substring(index, i + 1);
            long currentNumber = Long.parseLong(currentSubstring);

            // Skip numbers with leading zeros
            if (num.charAt(index) == '0' && i > index) {
                break;
            }

            // If it's the first number, just take it without any operator
            if (index == 0) {
                backtrack(result, num, target, i + 1, currentNumber, currentNumber, currentSubstring);
            } else {
                // Try adding '+'
                backtrack(result, num, target, i + 1, currentValue + currentNumber, currentNumber, expression + "+" + currentSubstring);

                // Try adding '-'
                backtrack(result, num, target, i + 1, currentValue - currentNumber, -currentNumber, expression + "-" + currentSubstring);

                // Try adding '*'
                backtrack(result, num, target, i + 1, currentValue - lastValue + lastValue * currentNumber, lastValue * currentNumber, expression + "*" + currentSubstring);
            }
        }
    }
 }
  