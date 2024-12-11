//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
         ArrayList<Integer> result = new ArrayList<>();
         //min-heap
         PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        for(int i=0;i<K;i++){ // iterates till k loops
            minHeap.offer(new Element (arr[i][0],i,0));
        }
        while(!minHeap.isEmpty()){
             // Get the smallest element from the heap.
             Element current=minHeap.poll();
             result.add(current.value);
             
        // If there is a next element in the same array, add it to the heap.

              if (current.elementIndex + 1 < K) {
                int nextValue = arr[current.arrayIndex][current.elementIndex + 1];
                minHeap.offer(new Element(nextValue, current.arrayIndex, current.elementIndex + 1));
            }
        }
        return result;
        
    }
}
class Element {
    int value;       // The value of the element.
    int arrayIndex;  // The index of the array.
    int elementIndex; // The index of the element in the array.
    
    Element(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}
