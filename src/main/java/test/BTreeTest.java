package test;

import java.util.ArrayList;

public class BTreeTest {
	public static Integer last = null;
	
	public static boolean isSorted(Node root) {
	    ArrayList<Integer> values = new ArrayList<Integer>();
	    performInorderTraversal(root, values);
	    
	    System.out.println(values);
	    return isArraySorted(values);
	}

	private static void performInorderTraversal(Node root, ArrayList<Integer> result) {
	    /* An empty tree has no values. */
	    if (root == null) return;

	    /* Process the first tree here, then loop, processing the interleaved
	     * keys and trees.
	     */
	    performInorderTraversal(!root.children.isEmpty()?root.children.get(0):null, result);
	    for (int i = 0; i < root.keys.size(); i++) {
	        result.add(root.keys.get(i));
	        performInorderTraversal(!root.children.isEmpty()?root.children.get(i+1):null, result);
	    }
	}

	private static boolean isArraySorted(ArrayList<Integer> array) {
	    for (int i = 0; i < array.size() - 1; i++) {
	        if (array.get(i) >= array.get(i + 1)) return false;
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		Node valid = getValidTree();
		System.out.println(isSorted(valid));
		
		Node inValid = getInvalidValidTree();
		System.out.println(isSorted(inValid));
		
		Node inValid2 = getInvalidValidTree2();
		System.out.println(isSorted(inValid2));
		
		System.out.println("-------------------");
		System.out.println(check(valid ));
		last = null;
		System.out.println("invalid1");
		System.out.println(check(inValid));
		System.out.println("invalid2");
		last = null;
		System.out.println(check(inValid2));
		System.out.println("-------------------");
	}
	
	public static Node getValidTree() {
		
		Node root = new Node();
		root.keys.add(13);
		
		Node firstChild1 = new Node();
		firstChild1.keys.add(4);
		firstChild1.keys.add(7);
		root.children.add(firstChild1);
		
		firstChild1.children.add(getChild(1,3));
		firstChild1.children.add(getChild(5,6));
		firstChild1.children.add(getChild(8,10,11));
		
		Node firstChild2 = new Node();
		firstChild2.keys.add(17);
		firstChild2.keys.add(24);
		root.children.add(firstChild2);
		
		firstChild2.children.add(getChild(14,16));
		firstChild2.children.add(getChild(18,20));
		firstChild2.children.add(getChild(25,30,31,35));
		
		
		
		return root;
		
	}
	
	public static Node getChild(Integer ...key) {
		Node child = new Node();
		for (int i = 0; i < key.length; i++) {
			child.keys.add(key[i]);
		}
		return child;
	}
	
	
public static Node getInvalidValidTree() {
		
		Node root = new Node();
		root.keys.add(13);
		
		Node firstChild1 = new Node();
		firstChild1.keys.add(4);
		firstChild1.keys.add(7);
		root.children.add(firstChild1);
		
		firstChild1.children.add(getChild(1,3));
		firstChild1.children.add(getChild(5,6));
		firstChild1.children.add(getChild(8,10,15));
		
		Node firstChild2 = new Node();
		firstChild2.keys.add(17);
		firstChild2.keys.add(24);
		root.children.add(firstChild2);
		
		firstChild2.children.add(getChild(14,16));
		firstChild2.children.add(getChild(18,20));
		firstChild2.children.add(getChild(25,30,31,35));
		
		
		
		return root;
		
	}

public static Node getInvalidValidTree2() {
	
	Node root = new Node();
	root.keys.add(13);
	
	Node firstChild1 = new Node();
	firstChild1.keys.add(4);
	firstChild1.keys.add(9);
	root.children.add(firstChild1);
	
	firstChild1.children.add(getChild(1,3));
	firstChild1.children.add(getChild(5,6));
	firstChild1.children.add(getChild(8,10,11));
	
	Node firstChild2 = new Node();
	firstChild2.keys.add(17);
	firstChild2.keys.add(24);
	root.children.add(firstChild2);
	
	firstChild2.children.add(getChild(14,16));
	firstChild2.children.add(getChild(18,20));
	firstChild2.children.add(getChild(25,30,31,35));
	
	
	
	return root;
	
}



private static boolean check(Node root) {
	boolean flag = true;
    /* An empty tree has no values. */
    if (root == null) return true;

    /* Process the first tree here, then loop, processing the interleaved
     * keys and trees.
     */
    if(!check(!root.children.isEmpty()?root.children.get(0):null)) return false;
    for (int i = 0; i < root.keys.size(); i++) {
    	if(last !=null && last > root.keys.get(i)) {
    		flag = false;  
    		System.out.print(flag);
    		return false;
    		//return flag;
    	}
    	last = root.keys.get(i);
    	System.out.print(" "+root.keys.get(i));
        if(!check(!root.children.isEmpty()?root.children.get(i+1):null))return false;
    }
    return true;
}

}
