
class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {//O(N · K log K) O(N.K)
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();//Step1 : convert str -> char
            Arrays.sort(charArray);//Step2: Sort the charArray
            String sortedStr = new String(charArray);

            if (!anagramGroups.containsKey(sortedStr)) {//check if already present or not
                anagramGroups.put(sortedStr, new ArrayList<>());//if not create  a new list
            }
            anagramGroups.get(sortedStr).add(str);//if already present then add curr str to existed str list
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : anagramGroups.values()) {
            result.add(group);
        }

        return result;
    }

}
