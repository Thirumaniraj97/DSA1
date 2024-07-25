package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode {
	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data; // Generic Type

		public TreeNode(int data) {
			this.data = data;
		}
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelNum = queue.size();

			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < levelNum; i++) {
				TreeNode temp = queue.peek();
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
				list.add(queue.poll().data);
			}
			result.add(list);

		}
		return result;

	}

	/*  Validate Binary Search Tree */
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	public boolean isValidBST(TreeNode root, long min, long max) {
		if(root == null){ //base case
			return true;
		}
		if(root.data <= min || root.data >= max){
			return false;
		}
		boolean left = isValidBST(root.left, min, root.data);
		if(left){
			boolean right = isValidBST(root.right, root.data, max);
			return right;
		}
		return false;
	}
	public static void main(String[] args) {
		LeetCode bst = new LeetCode();
		TreeNode root = bst.new TreeNode(10);
		root.left = bst.new TreeNode(5);
		root.right = bst.new TreeNode(15);
		root.left.left = bst.new TreeNode(3);
		root.left.right = bst.new TreeNode(7);
		root.right.left = bst.new TreeNode(13);
		root.right.right = bst.new TreeNode(18);
		root.left.left.left = bst.new TreeNode(1);
		root.left.right.left = bst.new TreeNode(6);
		root.right.left.right = bst.new TreeNode(14);
		root.right.right.right = bst.new TreeNode(20);
		System.out.println(bst.levelOrder(root));
		System.out.println(bst.isValidBST(root));
	}
}
