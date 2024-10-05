public class Solution {
    public static int maxScore(int[] cardPoints, int k) {
        int sumOfK = 0;
        for (int i = 0; i < k; i++) {
            sumOfK += cardPoints[i];
        }
        
        int maxSum = sumOfK;
        int n = cardPoints.length;
        int i = 0;
        while (i < k) {
            sumOfK += cardPoints[n - 1 - i] - cardPoints[k - 1 - i];//taking card from begining and end
            maxSum = Math.max(maxSum, sumOfK);
            i++;
        }
        
        return maxSum;
    }
}