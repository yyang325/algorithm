package addTwoNumbers;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p = head;
        int carry = 0;
        
        while(p1 != null && p2 != null){
            int temp = p1.val + p2.val + carry;
            carry = temp / 10;
            p.next = new ListNode(temp % 10);
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        } 
        
        while(p1 != null){
            int temp = p1.val + carry;
            carry = temp / 10;
            p.next = new ListNode(temp % 10);
            p = p.next;
            p1 = p1.next;
        }
        
        while(p2 != null){
            int temp = p2.val + carry;
            carry = temp / 10;
            p.next = new ListNode(temp % 10);
            p = p.next;
            p2 = p2.next;
        }
        
        if(carry > 0){
            p.next = new ListNode(carry);
        }
        
        return head.next;
    }
}