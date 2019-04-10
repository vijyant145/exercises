package bt;

public class BTreeToDLL {
	
	
	// b tree to doubly linked list,
	// requires in order traversal
	public static BNode convert(BNode node) {
		
		if(node == null)return null;
		
		BNode left = convert(node.left);
		BNode right =convert(node.right);

		if(left !=null) {
			concat(getTail(left), node);
		}
		
		if(right !=null) {
			concat(node, right);
		}
		return left==null?node:left;
	}
	
	public static void concat(BNode one, BNode two) {
		one.right = two;
		two.left = one; 
	}
	
	public static BNode getTail(BNode node) {
		if(node == null ) return null;
		
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	
	public static BNode createBTree() {
		BNode root = new BNode(10);
		BNode left = new BNode(12);
		BNode right = new BNode(15);
		
		root.left = left;
		root.right = right;
		
		root.left.left = new BNode(25);
		root.left.right = new BNode(30);
		
		root.right.left = new BNode(36);
		
		
		return root;
		
	}
	
	public static void print(BNode root) {
		if(root == null)return;
		
		print(root.left);
		System.out.print(root.data +" ");
		print(root.right);
		
	}
	public static void  printDLL(BNode node) {
		if(node == null ) return ;
		
		while(node.right != null) {
			System.out.print(node.data+"|");
			node = node.right;
		}
		System.out.print(node.data+"|");
	}
	
	public static void main(String[] args) {
		BNode root = createBTree();
		print(root);
		BNode dll= convert(root);
		System.out.println();
		printDLL(dll);
	}

}


