package demo.myfirst.example.tree;

public class BTLinkList {
    static class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
   }

    static Node prev=null;
   public static void convertToList(Node root, Node head){
        if(root==null){
            return;
        }

        convertToList(root.left,head);
        if(prev==null){
            head=root;
        }else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        convertToList(root.right,head);
   }

   public static void print(Node root){
        while(root!=null){
            System.out.print(root.data);
            root= root.right;
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

        Node head=new Node(0);
        convertToList(n1,head);
        print(head);
    }
}
