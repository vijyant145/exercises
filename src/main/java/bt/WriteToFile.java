package bt;

import java.util.ArrayList;
import java.util.List;

public class WriteToFile {
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
		
		System.out.print(root.data +" ");
		print(root.left);
		print(root.right);
		
	}
	
	public static List<Integer> writeBTree(BNode root) {
		List<Integer> list = new ArrayList<>();
		write(root, list);
		System.out.println(list);
		return list;
		
	}
	
	public static void write(BNode root, List<Integer> list) {
		if(root == null) {
			list.add(Integer.MIN_VALUE);
			return;
		}else{
			list.add(root.data);
		}
		
		write(root.left,list);
		write(root.right, list);
				
	}
	
	public static void main(String[] args) {
		BNode root = createBTree();
		List<Integer> list =writeBTree(root);
		print(root);
		
		System.out.println();
		System.out.println("-------------");
		BNode afterRead = readTree(list);
		
		print(afterRead);
		
	}
	
	public static BNode readTree(List<Integer> list) {
		BNode root = read( list);
		return root;
	}
	public static BNode read(List<Integer> list) {
		
		if(list.isEmpty())return null;
		
		Integer val = list.remove(0);
		
		if(val == Integer.MIN_VALUE) {
			return null;
		}
		
		BNode root = new BNode(val);
		root.left = read(list);;
		root.right =read(list);;
		return root;
	}

}
