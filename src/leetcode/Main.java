package leetcode;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//456
		ListNode node1 = new ListNode(5, new ListNode(6, new ListNode(4)));
		
		//321
		ListNode node6 = new ListNode(3, new ListNode(2, new ListNode(1)));
		
		SolutionAddTwoNumbers sn = new SolutionAddTwoNumbers();
		ListNode res = sn.addTwoNumbers(node1, node6);
		
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
		
		//Most frequent elements on an array
		MostFrequentKElements mostFE = new MostFrequentKElements();
		String[] array = {"hola", "adios", "hola", "hola", "saludos", "adios","otro"};
		int k = 3;
		//deberia de imprimir hola y adios
		System.out.println(mostFE.mostFElements(array, k));
		System.out.println("-----con lambda-------");
		System.out.println(mostFE.mostFElementsLamda(array, k));
	}
}
