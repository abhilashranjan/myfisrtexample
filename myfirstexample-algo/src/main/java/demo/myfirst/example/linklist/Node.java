package demo.myfirst.example.linklist;

/**
 * Created by abhilash on 7/3/16.
 */
public class Node {

    public Node next;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    //Print Link data
    public void printLink() {
        System.out.print("{" + this.data + "} ");
    }
}
