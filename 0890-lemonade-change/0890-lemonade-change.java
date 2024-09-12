class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int five=0,ten=0;

        for(int bill:bills){
            if(bill==5){//if its 5 dollar bill
                five++;
            }else if(bill==10){//if its 10 dollar bill
                if(five==0){
                    return false;
                }
                five--;
                ten++;
            }
            else if(bill==20){//if its 20 dollar bill
               if(five>0 && ten>0){
                ten--;
                five--;
               }else if(five>=3){
                five-=3;
               }else{
                return false;
               }
            }
        }
        return true;
    }
}