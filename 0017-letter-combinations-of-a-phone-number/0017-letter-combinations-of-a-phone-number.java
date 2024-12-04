class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        Map<Character, String> letterMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(result, current, 0, digits, letterMap);
        return result;
    }

    private void backtrack(List<String> result, List<String> current, int index, String digits, Map<Character, String> letterMap) {
        if (index == digits.length()) {
            result.add(String.join("", current));
            return;
        }
        for (char c : letterMap.get(digits.charAt(index)).toCharArray()) {
            current.add(String.valueOf(c));
            backtrack(result, current, index + 1, digits, letterMap);
            current.remove(current.size() - 1);
        }
    }
}