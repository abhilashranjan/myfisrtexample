package demo.myfirst.example.karnimunchi.linklist;

import demo.myfirst.example.linklist.Node;

/**
 * Created by anya on 10/1/18.
 */
public class Problem18 {

    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n6= new Node(6);
        Node n7= new Node(7);
//        Node n8= new Node(8);
//        Node n9= new Node(9);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=null;
        n5.next=n6;
        n6.next=n7;
        n7.next=n3;


        Node head1= n1;
        Node head2= n5;
        while(head1!=null) {
            System.out.print(head1.data + "-->");
            head1 = head1.next;
        }
        System.out.println();
        while( head2!=null){

            System.out.print(head2.data+"-->");
            head2= head2.next;
        }

    }
}
