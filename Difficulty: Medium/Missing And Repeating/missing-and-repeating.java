//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

            int[] ans = new Solve().findTwoElement(arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        int n=arr.length;
        int[] result = new int[2];
        
        // Step 1: Find the repeating element
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                result[0] = Math.abs(arr[i]); // repeating element
            } else {
                arr[index] *= -1; // mark as visited
            }
        }
        
        // Step 2: Find the missing element
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                result[1] = i + 1; // missing element
                break;
            }
        }
        
        return result;
    }
}
  
