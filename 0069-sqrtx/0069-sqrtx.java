class Solution {
    public int mySqrt(int x) {
        //  If mid² < x, all numbers less than mid also have square < x
        //  If mid² > x, all numbers greater than mid have square > x

        if (x < 2) {// sqrt(0)=0, sqrt(1)=1
            return x;
        }
        int low = 1;
        int high = x / 2;
        int ans = 0;

        while (low <= high) {// we want --> r^2 ≤ 8
            int mid = low + (high - low) / 2;
            long squared = (long)mid * mid;

            if (squared == x) {
                return mid;
            } else if (squared < x) { // mid too small
                ans = mid; //possible number
                low = mid + 1;//try biger number
            } else { // mid is too big
                high = mid - 1;//try smaller number
            }
        }
        return ans;// largest mid where mid^2 <= x
    }
}