class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;     

        Stack<Integer> stack = new Stack<>();  

        for(int i=0;i<n;i++) {                           
            if(asteroids[i] > 0 || stack.isEmpty()) {// positive element
                stack.push(asteroids[i]);//if larger --> push to stack
            }
            else{ //negative element
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])){
                    stack.pop();// if smaller --> destroyed
                }
                if(!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])){
                    stack.pop();// if equal --> destroyed
                }
                else{
                    if(stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroids[i]);
                    }
                }
            }
        }

        int[] ans = new int[stack.size()];       
        for(int i=stack.size()-1;i>=0;i--) {  //ans should be in descending order
            ans[i] = stack.pop(); //add stack elements to array
        }

        return ans;
    }
}