// C++ program to find if the number is power of 2
#include <bits/stdc++.h>
using namespace std;

int main() {
    int number = 8;  // You can change this number to test

    if (number > 0 && (number & (number - 1)) == 0) {
        cout << "The number is power of 2";
    }
    else {
        cout << "Not a power of 2";
    }
}


// Formula No of digits  in base b of no n = int(log n base b) + 1