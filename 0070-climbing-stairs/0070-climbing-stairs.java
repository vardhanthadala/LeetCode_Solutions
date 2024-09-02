class Solution {
    public int climbStairs(int n) {
    //  ------------->Recursion<-------------Time-O(2^n)

    // if(n==0 ||n==1) return 1;

    // return climbStairs(n-1)+climbStairs(n-2);

//------------------->Tabulation<--------------------------O(n),O(n)

    // if(n==0 || n==1) return 1;

    // int[]dp=new int[n+1];

    // dp[0]=dp[1]=1;

    // for(int i=2;i<=n;i++){
    //     dp[i]=dp[i-1]+dp[i-2];
    // }
    // return dp[n];
    //------------------->space optimization<--------------------------


    if(n==0||n==1) return 1;

    int prev=1;
    int curr=1;

    for(int i=2;i<=n;i++){
        int temp=curr;
        curr=prev+curr;
        prev=temp;

    }
    return curr;
    }
}