/*
Input: nums1 = [1,3], nums2 = [2]
Output: 2.000
Explanation: merged array = [1,2,3]d and median is 2
*/

import kotlin.math.max
import kotlin.math.min

class SolutionMedian
{

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double
    {
        // Get the sizes of the input arrays
        val m = nums1.size
        val n = nums2.size

        // Ensure that nums1 is the smaller array
        if (m > n)
        {
            return findMedianSortedArrays(nums2, nums1)
        }

        // Initialize pointers to the first and last indices of nums1
        var left = 0
        var right = m

        // Iterate until a valid partition is found
        while (left <= right)
        {
            // Calculate the partition indices for nums1 and nums2
            val partitionX = (left + right) / 2
            val partitionY = (m + n + 1) / 2 - partitionX

            // // Calculate the maximum and minimum values of the four elements that border the two partitions
            val maxLeftX = if (partitionX == 0) Int.MIN_VALUE else nums1[partitionX - 1]
            val minRightX = if (partitionX == m) Int.MAX_VALUE else nums1[partitionX]
            val maxLeftY = if (partitionY == 0) Int.MIN_VALUE else nums2[partitionY - 1]
            val minRightY = if (partitionY == n) Int.MAX_VALUE else nums2[partitionY]

            // Check whether the current partition is valid
            if (maxLeftX <= minRightY && maxLeftY <= minRightX)
            {
                // Calculate the median of the two input arrays
                return if ((m + n) % 2 == 0)
                {
                    // If the sum of the sizes of the two input is even, return the average of the maximum values of the left halves and
                    // the minium values of the right halves
                    (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2.0
                }
                else
                {
                    // If the sum of the sizes of the two input arrays is odd, return the maximum value of the left halves
                    max(maxLeftX, maxLeftY).toDouble()
                }
            }
            else if (maxLeftX > minRightY)
            {
                // If maxLeftX is greater than minRightY, move the partition to the left
                right = partitionX - 1
            }
            else
            {
                // If maxLeftY is greater than minRightX, move the partition to the right
                left = partitionX + 1
            }
        }
        throw IllegalArgumentException()
    }
}