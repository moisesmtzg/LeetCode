package leetcode;

public class RemoveNthNodeFromEndList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode targetNode = null;
        ListNode currNode = head;
        
        int i = 1;
        while(currNode.next != null) {
            if(i >= n) {
                targetNode = targetNode != null? targetNode.next : head;
            }
            currNode = currNode.next;
            i++;
        }
        
        if(targetNode == null) {
            targetNode = head.next;
            head = targetNode;
        } else {
            targetNode.next = targetNode.next.next;
        }
        
        	return head;
		}
}
