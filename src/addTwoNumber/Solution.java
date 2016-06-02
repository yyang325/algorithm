package addTwoNumber;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2, res = new ListNode(0), r = res;
        int sum = 0;
        
        while(c1 != null || c2 != null){
            sum /= 10;
            if(c1 != null){
                sum += c1.val;
                c1 = c1.next;
            }
            
            if(c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }
            
            r.next = new ListNode(sum%10);
            r = r.next;
        }
        if(sum > 9) r.next = new ListNode(sum/10);
        return res.next;
    }
}