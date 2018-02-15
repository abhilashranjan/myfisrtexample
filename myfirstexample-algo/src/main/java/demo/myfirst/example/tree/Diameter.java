package demo.myfirst.example.tree;

public class Diameter {
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

    public static int height(Node root){
        int lHeight=0;
        int rHeight=0;
        if(root==null){
            return 0;
        }
        lHeight=height(root.left);
        rHeight=height(root.right);
        return (lHeight>rHeight?lHeight+1:rHeight+1);
    }

    public static int diameter(Node root){
        int left, right,dim=0;
        if(root==null){
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        left=diameter(root.left);
        right=diameter(root.right);
        if(left+right>dim){
            dim=left+right;
        }
        return Math.max(lheight + rheight + 1,
                Math.max(left, right));
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
        System.out.printf("DIAMETER  :-"+diameter(n2));
        System.out.printf("Height "+height(n1));

    }


}
