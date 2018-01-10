package demo.myfirst.example.stack;

import java.util.Stack;

/**
 * Created by anya on 10/7/17.
 */
public class PostFixImplmentation {

    public static void main(String[] args) {
        Stack<String> stack= new Stack<>();


        testNodeStack();
    }

    private static void testNodeStack() {
        NodeStack nodeStack= new NodeStack();
        Node root=null;
        String str[]={"a","b","c","d","e"};
        for (int i = 0; i <5 ; i++) {
            root= nodeStack.push(root,str[i]);
        }
        nodeStack.display(root);
        root= nodeStack.pop(root);
        System.out.println();
        nodeStack.display(root);
    }
}
