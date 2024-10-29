class Solution {
    public int countPrimes(int n) {// time : O(nlogn) time : O(n)
        if (n <= 2)
            return 0; // No primes less than 2

        int[] prime = new int[n];
        // Initialize all entries of prime[] as 1 (indicating potential primes)
        // initializing prime(all elements 2-->n) with 1
        for (int i = 2; i < n; i++) {
            prime[i] = 1;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (prime[i] == 1) {// initialized with 1 to indicate that every number is assumed to be prime.
                // Mark multiples of i as non-prime
                for (int j = i * i; j < n; j += i) {// mutliples of numbers are non-prime numbers so mark it as 0
                    prime[j] = 0;
                }
            }
        }

        int count = 0;
        // Count primes
        for (int i = 2; i < n; i++) {
            if (prime[i] == 1)
                count++;
        }
        return count;
    }
}
