class Solution {
    // //1.Brute force time:O(q * n)
    // public int[] maximumBeauty(int[][] items, int[] queries) {
    // int[] result = new int[queries.length];
    // for (int i = 0; i < queries.length; i++) {
    // int maxPrice = queries[i];
    // int maxBeauty = 0;

    // // For each item, check if its price is within the allowed limit
    // for (int[] item : items) {
    // int price = item[0];
    // int beauty = item[1];
    // // If item price is within the query limit and beauty is higher than the
    // current
    // // max

    // if (price <= maxPrice) {
    // maxBeauty = Math.max(maxBeauty, beauty);
    // }
    // }
    // result[i] = maxBeauty;
    // }
    // return result;

    // }


    //optimal approach using sorting  time O((n+q)logn)  space O(n+q)

    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price in ascending order
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Create an array of (query, index) pairs so we can return results in the
        // original order
        int[][] queriesWithIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }
        // Sort queries by price in ascending order
        Arrays.sort(queriesWithIndex, (a, b) -> a[0] - b[0]);

        // Array to store results for each query
        int[] result = new int[queries.length];
        int maxBeauty = 0; // Keep track of the max beauty encountered so far
        int itemIndex = 0; // Pointer to iterate through items

        // Process each query in ascending order
        for (int[] query : queriesWithIndex) {
            int maxPrice = query[0];
            int originalIndex = query[1];

            // Update maxBeauty for all items with price <= maxPrice
            while (itemIndex < items.length && items[itemIndex][0] <= maxPrice) {
                maxBeauty = Math.max(maxBeauty, items[itemIndex][1]);
                itemIndex++;
            }

            // Store the result for the current query
            result[originalIndex] = maxBeauty;
        }

        return result;
    }
}