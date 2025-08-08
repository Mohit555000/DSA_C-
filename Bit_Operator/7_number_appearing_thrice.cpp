//Unique Number III

//Given an array where every element occurs three times, except one element which occurs only once. Find the element that occurs once.

//Examples:

//Input: arr[] = [1, 10, 1, 1]
//Output: 10
//Explanation: 10 occurs once in the array while the other element 1 occurs thrice.


//Input: arr[] = [3, 2, 1, 34, 34, 1, 2, 34, 2, 1]
//Output: 3
//Explanation: All elements except 3 occurs thrice in the array.

//The approach is based on the observation that in a binary representation of numbers, the bits that are set to 1 in the number that occurs only once will have a sum that is not a multiple of 3, while the bits that are set to 1 in the numbers that occur three times will have a sum that is a multiple of 3.

//Here’s a breakdown of the intuition:

// Counting set bits: For each bit position (from least significant to most significant), iterate through the array and count the number of times the bit is set to 1 in each element. This gives us the sum of set bits for that particular position across all elements.
// Modulo 3: Take the modulo 3 of the sum of set bits for each position. If the result is not 0, it means that the number that occurs only once has a 1 in that bit position, while the numbers that occur three times contribute in multiples of 3 and hence cancel out. For example, in the array {1, 1, 1, 10}, the binary representation is: 1 = 0001 and 10 = 1010. Counting set bits at each position: bit 0 appears 3 times → 3 % 3 = 0, bit 1 appears once → 1 % 3 = 1, bit 2 → 0 % 3 = 0, bit 3 appears once → 1 % 3 = 1. So the final binary result is 1010, which is 10, the unique number.


#include <iostream>
#include <vector>
using namespace std;

int getSingle(vector<int>& arr) {
    int result = 0, x, sum;

    // Iterate through every bit (from 0 to 31)
    for (int i = 0; i < 32; i++) {
        sum = 0;

         // Get the mask for the i-th bit position
        x = (1 << i); 

        // Iterate over the array and count the number of set
        // bits at position i
        for (int j = 0; j < arr.size(); j++) {

            // Check if the i-th bit is set in arr[j]
            if (arr[j] & x) {  
                sum++;
            }
        }

        // If sum is not a multiple of 3, it's part of the unique element
        if ((sum % 3) != 0) {
            result |= x;
        }
    }

    return result;  
}

int main() {
    vector<int> arr = {1, 10, 1, 1};
    cout << getSingle(arr) << endl;
    return 0;
}


//so that means if the it is uique then set uniwue to result and return it else leave result as it is 