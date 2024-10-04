class Solution {
    private static boolean possible(int bloomDay[], int day, int m, int k) {
        int noOfBouquets = 0; 
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++; 
            } else {
                noOfBouquets += count / k; 
                count = 0; 
            }
        }

        // Add any remaining flowers that could form bouquets
        noOfBouquets += count / k;
        return noOfBouquets >= m; 
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k; 
        int n = bloomDay.length;

        if (val > n) {
            return -1;
        }

        int max = Integer.MIN_VALUE; 
        int min = Integer.MAX_VALUE; 

        for (int i = 0; i < n; i++) {
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }

        int low = min; 
        int high = max; 

        while (low < high) {
            int mid = low + (high - low) / 2; 

            if (possible(bloomDay, mid, m, k)) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }

        return low; 
    }
}
