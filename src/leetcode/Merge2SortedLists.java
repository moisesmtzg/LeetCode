package leetcode;

public class Merge2SortedLists {

	public ListNode mergeTwoList(ListNode l1, ListNode l2) {

		if(l1 == null && l2 != null) return l2;
		if(l2 == null && l1 != null) return l1;

		ListNode aux = new ListNode(20);
		ListNode res = aux;
		while(l1 != null && l2 != null) {
			aux.next = new ListNode();
			if(l1.val > l2.val) {
				aux.val = l2.val;
				l2 = l2.next;
			}else {
				aux.val = l1.val;
				l1 = l1.next;
			}
			aux = aux.next;
		}

		while(l1 != null) {
			aux.next = new ListNode();
			aux.val = l1.val;
			l1 = l1.next;
			aux = aux.next;
		}

		while(l2 != null) {
			aux.next = new ListNode();
			aux.val = l2.val;
			l2 = l2.next;
			aux = aux.next;
		}
		return res;
	}
}
