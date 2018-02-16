package demo.myfirst.example.tree;

public class CreateTree {
    static class Node{
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(char data) {
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

    static int preIndex=0;
    static Node buildTree(char in[],char pre[],int inStart,int inEnd){
        if(inStart>inEnd){
            return null;
        }
        Node temp= new Node(pre[preIndex]);
        if(inStart==inEnd){
            return temp;
        }
        int inIndexSearch=search(in,inStart,inStart,temp.data);
        temp.left=buildTree(in,pre,inStart,inIndexSearch-1);
        temp.right=buildTree(in,pre,inIndexSearch+1,inEnd);
        return temp;
    }

    private static int search(char[] in, int inStart, int inEnd, int data) {
        int i=0;
        for(i=inStart; i<=inEnd; i++){
            if(in[i]==data){
                return i;
            }
        }
        return i;
    }

    public static void printOrder(Node node){
       if(node==null){
           return;
       }
       printOrder(node.left);
        System.out.println(node.data+"-->");
       printOrder(node.right);
    }

    public static void main(String[] args) {
        char in[]=new char[]{'D','B','E','A','F','C'};
        char pre[]= new char[]{'A','B','D','E','C','F'};
        int len=in.length;
        Node n1=buildTree(in,pre,0,len-1);
        printOrder(n1);

    }

}
