package demo.myfirst.example.tree;

import java.util.Stack;

/**
 * Created by anya on 19/6/17.
 */
public class BinaryTreeNode {
    static class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }

    }

    Node addNode(Node root, int data){
        if(root==null){
            root=new Node(data);
        }else{
            if(data<root.data){
              if(root.left!=null) {
                  addNode(root.left, data);
              }else{
                  root.left=new Node(data);
              }
            }if(data>root.data){
                if(root.right!=null){
                    addNode(root.right,data);
                }else{
                    root.right=new Node(data);
                }
            }
        }
        return root;
    }

    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print("\t"+root.data);
            inOrder(root.right);
        }
    }

    public void inOrderIter(Node root){
        Node currnetNode=null;
        Stack<Node> stack= new Stack<>();
        if(root!=null){
            currnetNode=root;
            stack.push(currnetNode);

        }
    }

    public void preOrder(Node root){
        if(root!=null){
            System.out.print("\t["+root.data+"]");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print("\t["+root.data+"]");
        }
    }

    public void reverse(Node root){
        if(root==null){
            return;
        }
        Node temp=root.right;
        root.right=root.left;
        root.left=temp;
        if(root.left!=null){
            reverse(root.left);
        }
        if(root.right!=null){
            reverse(root.left);
        }
    }

    public int getHeight(Node root){
        if (root==null){
            return 0;
        }
        return 1+Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode( );
        Node root= null;
                //new Node(20);
        int[] nums = {15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
        for(int i : nums ) {
            root= tree.addNode( root,i);

        }
        tree.inOrder(root);
        System.out.println();
        tree.preOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println("RVERSE");
        tree.reverse(root);
        System.out.println();
        System.out.println(tree.getHeight(root));
    }
}
