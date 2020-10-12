package leetcode;

public class SolutionAddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
        ListNode test = new ListNode(0);
        ListNode aux1 = l1, aux2 = l2, finalList = test;
        
        while(aux1 != null || aux2 != null){
            
            int x = (aux1 != null)? aux1.val:0;
            int y = (aux2 != null)? aux2.val:0;
            int sum = carry + x + y;
            carry = sum/10;
            finalList.next = new ListNode(sum%10);
            finalList = finalList.next;
            if(aux1 != null) aux1= aux1.next;
            if(aux2 != null) aux2= aux2.next;
            
        }
        
        if(carry > 0){
            finalList.next = new ListNode(carry);
        }
        
        return test.next;	
    }
}
