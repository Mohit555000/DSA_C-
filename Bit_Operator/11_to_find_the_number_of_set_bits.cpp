// C++ program to find the number of set bits
#include <bits/stdc++.h>
using namespace std;

int main() {
    int number = 0b100010;  
    int count=0;
  while(number>0){
    if((number&1) == 1){
      count++;
    }
    number=number>>1;
  }
  cout<<count;
}

