package questoins;

import java.util.*;

/**
 * FULL REPO ADDRESS: https://github.com/hmny/interviewPrep/blob/LintCode/LintCodeSolutions/src/questoins/Puzzle_007.java
 * 1- bfs search
 * 2- dfs search
 * for the following tree
 */

/*
  3
 / \
9  20
  /  \
 15   7
 */

public class Puzzle_007 {

    /**
     * this method creates the tree which is shown above and returns the root of that tree
     */
    public TreeNode createSampleTree() {
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        return root;
    }

    /**
     * returns the left child if not visited, then right child if not visited
     */
    private TreeNode getUnvisitedChildNode(TreeNode node) {
        if (node.left != null) {
            if (!node.left.visited) {
                return node.left;
            }
        }
        if (node.right != null) {
            if (!node.right.visited) {
                return  node.right;
            }
        }
        return null;
    }

    public void serialize_using_bfs(TreeNode root) {
        // BFS uses Queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.println(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();  // remove the head of queue
            TreeNode child = null;
            while ((child = getUnvisitedChildNode(node)) != null) {
                child.visited = true;
                System.out.println(child.val);
                queue.add(child);
            }
        }
    }

    public void serialize_using_dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        root.visited = true;
        System.out.println(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();   // top of the stack without removing
            TreeNode child = getUnvisitedChildNode(node);
            if(child != null) {
                child.visited = true;
                System.out.println(child.val);
                stack.push(child);
            } else {
                stack.pop();
            }
        }
    }

    private class TreeNode {
        private int val;
        private TreeNode left, right;
        private boolean visited;
        private TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

    }
}