package removeNthNodeFromEndOfList;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 	For example,
 * 		Given linked list: 1->2->3->4->5, and n = 2.
 * 		After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * @author Yang
 */

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(n < 1) return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode fast = head;
        
        while(n > 0){
            if(fast == null) return head;
            fast = fast.next;
            n--;
        }
        
        ListNode slow = prehead;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode temp = slow.next;
        slow.next = temp.next;
        temp.next = null;
        
        return prehead.next;
    }
}