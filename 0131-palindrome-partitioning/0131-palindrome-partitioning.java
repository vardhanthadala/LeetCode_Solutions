class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        List<String>path=new ArrayList<>();
    PartitionHelper(0,s,path,res);
    return res;
    }

    private void PartitionHelper(int idx, String s, List<String> path, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i + 1));// add substring palindrome
                PartitionHelper(i + 1, s, path, res);// go to next substring palindrome
                path.remove(path.size() - 1);// backtrack

            }
        }

    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}