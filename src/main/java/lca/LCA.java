package lca;

import bt.BNode;

public class LCA {

	public static BNode findLCA(BNode node, int n1, int n2) {
		// Base case
		if (node == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (node.data == n1 || node.data == n2)
			return node;

		// Look for keys in left and right subtrees
		BNode leftLca = findLCA(node.left, n1, n2);
		BNode rightLca = findLCA(node.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (leftLca != null && rightLca != null)
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (leftLca != null) ? leftLca : rightLca;
	}

	public static int findLevel(BNode root, int a, int level) {
		if (root == null)
			return -1;
		if (root.data == a)
			return level;
		int left = findLevel(root.left, a, level + 1);
		if (left == -1)
			return findLevel(root.right, a, level + 1);
		return left;
	}

	// O(n)
	public static int findDistance(BNode root, int a, int b) {
		BNode lca = findLCA(root, a, b);

		int d1 = findLevel(lca, a, 0);
		int d2 = findLevel(lca, b, 0);

		return d1 + d2;
	}
	
	public static int findDistance2(BNode root, int a, int b) {
		BNode lca = lcaIterative(root, a, b);

		int d1 = findLevel(lca, a, 0);
		int d2 = findLevel(lca, b, 0);

		return d1 + d2;
	}
	/**
	 *          1
	 *        /  \
	 *       2    3
	 *      /\    /\
	 *     4  5  6  7
	 *       
	 * */

	public static void main(String args[]) {
		BNode root = new BNode(4);
		root.left = new BNode(2);
		root.right = new BNode(6);
		root.left.left = new BNode(1);
		root.left.right = new BNode(3);
		root.right.left = new BNode(5);
		root.right.right = new BNode(7);
		System.out.println("LCA(4, 5) = " + findLCA(root, 4, 5).data);
		System.out.println("itr LCA(4, 5) = " + lcaIterative(root, 4, 5).data);
		System.out.println("LCA(4, 6) = " + findLCA(root, 4, 6).data);
		System.out.println("itr LCA(4, 6) = " + lcaIterative(root, 4, 6).data);
		System.out.println("LCA(3, 4) = " + findLCA(root, 3, 4).data);
		System.out.println("itr LCA(3, 4) = " + lcaIterative(root, 3, 4).data);
		System.out.println("LCA(2, 4) = " + findLCA(root, 2, 4).data);
		System.out.println("itr LCA(2, 4) = " + lcaIterative(root, 2, 4).data);
		
		System.out.println("itr LCA(2, 9) = " + lcaIterative(root, 2, 9).data);

		BNode root2 = new BNode(4);
		root2.left = new BNode(2);
		root2.right = new BNode(6);
		root2.left.left = new BNode(1);
		root2.left.right = new BNode(3);
		root2.right.left = new BNode(5);
		root2.right.right = new BNode(7);
		root2.right.right.right = new BNode(8);
		System.out.println("-----------------------------------------------");
		System.out.println("Dist (4, 5) = " + findDistance(root2, 4, 5));
		System.out.println("Dist itr (4, 5) = " + findDistance2(root2, 4, 5));

		System.out.println("Dist(4, 6) = " + findDistance(root2, 4, 6));
		System.out.println("Dist itr (4, 6) = " + findDistance2(root2, 4, 6));

		System.out.println("Dist(3, 4) = " + findDistance(root2, 3, 4));
		System.out.println("Dist itr(3, 4) = " + findDistance2(root2, 3, 4));

		System.out.println("Dist(2, 4) = " + findDistance(root2, 2, 4));
		System.out.println("Dist itr(2, 4) = " + findDistance2(root2, 2, 4));

		System.out.println("Dist(8, 5) = " + findDistance(root2, 8, 5));
		System.out.println("Dist itr(8, 5) = " + findDistance2(root2, 8, 5));

	}
	/**
	 *          4
	 *        /   \
	 *       2     6
	 *      /\     /\
	 *     1  3   5  7
	 *       
	 * */

	// O(h)
	public static BNode lcaIterative(BNode root, int n1, int n2) {
		while (root != null) {
			// If both n1 and n2 are smaller than root, then LCA lies in left
			if (root.data > n1 && root.data > n2)
				root = root.left;

			// If both n1 and n2 are greater than root, then LCA lies in right
			else if (root.data < n1 && root.data < n2)
				root = root.right;

			else
				break;
		}
		return root;

	}

}
