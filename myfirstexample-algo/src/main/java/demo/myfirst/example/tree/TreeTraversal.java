package demo.myfirst.example.tree;

import java.util.ArrayList;
import java.util.Stack;

public class TreeTraversal {
    static class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static ArrayList<Integer> postOrder(Node root){
        ArrayList res= new ArrayList();
        Stack<Node> s= new Stack<>();
        if(root==null){
            return res;
        }
        s.push(root);
        Node prev=null;
        while(!s.isEmpty()){
            Node curr=s.peek();
            if((prev==null)||(prev.left==curr)||(prev.right==curr)){
                if(curr.left!=null){
                    s.push(curr.left);
                }
                if(curr.right!=null){
                    s.push(curr.right);
                }
            }else if(curr.left==prev){
                if(curr.right!=null){
                    s.push(curr.right);
                }
            }else{
                res.add(curr.data);
                System.out.printf(s.pop().data+"  ");
            }
            prev=curr;
        }
        return  res;
    }

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;

    postOrder(n1);

    }
}
