package demo.myfirst.example.linklist;

public class MergeList {
    static class Node{
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


     private  static Node mergeLists(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.data < list2.data) {
            list1.next = mergeLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeLists(list2.next, list1);
            return list2;
        }
    }






    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+"-->");
            head= head.next;
        }
    }


    public static Node mergeTwoLists(Node l1, Node l2) {
        Node head = new Node();
        Node curent=head;

        Node head1=l1;
        Node head2=l2;
        while(head1!=null && head2!=null){
            if(head1.data < head2.data){
                curent.next = head1;
                head1 = head1.next;
            }else{
                curent.next = head2;
                head2 = head2.next;
            }
            curent=curent.next;
        }

        if(head1!=null){
            curent.next = head1;
        }

        if(head2!=null){
            curent.next = head2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n6= new Node(6);
        n1.next=n3;
        n3.next=n5;

        n2.next=n4;
        n4.next=n6;

        print(mergeTwoLists(n1,n2));
        System.out.println("");
        //print(mergeLists(n1,n2));
    }
}
