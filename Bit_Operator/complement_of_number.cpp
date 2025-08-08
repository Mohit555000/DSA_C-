//https://leetcode.com/problems/number-complement/

class Solution {
    public:
        int findComplement(int num) {
            int mask = 0;
            int temp = num;
    
            // Build a mask with all 1s in the positions of num
            while (temp > 0) {
                mask = (mask << 1) | 1;
                temp = temp >> 1;
            }
    
            // Flip the bits using XOR
            return num ^ mask;
        }
    };

    
