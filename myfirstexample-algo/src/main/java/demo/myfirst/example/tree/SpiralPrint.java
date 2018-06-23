package demo.myfirst.example.tree;

import java.util.Stack;

public class SpiralPrint {
    static class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    Node root;

    public void printSpiral(Node root){
        Stack<Node> stack1= new Stack();
        Stack<Node> stack2= new Stack<>();
        if(root==null){
            return;
        }
        if(root!=null){
            stack1.push(root);
            while (!stack1.isEmpty() || !stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    Node temp=stack1.pop();
                    System.out.print(temp.data+"-->");
                    if(temp.right!=null){
                        stack2.push(temp.right);
                    }
                    if(temp.left!=null){
                        stack2.push(temp.left);
                    }

                }
                while (!stack2.isEmpty()){
                    Node temp=stack2.pop();
                    System.out.print(temp.data+"-->");
                    if(temp.left!=null){
                        stack1.push(temp.left);
                    }
                    if(temp.right!=null){
                        stack1.push(temp.right);
                    }

                }


            }
        }
    }

    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n6= new Node(6);
        Node n7= new Node(7);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        SpiralPrint spiralPrint= new SpiralPrint();
        spiralPrint.root=n1;
        spiralPrint.printSpiral(n1);
    }
}
