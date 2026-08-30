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