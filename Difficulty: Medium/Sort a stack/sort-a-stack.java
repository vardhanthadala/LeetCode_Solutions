//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
           if (s.isEmpty() || s.size() == 1) {
            return s;
        }
        // Step 1: Remove the top element
        int top = s.pop();
        
        // Step 2: Recursively sort the remaining stack
        sort(s);
    
        // Step 3: Insert the popped element back in the sorted order
        insertInSortedOrder(s, top);

        return s;
    }
    private void insertInSortedOrder(Stack<Integer> s, int element){
         // Base case: If the stack is empty or the top element is smaller than or equal to the element
        if (s.isEmpty() || s.peek() <= element) {
            s.push(element);
            return;
        }

        // Step 1: Remove the top element
        int top = s.pop();

        // Step 2: Recursively insert the element into the sorted stack
        insertInSortedOrder(s, element);

        // Step 3: Push the top element back
        s.push(top);
    }
}