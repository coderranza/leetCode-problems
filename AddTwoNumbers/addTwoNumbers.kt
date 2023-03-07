/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

 // This bloc of code defines a class `ListNode` that represent a node in a linked list.
 // Each `ListNode` object contains an integer value `value` and a reference to the next node in the list,
 // which is initially null
 class ListNode(var `val`: Int)
 {
     var next: ListNode? = null
 }

class SolutionTwoNumbers 
{
    // Test
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

    // This is the function signature for `addTwoNumbers`, which takes in two parameters `l1` and `l2`,
    // each of which represents a linked list.
    // The function returns another linked list.
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? 
    {
        // carry - represents the carryover value when adding two digits.
        var carry = 0
        // p & q - references to the current nodes being proccesed in `l1` and `l2`, respectively.
        var p = l1
        var q = l2
        // dummy - node that we use to simplify the process of creating the result linked list.
        val dummy = ListNode(0)
        // curr - reference to the current node being processed in the result linked list.
        var curr = dummy

        // loop that continues until we have processed all the nodes in both input linked lists.
        while(p != null || q != null )
        {
            // x & y - integer values of the current nodes in `l1` and `l2`, respectively.
            val x = p?.`val` ?: 0
            val y = q?.`val` ?: 0

            // sum of `x`, `y` and `carry`. If `carry` is nonzero, it means we had a carryover from the previous step.
            val sum = carry + x + y

            // Compute the new value of `carry` by dividing `sum` by 10 (which give us the carryover for the next step).
            carry = sum / 10

            // Create a new node in the result list with a value equal to `sum` modulo 10
            // Append this new node to the end of the current result list
            curr.next = ListNode(sum % 10)

            // Update `curr` to point to the new node we just added.
            curr = curr.next!!

            // Move to the next nodes in `li` and `l2`.
            p = p?.next
            q = q?.next
        }

        // Handles the case where we have a carryover value after processing all the nodes in `l1` and `l2`.
        if (carry > 0)
        {
            curr.next = ListNode(carry)
        }

        return dummy.next
    }
}

