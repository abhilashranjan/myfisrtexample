package demo.myfirst.example.linklist;

/**
 * Created by anya on 18/1/18.
 */
public class PairReverseLinkList {
    public static Node reversePair(Node root){
        Node t1=null,t2=null,current=root;
        while(current!=null){
            if(t1!=null){
                t1.next.next=current.next;
            }
            t1=current.next;
            current.next=current.next.next;
            t1.next=current;
            if(t2==null){
                t2=t1;
            }
            current= current.next;
        }
        return t2;
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
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        print(n1);
        System.out.println();
        print(reversePair(n1));
        System.out.println();

    }
}
