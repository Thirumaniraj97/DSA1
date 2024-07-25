package BinaryTree;

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

	public static void main(String[] args) {

	}
}
