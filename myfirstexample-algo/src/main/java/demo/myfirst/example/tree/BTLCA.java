package demo.myfirst.example.tree;

public class BTLCA {
    static class Node {
        char ch;
        Node left, right;

        public Node(char ch) {
            this.ch = ch;
        }
    }

    public static Node findLCA(Node root, Node l1, Node l2){
        if(root==null){
            return root;
        }
        if(root==l1 ||root==l2){
            return root;
        }
        Node left=findLCA(root.left,l1,l2);
        Node right=findLCA(root.right,l1,l2);
        if(left!=null && right!=null){
            return root;
        }else{
            return (left!=null)?left:right;
        }
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

        System.out.println(findLCA(na, nd, ne).ch);
        System.out.println(findLCA(na, nd, nf).ch);
    }
}
