class Solution {

    // maximum pile size
    private int getMaxPile(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canEatWithinTime(int[] piles, int h, int k) {// k is minimum eating speed 
        int totalHours = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            totalHours += (piles[i] + k - 1) / k; //it calculating how many hours Koko needs to eat the i-th pile at speed k, and then adding it to the total hours. ⌈piles[i]/k​⌉ = piles[i]+k−1 / k ​(integer division)
        }
        //totalHours = total time Koko takes to eat all piles at speed k.
        //h = the total hours Koko has before guards come.
        return totalHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1; // Minimum eating speed
        int right = getMaxPile(piles); // max eating speed

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatWithinTime(piles, h, mid)) {
                right = mid;// Try smaller speed
            } else {
                left = mid + 1;//Need higher sppeed
            }
        }

        return left;
    }

}
