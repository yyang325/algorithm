package reorderList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        
        while(head != null && head2 != null){
            ListNode temp = head.next;
            head.next = head2;
            ListNode temp2 = head2.next;
            head2.next = temp;
            head2 = temp2;
            head = temp;
        }
    }
    
    public ListNode reverse(ListNode head){
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        while(head != null && head.next != null){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = prehead.next;
            prehead.next = temp;
        }
        return prehead.next;
    }
}