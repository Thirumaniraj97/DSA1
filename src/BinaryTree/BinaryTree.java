package BinaryTree;

import java.util.*;

public class BinaryTree {

	private TreeNode root;

	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data; // Generic Type

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public void createBinaryTree() {
		TreeNode first = new TreeNode(9);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);

		root = first;
		first.left = second;
		first.right = third; // second <-- first --> third

		second.left = fourth;

	}

	public void preOrder(TreeNode root) {
		if (root == null) { //base condition
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void iterativePreOrder() {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}

		}
	}

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public void iterativeInOrder() {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}

	public void postOrder(TreeNode root) {
		if (root == null) { //base case
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public void iterativePostOrder() {
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				TreeNode temp = stack.peek().right;
				if (temp == null) {
					temp = stack.pop();
					System.out.print(temp.data + " ");
					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						System.out.println(temp.data + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

	public void levelOrder() {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
		}
	}

	public int findMax(TreeNode root) {
		if (root == null) { //base case
			return Integer.MIN_VALUE;
		}
		int result = root.data;
		int left = findMax(root.left);
		int right = findMax(root.right);
		if (left > result) {
			result = left;
		}
		if (right > result) {
			result = right;
		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree();
		//PreOrder
		bt.preOrder(bt.root);
		System.out.println();

		bt.iterativePreOrder();
		System.out.println();

		//InOrder
		bt.inOrder(bt.root);
		System.out.println();

		bt.iterativeInOrder();
		System.out.println();

		//PostOrder
		bt.postOrder(bt.root);
		System.out.println();

		bt.iterativePostOrder();
		System.out.println();

		//LevelOrder
		bt.levelOrder();
		System.out.println();
		System.out.println("Max value: " + bt.findMax(bt.root));

	}
}
