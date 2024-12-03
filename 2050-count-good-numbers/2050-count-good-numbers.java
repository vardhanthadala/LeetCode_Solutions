//preReq - 50. Pow(x, n)
class Solution {

    int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2; // Number of even-indexed positions
        long odd = n / 2; // Number of odd-indexed positions

        long first = pow(5, even); // Compute 5^even % MOD
        long second = pow(4, odd); // Compute 4^odd % MOD

        return (int) ((first * second) % MOD); // Combine results modulo MOD
    }

    private long pow(long x, long n) {
        if (n == 0) {
            return 1;
        }

        x %= MOD; // Reduce x modulo MOD

        if (n % 2 == 0) {
            long half = pow(x, n / 2);
            return (half * half) % MOD;
        } else {
            return (x * pow(x, n - 1)) % MOD;
        }
    }
}
