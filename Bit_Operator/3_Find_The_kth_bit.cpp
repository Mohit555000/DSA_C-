#include <cmath>
#include <iostream>
using namespace std;
// Find the ith bit of the number
int main() {
  int number = 0b10100110;  // binary input
  int k = 5;
  int mask = 1 << (k - 1);

  if (number & mask)
    cout << "Bit is 1";
  else
    cout << "Bit is 0";
}


//so the logic is , if we do & 1 with any bit, we will get that bit
// for eg given binary number is 10100110 and we want to find 5th bit so expected answer is 0 (count from right and move towards left) 
// 10100110
//&   10000
// --------
//    00000 
//the 4 zeros from right to left is known as mask. if we shift any bit left or right by default 0 will allocate to that empty space

//We are not directly printing the kth bit, we are checking the whole result.
//if the kth bit of the result is 0, then overall the result is 0
//if the kth bit of the result is 1, then oveall result will be greater than 0

//by knnowing these we are determining that the kth bit is 0 or 1.
