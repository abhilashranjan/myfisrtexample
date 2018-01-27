package demo.myfirst.example.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by anya on 27/1/18.
 */
public class ExampleDFSAndBFS {
    // Iterative DFS using stack
    public static  void dfsUsingStack(Node node) {
        Stack<Node> stack=new  Stack<Node>();
        stack.add(node);
        node.visited=true;
        while (!stack.isEmpty()) {
            Node element=stack.pop();
            System.out.print(element.data + " ");

            List<Node> neighbours=element.getNeibhour();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n=neighbours.get(i);
                if(n!=null && !n.visited) {
                    stack.add(n);
                    n.visited=true;

                }
            }
        }
    }

    public static void bfs(Node node) {
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(node);
        node.visited=true;
        while (!queue.isEmpty()){

            Node element=queue.remove();
            System.out.print(element.data + "\t");
            List<Node> neighbours=element.getNeibhour();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n=neighbours.get(i);
                if(n!=null && !n.visited)            {
                    queue.add(n);
                    n.visited=true;

                }
            }

        }
    }


    public static void main(String[] args) {
        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);

        dfsUsingStack(node40);
        System.out.println("\nBFS\n     ");
        //bfs(node40);

    }

}
