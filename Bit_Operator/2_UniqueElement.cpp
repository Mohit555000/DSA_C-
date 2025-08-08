#include <cmath>
#include <iostream>
using namespace std;
// Find Unique element
int main() {
  int numbers[7] = {1, 1, 2, 3, 3};
  int result = 0;
  for (int num : numbers) {
    result = result ^ num;
  }
  cout << result;
}

// DO xor of all the elemetns
// XOR of same number will cancle out each other i.e if two numbers are same
// then xor of two numbers is zero