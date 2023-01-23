// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
///
// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
//  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

fun main()
{
    val nums = intArrayOf(2,7,11,15)
    val target: Int = 9
    val result = twoSum(nums, target)
    println(result.contentToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray
{
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) 
        {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    throw IllegalArgumentException("No two sum solution")
}