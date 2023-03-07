// Example:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
//  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

class SolutionTwoSum
{
    fun main()
    {
        val nums = intArrayOf(2,7,11,15)
        val target: Int = 9
        val result = twoSum(nums, target)
        println(result.contentToString())
    }

    // Function that takes an array of integers and an integer as arguments and returns and array of integers
    // containing the indices of the two numbers that sum to `target`.
    fun twoSum(nums: IntArray, target: Int): IntArray
    {
        // Mutable map that will have the values in `nums` as keys and their corresponding indices as values.
        val map = HashMap<Int, Int>()

        // Iterate through the indices of `nums`
        for (i in nums.indices) {

            // Calculate the complement of `target` and the current element `nums[i]`
            val complement = target - nums[i]

            // Check if `map` contains `complement` as a key.
            // If it does, we return an integer array containing the indices of the two elements
            // that sum to `target`, `map[complement]` and `i`.
            if (map.containsKey(complement)) 
            {
                return intArrayOf(map[complement]!!, i)
            }

            // If `complement` is not in `map`, add the current element and its corresponding index to `map`.
            map[nums[i]] = i
        }
        throw IllegalArgumentException("No two sum solution")
    }
}