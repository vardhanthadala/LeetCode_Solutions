class Solution {
    public int fib(int n) { //recursion f(4)= 0 1 1 2 3
        // if(n<=1) return n;

        // return fib(n-1)+fib(n-2);

               //memoization

        int[]dp=new int[31];
        Arrays.fill(dp,-1);

        if(n<=1)  return n; //base case

        if(dp[n]!= -1) return dp[n];

        return dp[n]= fib(n-1) + fib(n-2);


        }
}