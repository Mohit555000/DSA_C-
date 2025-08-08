// C++ program to find nth magic number
#include <bits/stdc++.h>
using namespace std;

// Function to find nth magic number
int nthMagicNo(int n)
{
  int pow = 1, answer = 0;

  // Go through every bit of n
  while (n)
  {
  pow = pow*5;

  // If last bit of n is set
  if (n & 1)
    answer += pow;

  // proceed to next bit
  n >>= 1; // or n = n/2
  }
  return answer;
}

// Driver program to test above function
int main()
{
  int n = 5;
  cout << "nth magic number is " << nthMagicNo(n) << endl;
  return 0;
}


// A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5. First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
// Write a function to find the nth Magic number.
// Example: 

// Input: n = 2
// Output: 25

// Input: n = 5
// Output: 130 


// If we notice carefully the magic numbers can be represented as 001, 010, 011, 100, 101, 110 etc, where 001 is 0*pow(5,3) + 0*pow(5,2) + 1*pow(5,1). So basically we need to add powers of 5 for each bit set in a given integer n. 
// Below is the implementation based on this idea. 


// Approach : 

// Step 1 : declare and assign a number for which you want to find the magic number.

// Step 2 : assign a pow = 1, and ans = 0

// Step 3 : use while loop to iterate each bit until ends (while n > 0)

// Step 4 : inside loop, find last bit using & operation and  keep updating answer and  power as well

// Step 5 : Once loop exit return answer


//why only the last bit is 1 then to add in answer
//The binary is 101 (5), so we will do 1*5^1+0*5^2+1*5^3 so the 0 bit is of no use so thats why we are doing this

//pow = pow * 5; why we are doing this 

// The line in the code:

// pow = pow * 5;
// This line is updating the value of pow to represent the next power of 5.
//   🚀 Why do we need this?
//   When we want to find the n-th magic number, we are essentially adding different powers of 5 based on which bits are 1 in the binary representation of n.

//   The powers of 5 we need are:
//   5^1=5
//   5^2=25
//   5^3=125
//   Example Walkthrough:
//   Let's say n = 5 (which is 101 in binary).
//   First step:
//   pow starts as 1. This represents 5^0
//   Shift pow to represent the first power of 5(i.e 5^1)
//   Multiply pow by 5 → pow = pow * 5 → pow = 1 * 5 = 5. and so on
// Why multiply by 5?
// In each iteration of the loop:

// We're moving to the next higher power of 5.

// We do this by multiplying pow by 5 in each iteration:

// First iteration: pow = 1, which represents 5^0
// The operation pow = pow * 5 efficiently calculates the next power of 5 without requiring us to repeat expensive exponentiation calculations.

// This keeps the logic simple and the code fast.

