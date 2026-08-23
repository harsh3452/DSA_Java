public ListNode reverseDLL(ListNode head) {
    ListNode temp = head;
    while(temp!=null){
    ListNode last = temp.prev;
    temp.prev = temp.next;
    temp.next = last;
    head = temp;
    temp = temp.prev;
    }
    return head;
}
