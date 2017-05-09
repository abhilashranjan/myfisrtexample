package demo.gcd.amazon.hackeerearth;

/**
 * Created by anya on 9/5/17.
 */
public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree tree= new BinaryTree();
        Node root= new Node(1);

        int[] nums = {15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
        for(int i : nums ) {
            tree.addNode( root,i );
        }

        tree.traversePreOrder(root);
//        tree.traverseInOrder();
//        tree.traversePostOrder();

    }
    public void addNode(Node root, int data){
        if(root==null){
            root=new Node(data);
        }if(root.data>data){

            if (root.left != null) {
                addNode(root.left,data);
            } else {
                root.left = new Node(data);
            }
        }if(root.data<data){
            if (root.right != null) {
                addNode(root.right,data);
            } else {
                root.right = new Node(data);
            }
        }
    }


    // Visit the node first, then left and right sub-trees
    public void traversePreOrder(Node root) {
        System.out.print( "  "+root.data );
        if( root.left != null ) {
            traversePreOrder(root.left);
        }
        if( root.right != null ) {
            traversePreOrder(root.right);
        }
    }
}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
