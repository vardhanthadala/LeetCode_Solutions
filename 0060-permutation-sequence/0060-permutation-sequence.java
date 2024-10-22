class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        
       
        for (int i = 1; i < n; i++) {
            fact *= i; // factorial of (n-1)
            numbers.add(i); // adding numbers from 1 to n-1
        }
        numbers.add(n); // adding nth number

        StringBuilder ans = new StringBuilder();
        k = k - 1; // 0-based indexing

        // Generating the permutation
        while (!numbers.isEmpty()) {
            ans.append(numbers.get(k / fact)); // get the element based on k / fact
            numbers.remove(k / fact); // remove the used number

            if (numbers.isEmpty()) {
                break;
            }
            
            k = k % fact; // update k for the next iteration
            fact = fact / numbers.size(); // update factorial for the remaining numbers
        }

        return ans.toString();
    }

}
