class Solution {

    // maximum pile size
    private int getMaxPile(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canEatWithinTime(int[] piles, int h, int k) {
        int totalHours = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            totalHours += (piles[i] + k - 1) / k;// k is eating speed
        }

        return totalHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1; // Minimum eating speed
        int right = getMaxPile(piles); // max eating speed

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatWithinTime(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
