package demo.myfirst.example.linklist;

/**
 * Created by abhilash on 7/3/16.
 */
public class LinkListTest {
    public static void main(String[] args) {
        LinkList list = new LinkList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.printList();

        while (!list.isEmpty()) {
            Node deletedLink = list.delete();
            System.out.print("deleted: ");
            deletedLink.printLink();
            System.out.println("");
        }
        list.printList();
    }
}
