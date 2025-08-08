#include <cmath>
#include <iostream>
using namespace std;
// Find whether number is even or odd
int main() {
  int n;
  cout << "Enther the number";
  cin >> n;
  if ((n & 1) == 1) {    //this will convert the binary into the decimal and will tell us that whether it is one or zero
    cout << "The number is odd";
  } else {
    cout << "Number is even";
  }
}

//logic
// suppose we get input as 10. its binary representzation is 1010
//now the right most bit will determine whether the number is even or odd
//If we do bitwise & 1 with the given number , we will get the given number only , when we do & 0 with any number we get 0
// so 1010
//    0001
//    ----
//    0000 = 0
//The right most digit is zero and overall the number is also zero that why the number is even 