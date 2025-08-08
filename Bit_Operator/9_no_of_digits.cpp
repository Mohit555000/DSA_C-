// C++ program to find the number of digits in binary number
#include <bits/stdc++.h>
using namespace std;

int main() {
  int number = 10;
  int base = 2;
  int ans;
  ans = (int)(log(number) / log(base)) + 1;
  cout << ans;
}

// Formula No of digits  in base b of no n = int(log n base b) + 1