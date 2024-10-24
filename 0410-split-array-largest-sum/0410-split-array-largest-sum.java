class Solution {//same as allocate min no.of pages problem

    private static int countStudents(int nums[], int pages) {
        int n = nums.length;
        int students = 1; 
        long pagesStudent = 0; 
        
        for (int i = 0; i < n; i++) {
            if (pagesStudent + nums[i] <= pages) {
                // Add pages to current student
                pagesStudent += nums[i];
            } else {
                // Assign the current book to the next student
                students++;
                pagesStudent = nums[i]; // Reset to current book's pages
            }
        }
        return students;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        // If there are more students than books, it's impossible
        if (k > n) {
            return -1;
        }

        
        int low = Integer.MIN_VALUE; // Minimum possible max pages(max number in nums array)
        int high = 0; // Maximum possible max pages (sum of all pages)
        
        for (int pages : nums) {
            high += pages; // Sum of all pages
            if (pages > low) {
                low = pages; // The largest single book
            }
        }
        
        while (low <= high) {
            int mid = (low + high) / 2; 
            int students = countStudents(nums, mid); 
            
            if (students > k) {
                low = mid + 1; // Increase the max pages allowed
            } else {
                high = mid - 1; // Try to lower the max pages
            }
        }
        return low; // The smallest max pages that allows k students
    }
}
