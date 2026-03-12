//https://leetcode.com/problems/lemonade-change/description/
//https://www.youtube.com/watch?v=n_tmibEhO6Q&list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea&index=2
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count_five = 0;
        int count_ten = 0;

        for(int i = 0; i < bills.length; i++){

            if(bills[i] == 5){
                count_five++;
            }

            else if(bills[i] == 10){
                if(count_five == 0) return false;

                count_five--;
                count_ten++;
            }

            else{ // 20

                if(count_ten > 0 && count_five > 0){
                    count_ten--;
                    count_five--;
                }

                else if(count_five >= 3){
                    count_five -= 3;
                }

                else{
                    return false;
                }
            }
        }

        return true;
    }
}