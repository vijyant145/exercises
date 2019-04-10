package bt;

import java.util.Arrays;

public class BTreeFromArray {

	public static TreeNode buildTree(int[] a) {
		TreeNode parent = new TreeNode();
		TreeNode root = new TreeNode(a[0]);
		TreeNode curr = null;
		int v;
		for (int i = 1; i < a.length; i++) {
			curr = root;
			v = a[i];
			while (curr != null) {
				if (v >= curr.data) {
					parent = curr;
					curr = curr.right;
				} else {
					parent = curr;
					curr = curr.left;
				}
			}
			// parent is leaf
			if (v >= parent.data) {
				parent.right = new TreeNode();
				parent.right.data = v;
			} else {
				parent.left = new TreeNode();
				parent.left.data = v;
			}
		}
		return root;
	}

	public static void print(TreeNode root) {
		if (root == null)
			return;

		print(root.left);
		System.out.print(root.data + " ");
		print(root.right);

	}

	///other method

	public TreeNode insert(TreeNode node, int value) {
		if (node == null)
			// Create a leaf.
			// It might be the root...
			return new TreeNode(value);

		// It's occupied, see which way to
		// go based on it's value

		// right? ...
		if (value > node.data)
			node.right = insert(node.right, value);

		// or left?
		else if (value < node.data)
			node.left = insert(node.left, value);

		// Code is not handling dups.
		return node;
	}
	
	
	// from sorted array
	// Function to construct balanced BST from given sorted array
		public static TreeNode convert(int[] keys, int low, int high, TreeNode root){
			// base case
			if (low > high) {
				return root;
			}

			// find middle element of current range
			int mid = (low + high) / 2;

			// construct a new node from mid element and assign it to root
			root = new TreeNode(keys[mid]);

			// left subtree of root will be formed by keys less than mid element
			root.left = convert(keys, low, mid - 1, root.left);

			// right subtree of root will be formed by keys less than mid element
			root.right = convert(keys, mid + 1, high, root.right);

			return root;
		}

		// Function to construct balanced BST from given unsorted array
		public static TreeNode convert(int[] keys){
			// sort the keys first
			Arrays.sort(keys);

			// construct balanced BST and
			// return root node of the tree
			return convert(keys, 0, keys.length - 1, null);
		}
		
		public static void main(String[] args) {
			int[] data = { 50, 30, 60, 10, 80, 55, 40 };
			TreeNode root = buildTree(data);
			print(root);
			
			System.out.println("----------");
			// input keys
			int[] keys = { 15, 10, 20, 8,8,8,8, 12, 16, 25,30 };

			// construct balanced binary search tree
			TreeNode rootSorted = convert(keys);
			print(rootSorted);
		}

}
