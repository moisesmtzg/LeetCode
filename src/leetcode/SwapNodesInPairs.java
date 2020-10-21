package leetcode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode actual = head;
		ListNode temp = null;
		while(actual.next != null) {
			//nodo siguiente
			temp = actual.next;
			if(temp.next != null) {
				//head
				ListNode aux = actual;
				//nuevo nodo siguiente
				actual = temp;
				
				//nuevo head
				temp = aux;
				temp.next = actual;
			}
			temp = actual.next;
		}
		return actual;
	}
}
