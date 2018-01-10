package demo.myfirst.example.linklist;

import java.util.Collections;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

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



//        delete(list);
        //Collections.un


        ExecutorService exec = newSingleThreadExecutor();
        exec.shutdown();
    }

    private static void delete(LinkList list) {
        while (!list.isEmpty()) {
            Node deletedLink = list.delete();
            System.out.print("deleted: ");
            deletedLink.printLink();
            System.out.println("");
        }
        list.printList();
    }
}
