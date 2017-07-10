package demo.myfirst.example.tree;

import java.util.LinkedList;
import java.util.Queue;
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
        Node temp=null;
        Queue<Node> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            temp=queue.poll();
            if(temp.left!=null){
                queue.offer(temp.left);
            }else {
                System.out.print("\t " + temp.data);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }else{
                System.out.print("\t " + temp.data);
            }
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

    public int findMaxIter(Node root){
        Node temp=null;
        if(root==null){
            return 0;
        }else{
            int max=Integer.MIN_VALUE;
            Queue queue= new LinkedList();
            queue.offer(root);
            while(!queue.isEmpty()){
                temp= (Node) queue.poll();
                if(max<temp.data){
                    max=temp.data;
                }
                if(temp.left!=null){
                 queue.offer(temp.left);
                }if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            return max;
        }
    }

    /*
    	-150	-5	0	12	15	20	25	100	126	200	1000
	[15]	[-5]	[-150]	[0]	[12]	[200]	[25]	[20]	[100]	[126]	[1000]
	[-150]	[12]	[0]	[-5]	[20]	[126]	[100]	[25]	[1000]	[200]	[15]RVERSE

5
MAX ELEMENT ITER1000

     */
    public Node addNodeNoNRecursive(Node root, int data){
        Node newNode= new Node(data);
        Node temp=null;
        if(root==null){
            root=newNode;

        }else{
         Queue queue= new LinkedList();
         queue.offer(root);
         while (!queue.isEmpty()){
             temp= (Node) queue.poll();
             if(data<temp.data) {
                 if (temp.left != null) {
                     queue.offer(temp.left);
                 } else {
                     temp.left = newNode;
//                     queue.poll();
                 }

             }if(data>temp.data) {
                 if (temp.right != null) {
                      queue.offer(temp.right);
                 } else {
                     temp.right = newNode;
//                     queue.poll();
                 }

             }

         }
//            queue.poll();

        }
        return root;

    }
    public int countTotalCompleteNode(Node root){
        int count=0;
        if(root==null){
            count=0;
        }else{
            Queue<Node> queue= new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                root=queue.poll();
                if(root.left!=null & root.right!=null){
                    count++;
                }if(root.left!=null){
                    queue.offer(root.left);
                }if(root.right!=null){
                    queue.offer(root.right);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode( );
        Node root= null;
                //new Node(20);
        int[] nums = {15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
        for(int i : nums ) {
//            root= tree.addNode( root,i);
            root=tree.addNodeNoNRecursive(root,i);

        }
        tree.inOrder(root);
        System.out.println();
        tree.inOrderIter(root);
        System.out.println();
        tree.preOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println("RVERSE");
        tree.reverse(root);
        System.out.println();
        System.out.println(tree.getHeight(root));
        System.out.println("MAX ELEMENT ITER \t"+tree.findMaxIter(root));
        System.out.println("Complete tree node "+tree.countTotalCompleteNode(root));
    }
}
