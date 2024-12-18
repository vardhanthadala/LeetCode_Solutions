//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
 
    public long findRepeating(int arr[]) {
        long n = arr.length;  // Size of the array

        long SN = (n * (n + 1)) / 2;  // Sum of first N natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;  // Sum of squares of first N natural numbers

        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += (long) arr[i] * (long) arr[i];
        }

        long val1 = S - SN;  // X - Y
        long val2 = S2 - S2N;  // X^2 - Y^2

        val2 = val2 / val1;  // X + Y

        // X = (X + Y + X - Y) / 2
        long X = (val1 + val2) / 2;

        // Y = X - (X - Y)
        return X - val1;  // Return the repeating number
    }

    public long findMissing(int arr[]) {
        long n = arr.length;  // Size of the array

        // Find the sum of the first N natural numbers and the sum of squares of first N natural numbers
        long SN = (n * (n + 1)) / 2;  // Sum of first N natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;  // Sum of squares of first N natural numbers

        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += (long) arr[i] * (long) arr[i];
        }

        long val1 = S - SN;  // X - Y
        long val2 = S2 - S2N;  // X^2 - Y^2

        val2 = val2 / val1;  // X + Y

        // X = (X + Y + X - Y) / 2
        return (val1 + val2) / 2;  // Return the missing number
    }

    public ArrayList<Integer> findTwoElement(int arr[]) {
        long repeating = findRepeating(arr);
        long missing = findMissing(arr);

        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) missing); 
        result.add((int) repeating);    

        return result;
    }
}
