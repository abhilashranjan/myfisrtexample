package demo.myfirst.example.linklist;

/**
 * Created by anya on 18/1/18.
 */
public class ReverseLinkList {

    public static Node reverseLinkList(Node root){
        Node current=root, prev=null, next;
        while(current!=null){
            next= current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        return prev;
    }

    public static void print(Node root){

        while (root!=null){

            System.out.print(root.data+"-->");
            root= root.next;
        }
    }

    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        print(n1);
        System.out.println();
        print(reverseLinkList(n1));

    }
}
