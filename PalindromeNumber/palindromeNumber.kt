/*
Input x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
*/

class Solution
{
    fun isPalindrome(x: Int): Boolean
    {
        // Check if the number is negative or ends with zero but is not zero itself
        if (x < 0 || (x % 10 == 0 && x != 0))
        {
            return false
        }

        var reversed = 0
        var num = x
        
        // Reverse the number
        while (num > reversed)
        {
            reversed = reversed * 10 + num % 10 // Add the last digit to the reversed number
            num /= 10 // Remove the last digit from num
        }

        // Compare the original number with the reversed number and reversed number divided by 10 (for odd-length palindromes)
        return num == reversed || num == reversed / 10
    }
}