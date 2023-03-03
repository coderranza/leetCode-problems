/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

 class ListNode(var `val`: Int)
 {
     var next: ListNode? = null
 }

class Solution 
{
    fun main()
    {
        val l1 = ListNode(2).apply {
            next = ListNode(4).apply {
                next = ListNode(3)
            }
        }

        val l2 = ListNode(5).apply {
            next = ListNode(6).apply {
                next = ListNode(4)
        }
    }

    val result = addTwoNumbers(l1, l2)

    // Print the result
    var curr = result
    while(curr != null){
        print("${curr.`val`}")
        curr = curr.next
    }

    }


    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? 
    {
        var carry = 0
        var p = l1
        var q = l2
        val dummy = ListNode(0)
        var curr = dummy

        while(p != null || q != null )
        {
            val x = p?.`val` ?: 0
            val y = q?.`val` ?: 0
            val sum = carry + x + y
            carry = sum / 10
            curr.next = ListNode(sum % 10)
            curr = curr.next!!
            p = p?.next
            q = q?.next
        }

        if (carry > 0)
        {
            curr.next = ListNode(carry)
        }

        return dummy.next
    }
}

