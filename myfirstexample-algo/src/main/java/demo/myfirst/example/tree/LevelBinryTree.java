package demo.myfirst.example.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelBinryTree {
    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
        }

    }

    static void printLevel(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue= new LinkedList<>();

        queue.offer(root);
        while(true) {
            int nodeCount = queue.size();
            if(nodeCount == 0)
                break;
            while (nodeCount>0) {
                Node current = queue.peek();
                System.out.print(current.data + "  ");
                queue.remove();
                if (current.left != null) {
                    queue.offer(root.left);
                }
                if (current.right != null) {
                    queue.offer(root.right);
                }
                nodeCount--;

            }
            System.out.println();
        }
    }


    static int hight(Node root){
        if(root==null){
            return 0;
        }
        int lHight=hight(root.left);
        int rHight=hight(root.right);
        return (lHight>rHight)?(lHight+1):(rHight+1);
    }

    static void printLevelTraversal(Node root){
        for (int i=1; i<=hight(root); i++){
            printLevelRecursive(root,i);
        }
    }

    static void printLevelRecursive(Node root, int level){
        if(root==null){
            return;
        }
        if(level==1){
            System.out.println(root.data+" ");
        }if(level>1){
            printLevelRecursive(root.left,level-1);
            printLevelRecursive(root.right,level-1);
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

//        printLevel(na);
//        System.out.println(hight(na));
//        printLevelRecursive(na, hight(na));
        printLevelTraversal(na);
    }

}
