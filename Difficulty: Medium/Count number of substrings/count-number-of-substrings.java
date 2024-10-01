//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long countAtMostKDistinct (String S, int K) {
       int left=0;
       int right=0;
       int n=S.length();
       int distCount=0;
       int subStringCount=0;
       
       // Array to store the frequency of characters in the current substring
        int[] charFrequency = new int[26];
        
        while(right<n){
            int charIndex=S.charAt(right)-'a';
            charFrequency[charIndex]++;
            
            //if freq is 1 then new distCharacter is added;
            if(charFrequency[charIndex]==1){
                distCount++;
            }
            //// if  no.of distinct characters exceeds k, move the left pointer
            while(distCount>K){
                charFrequency[S.charAt(left)-'a']--;
                // If the frequency becomes 0, it means a distinct character is removed
                if (charFrequency[S.charAt(left) - 'a'] == 0) {
                    distCount--;
                }

                left++;
            }
            subStringCount += (right - left + 1);
            right++;
        }
        return subStringCount;
    }
     long substrCount(String S, int K) {
        // Substrings with exactly K distinct characters = 
        // (Substrings with at most K distinct characters) - (Substrings with at most K-1 distinct characters)
        return countAtMostKDistinct(S, K) - countAtMostKDistinct(S, K - 1);
    }
}