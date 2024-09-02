class Solution {
    public int fib(int n) { 
//--------------->recursion f(4)= 0 1 1 2 3<---------------------------
        // if(n<=1) return n;

        // return fib(n-1)+fib(n-2);

//--------------------------->memoization<-----------------------------
//Tc-O(N)  Sc-O(N)
        // int[]dp=new int[31];
        // Arrays.fill(dp,-1);

        // if(n<=1)  return n; //base case

        // if(dp[n]!= -1) return dp[n];

        // return dp[n]= fib(n-1) + fib(n-2);
//-------------------------->Tabulation<--------------------------
    //Tc-O(N)  Sc-O(N)

        // if(n<=1) return n;
        //     int[]dp=new int[31];
        //     dp[0]=1;
        //     dp[1]=1;
        //     for(int i=2;i<=n;i++) {
        //         dp[i]=dp[i-1]+dp[i-2];
        //     }
        // return dp[n-1];

//-------------->space optimization<--------------------------
//Tc-O(N)  Sc-O(1)
    if(n<=1) return n;

    int prev2=0;
    int prev=1;
    
    for(int i=2;i<=n;i++){
        int curr_i=prev2+prev;
        prev2=prev;
        prev=curr_i;
    }

        return prev;
        }
}