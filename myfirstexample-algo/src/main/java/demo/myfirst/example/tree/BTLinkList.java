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
    Node root;

    // head --> Pointer to head node of created doubly linked list
    Node head;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls

    static Node prev=null;
   public void convertToList(Node root){
        if(root==null){
            return;
        }

        convertToList(root.left);
        if(prev==null){
            head=root;
        }else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        convertToList(root.right);
   }



    public void print(Node root){
        while(root!=null){
            System.out.print(root.data+"-->");
            root= root.right;
        }
   }
    public static void main(String[] args) {
       BTLinkList btLinkList= new BTLinkList();
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
        btLinkList.root=n1;
//        Node head = null;
//        Node head=new Node(0);
        btLinkList.convertToList(n1);
        btLinkList.print(btLinkList.head);
    }
}
