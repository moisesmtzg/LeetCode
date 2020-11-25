package leetcode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode result = new ListNode(0, head);
        ListNode curr = result.next; // 1
        ListNode prev = result; // 0

        while (curr != null && curr.next != null) {
            ListNode next = curr.next; 
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            curr = curr.next;
            prev = prev.next.next;
            System.out.println(result);
        }

        return result.next;
	}
}
