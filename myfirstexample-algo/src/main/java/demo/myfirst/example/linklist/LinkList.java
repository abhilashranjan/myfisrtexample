package demo.myfirst.example.linklist;

/**
 * Created by abhilash on 7/3/16.
 */
public class LinkList {
    private Node first;

    //LinkList constructor
    public LinkList() {
        first = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
        return first == null;
    }

    //Inserts a new Link at the first of the list
    public void insert(int d1) {
        Node link = new Node(d1);
        link.next = first;
        first = link;
    }

    //Deletes the link at the first of the list
    public Node delete() {
        Node temp = first;
        first = first.next;
        return temp;
    }

    //Prints list data
    public void printList() {
        Node currentLink = first;
        System.out.print("List: ");
        while (currentLink != null) {
            currentLink.printLink();
            currentLink = currentLink.next;
        }
        System.out.println("");
    }
}
