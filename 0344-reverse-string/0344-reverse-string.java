// class Solution {
//     public void reverseString(char[] s) {
//         int left = 0;
//         int right = s.length - 1;
//         while (left <= right) {
//             char temp = s[left];
//             s[left] = s[right];
//             s[right] = temp;
//             left++;
//             right--;
//         }
//     }
// }

class Solution {
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverse(s, left + 1, right - 1);//This line is the heart of recursion — after swapping the first and last characters, we need to move inward and repeat the process
    }
}