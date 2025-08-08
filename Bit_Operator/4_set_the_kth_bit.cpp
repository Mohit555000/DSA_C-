#include <cmath>
#include <iostream>
using namespace std;
// set the ith bit of the number
int main() {
  int number = 0b10110110;  // binary input
  int k = 5;
  int mask=1<<(k-1);
  if(number & mask){
      cout << "the kth bit is already set";
  }
  else{
    number=number | mask;
    cout<<number;
  }

}

// set the bit means, if the ith bit is 0 make it 1 else leave as it is
//So the logic is if we do or 1 with any bit, we will get 1
// 10110110
//|00010000
//----------
// 10010110      