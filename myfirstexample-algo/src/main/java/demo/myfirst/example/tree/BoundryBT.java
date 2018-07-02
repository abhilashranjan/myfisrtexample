package demo.myfirst.example.tree;

public class BoundryBT {
    static class Node{
        char data;
        Node left,right;

        public Node(char data) {
            this.data = data;
        }
    }

    private boolean ifLeaf(Node root){
        return root!=null && root.left==null && root.right==null;
    }

    public void preorderLeftOnly(Node root){
        if(root!=null && !ifLeaf(root)){
            System.out.print(root.data+" >");
        }
        if(root.left!=null){
            preorderLeftOnly(root.left);
        }
    }

    public void inorderLeafOnly(Node root){
        if(root==null){
            return;
        }if(root.left!=null){
            inorderLeafOnly(root.left);
        }if(root.left==null && root.right==null){
            System.out.print(root.data+" >");
        }if(root.right!=null){
            inorderLeafOnly(root.right);
        }
    }

    public void posorderRightOnly(Node root){
        if(root!=null && !ifLeaf(root)){
            System.out.print(root.data+" >");
        }
        if(root.right!=null){
            posorderRightOnly(root.right);
        }
    }

    public void printBoundry(Node root){
        preorderLeftOnly(root);
        inorderLeafOnly(root);
        posorderRightOnly(root);
    }

    public static void main(String[] args) {
        Node na= new Node('a');
        Node nb= new Node('b');
        Node nc= new Node('c');
        Node nd= new Node('d');
        Node ne= new Node('e');
        Node nf= new Node('f');
        Node ng= new Node('g');
        na.left=nb;
        na.right=nc;
        nb.left=nd;
        nb.right=ne;
        nc.left=nf;
        nc.right=ng;
        BoundryBT bt= new BoundryBT();
        bt.printBoundry(na);
    }
}

