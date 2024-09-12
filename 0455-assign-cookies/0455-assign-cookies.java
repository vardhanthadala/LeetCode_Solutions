class Solution {
    public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);//greed factor
    Arrays.sort(s);//cookie
    
    int i=0;//For g
    int j=0;//For s
    int count=0;

    while(i<g.length&&j<s.length){
        if(s[j] >= g[i]){  //cookie >= greed 
            count++;
            i++;
        }
        j++;
    }
    return count;
    }
}