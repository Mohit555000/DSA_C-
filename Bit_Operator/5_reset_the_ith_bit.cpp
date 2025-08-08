#include <cmath>
#include <iostream>
using namespace std;
// rset the ith bit of the number
int main() {
  int number = 0b10110110;  // binary input
  int k = 5;
  int mask=~(1<<(k-1));
  number= number & mask;
  cout<<number;
}


//reset the ith bit means if 1 make it zero else leave as it is
//..so if we do & 0 with number we will get zero always.
//so this is what we have done in theis logic
//first we are crating a normal mask of  10000, then we are just doing complement of it then it becomes 01111