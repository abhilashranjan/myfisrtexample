package demo.myfirst.example.linklist;

/**
 * Created by abhilash on 7/3/16.
 */
public class Node {

    public Node next;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    //Print Link data
    public void printLink() {
        System.out.print("{" + this.data + "} ");
    }
}
