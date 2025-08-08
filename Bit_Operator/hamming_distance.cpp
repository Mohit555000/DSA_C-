// https://leetcode.com/problems/hamming-distance/
class Solution {
    public:
        int hammingDistance(int x, int y) {
            int count=0;
            while(x > 0 || y > 0){
                if((x&1)!=(y&1)){
                    count++;
                }
                x=x>>1;
                y=y>>1;
            }
            return count;
        }
    };

// just comapre the lsb bits (mtlb right most bit) if dono alag hai to count mai add kar do warna mt add karo