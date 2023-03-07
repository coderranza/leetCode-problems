// Example
/*
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/
class SolutionLongestSubString
{
    fun main()
    {
        val test:String = "test"
        lengthOfLongestSubstring(test);
    }

    fun lengthOfLongestSubstring(s: String): Int
    {
        // Create a mutable set to store the unique characters in the substring
        val charSet = mutableSetOf<Char>()
        // Initilaize the length of the longest substring to 0
        var maxLength = 0
        // Initialize the start index of the current substring to 0
        var i = 0

        // Loop over the indices of the characters in the string
        for (j in s.indices)
        {
            // If the current character is already in the set, remove the first character from the set
            // and move the start index of the substring forward
            while (charSet.contains(s[j]))
            {
                charSet.remove(s[i])
                i++
            }
            // Add the current character to the set
            charSet.add(s[j])
            // Update the length of the longest substring if the current substring is longer
            maxLength = maxOf(maxLength, j - i + 1)
        }
        // Return the length of the longest substring
        return maxLength
    }
}