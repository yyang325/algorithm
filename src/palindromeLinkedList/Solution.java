package palindromeLinkedList;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head, slow = head;
    
        /** find middle element */
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        /** when the length is even */
        if(fast != null) slow = slow.next;
    
        /** reverse the second half */
        ListNode prev = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
    
        /** compare the first and second half */
        slow = prev;
        while(slow != null) {
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    
    public static void main(String[] a){
    	Solution f = new Solution();
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	
    	System.out.println(f.isPalindrome(n1));
    }
}