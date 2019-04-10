package linkedlist;



public class LinkedListQuestion {
	
	public static class LNode{
		public int data;
		public LNode next;
		public LNode(int val) {
			this.data = val;
			this.next = null;
		}
	}
	
	public static LNode findKthfromLast(LNode root, int k) {
		
		LNode first = root;
		LNode second = root;
		
		for(int i =0; i< k; i++) {
			second = second.next;
		}
		
		while ( second !=null) {
			first = first.next;
			second = second.next;
		}
		return first;
	}
	
	public static boolean isLoop(LNode root) {
		if(root == null ) return false;
		LNode first = root;
		LNode second = root;
		
		while(first!=null && second !=null && first != second) {
			first = first.next;
			second = second.next.next;
		}
		
		return first == second;
	}
	
	public static void main(String[] args) {
		
		LNode root = new LNode(1);
		root.next = new LNode(2);
		root.next.next = new LNode(3);
		root.next.next.next = new LNode(4);
		
		System.out.println(findKthfromLast(root, 2).data);
		
		root.next.next.next = root.next.next;
		
		System.out.println("  is loop ="+ isLoop(root) );
	}

}
