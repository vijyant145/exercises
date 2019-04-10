package bt;

public class SumTree {
	
	public static boolean checkSum(BNode root) {
		//empty
		if(root == null )return true;
		//leaf
		if(root.left == null && root.right==null )return true;
		
		// post order traversal
		int left = sumTree(root.left);
		int right = sumTree(root.right);
		return (root.data == left+right) && checkSum(root.left) && checkSum(root.right);
	}
	
	public static int sumTree(BNode root) {
		
		if (root == null) return 0;
		
		return sumTree(root.left)+sumTree(root.right)+root.data;
	}

	
	public static void main(String[] args) {
		BNode invalid = inValidSumTree();
		BNode valid = validSumTree();
		System.out.println(checkSum(invalid));
		System.out.println("--------Valid below ---------");
		System.out.println(checkSum(valid));
		
		System.out.println("--------O(N)---------");
		System.out.println(isSumTree(invalid));
		System.out.println("--------Valid below ---------");
		System.out.println(isSumTree(valid));
		
	}
	
	public static BNode inValidSumTree() {
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
	
	public static BNode validSumTree() {
		BNode root = new BNode(26);
		BNode left = new BNode(10);
		BNode right = new BNode(3);
		
		root.left = left;
		root.right = right;
		
		root.left.left = new BNode(4);
		root.left.right = new BNode(6);
		
		root.right.left = new BNode(1);
		root.right.right = new BNode(2);
		
		
		return root;
		
	}
	
	public static void print(BNode root) {
		if(root == null)return;
		
		print(root.left);
		print(root.right);
		System.out.print(root.data +" ");
		
	}
	
	public static boolean isLeaf(BNode node) { 
        
		if (node == null) return false; 
        
        if (node.left == null && node.right == null) return true; 
        
        return false; 
    } 
   
    /* returns true if SumTree property holds for the given 
       tree */
    public static boolean isSumTree(BNode node)  { 
        int ls; // for sum of nodes in left subtree 
        int rs; // for sum of nodes in right subtree 
   
        /* If node is NULL or it's a leaf node then 
         return true */
        if (node == null || isLeaf(node) ) return true; 
        
   
        if (isSumTree(node.left)  && isSumTree(node.right) ) { 
            // Get the sum of nodes in left subtree 
            if (node.left == null) 
                ls = 0; 
            else if (isLeaf(node.left)) 
                ls = node.left.data; 
            else
                ls = 2 * (node.left.data); 
   
            // Get the sum of nodes in right subtree 
            if (node.right == null) 
                rs = 0; 
            else if (isLeaf(node.right) ) 
                rs = node.right.data; 
            else
                rs = 2 * (node.right.data); 
               
            /* If root's data is equal to sum of nodes in left 
               and right subtrees then return 1 else return 0*/
            if ((node.data == rs + ls)) 
                return true; 
            else
                return false; 
        } 
   
        return false; 
    } 
}
