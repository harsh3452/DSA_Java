class Solution {
    public ListNode addOne(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head);
        ListNode temp = newHead;
        int carry = 1;
        ListNode prev = null;
        while(temp!=null){
            int sum = temp.val + carry;
            carry = sum/10;
            temp.val = sum%10;
            prev = temp;
            temp = temp.next;
        }
        if(carry>0){
            prev.next = new ListNode(carry);
        }
        return reverseList(newHead);
    }
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}

/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public ListNode addOne(ListNode head) {
        int carry = helper(head.next);
        if(carry==1){
            ListNode newHead = new ListNode(1,head);
            return newHead;
        }
        return head;
    }
    public int helper(ListNode temp){
        if(temp == null) return 1;
        int carry = helper(temp.next);
        temp.val = temp.val + carry;
        if(temp.val < 10)
        {
            return 0;
        } 
        else {
            temp.val = 0;
            return 1;
        }
    }
}
//recursion based code and we are backtracking the carry instead of reversing.