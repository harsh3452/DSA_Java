class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null ) return head;
        ListNode temp = head;
        ListNode newHead = null;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        k = k % count;
        if(k == 0){
            return head;
        }
        int index = count - k;
        count = 1;
        temp = head;
        while(temp!= null){
            if(count == index){
                newHead = temp.next;
                temp.next = null;
                break;
            }
            count++;
            temp = temp.next;
        }
        temp = newHead;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;

    }
}