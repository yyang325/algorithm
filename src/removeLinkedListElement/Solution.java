package removeLinkedListElement;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prehead = new ListNode(1);
        prehead.next = head;
        ListNode p = prehead;
        while(p.next != null){
            if(p.next.val == val){
                ListNode temp = p.next;
                p.next = temp.next;
                temp.next = null;
            }else{
                p = p.next;
            }
        }
        return prehead.next;
    }
}