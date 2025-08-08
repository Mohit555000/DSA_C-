//https://leetcode.com/problems/counting-bits/
// video solution https://www.youtube.com/watch?v=rbzEecDRhAE
class Solution {
    public:
        vector<int> countBits(int n) {
            vector<int> bits;
            for (int i = 0; i <= n; i++) {
                int count = 0;
                int num = i;
                while (num > 0) {
                    if (num % 2) count++; // check if last bit is 1
                    num = num/ 2;       // shift right to check the next bit
                }
                bits.push_back(count);
            }
            return bits;
        }
    };

//This is the brute force approach,
// lets take a big example 101001

// we have to count the number of 1 in each binary representation 
// so we are maintaing a count which will tell use the number of 1s present in the binary
// 101001 in this last digit is 1, how we will get this ? just do  num&1 or num%2 both wil give the last digit. 
// Now we got the last digit and if it is 1 we are increasing the count
// now we have to remove that 1 from the number, how we will do this ?? just do num >>1 (right shit the number bu 1) of just do num/2.
// now the number 101001 has become 10100 
// we will repeat the same proess till the num is greater than 0
// if n==0 we will break the while loop and will push the count into the vector
// we will do the same process for every digit of i 
// and in return we will just return the vector.
//time complexity is n* log(n), the outer loop will iterate from o to n and inner loop will run log2(n) since we are dividing the number by 2.



class Solution {
    public:
        vector<int> countBits(int n) {
            vector<int> bits(n+1,0);
            for (int i = 0; i <= n; i++) {
               if(i%2==0){
                bits[i]=bits[i/2];
               }
               else{
                bits[i]=bits[i/2]+1;
               }
            }
            return bits;
        }
    };

// This is optimized approach with time complexity of O(n)
// so what i have done here is take the example
// 0 --> 0000
// 1 --> 0001
// 2 --> 0010
// 3 --> 0011
// 4 --> 0100
// 5 --> 0101
// 6 --> 0110
// 7 --> 0111
// 8 --> 1000
// 9 --> 1001
//10 --> 1010
//11 --> 1011
//12 --> 1100
//13 --> 1101
//14 --> 1110
//15 --> 1111
// This is the binary representation of all the nnumbers from 0 to 15.
//we can see the pattern here, binary representation (BR) of 2 = 0010 and BR of 4 is 0110,
// the number of 1 in both 2 and 4 are same, it is just that we are left shifting number 2 to make it 4. i.e means if we do left shift a number n we will get 2n as a result
//no number of 1 in n and 2n will remain the same. but the catch is it is only valid for even numbers. not odd numbers.
//now BR of 5 is 0101 and 10 is 1010 and br of 11 is 1011, that means if will left shit the number 5 we will get 10 and add 1 to it we will get 11.
//so number of 1 in odd will be n/2 + 1