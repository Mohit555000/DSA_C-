//https://leetcode.com/problems/binary-watch/description/

class Solution {
    public:
    vector<string> result;
        int countOnes(int num){
            int count=0;
            while(num>0){
                if(num&1){
                    count++;
                }
                num=num>>1;
            }
            return count;
        }
        vector<string> readBinaryWatch(int turnedOn) {
            for(int h=0;h<12;h++){
                for(int m=0;m<60;m++){
                    if(countOnes(h)+countOnes(m)==turnedOn){
                        string time = to_string(h) + ":" + (m < 10 ? "0" : "") + to_string(m);
                        result.push_back(time);
                    }
                }
            }
            return result;
    
        }
    };

// intution:
// humko number vo kab display hoga, jab vo on hoga, to question ye he bol raha hai ki turned on bts for eg 1 hai
// to suppose 0:00 hai time hours= 0 minutes = 0
// hourse = 0 = 0000 --> ek be 1 nhi hai is mai. mtlb ye light band hai 
// minutes = 0 = 0000 --> ye be same ek be 1 nhi hai . mtlb ye light be band hai 
// to hum ye time he nhi dikha sakte.
// binary mai 1 mtlb on hota hai , kuch cheez present hai. and 0 mtlb off hai, kuch cheeze present nhi hai 
// to bs if on hai he nhi to dikhega kasie to bus humko minutes or hours mai no of 1 nikal ne hai 
// if unka commbine given number of turned on led's se mathc hota hai to hum vo time dekh sakte hai else nhi dekh sakte