class Solution {
    public int findLengthOfLoop(ListNode head) {
        if(head == null  || head.next == null){
            return 0;
        }
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast)){
                count = 1;
                fast = slow.next;
                while(fast != slow){
                    fast = fast.next;
                    count++;
                }
                return count;
            }
        }
        return count;
    }
}