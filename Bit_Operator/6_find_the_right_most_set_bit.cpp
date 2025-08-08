#include <iostream>
using namespace std;

// Find the rightmost set bit
int main() {
    int number = 0b00000000; // binary input

    if (number == 0) {
        cout << "number is 0 can't find the rightmost set bit";
    } else {
        int position = 1;

        // Handle negative numbers
        // If number is negative, convert it to positive before finding the set bit.
        number = abs(number); // Take absolute value for negative numbers

        while (number > 0) {
            if ((number & 1) == 1) {
                break;
            }
            number = number >> 1;
            position = position + 1;
        }

        cout << "Rightmost set bit is at position: " << position;
    }
}
