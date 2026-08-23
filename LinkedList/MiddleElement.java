class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null){
            if(fast.next.next == null ) return slow.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}