package demo.myfirst.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by anya on 27/1/18.
 */
public class AdjencyMatrixBFS {
    public static Queue<Node> queue;
    public static List<Node> nodes= new ArrayList<>();
    static class Node{
        int data;
        boolean visted;

        public Node(int data) {
            this.data = data;
        }
    }

    public AdjencyMatrixBFS() {
        this.queue = new LinkedList<>();
    }

    public static List<Node> getNeibhours(int adj[][], Node x){
        List<Node> neighbours= new ArrayList<>();
        int nodeIndex=-1;
        for(int i=0; i<nodes.size(); i++){
            if(nodes.get(i).equals(x)){
                nodeIndex=i;
                break;
            }
        }
        if(nodeIndex!=-1){
            for(int j=0; j<adj[nodeIndex].length; j++){
                if(adj[nodeIndex][j]==1){
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }

    public static void bfsWithAdjencyMatrix(int adj[][],Node node){
        if(queue==null){
            queue= new LinkedList<>();
        }
        queue.offer(node);
        while(!queue.isEmpty()){
            Node element=queue.remove();
            System.out.print(element.data + "\t");
            List<Node> childs= getNeibhours(adj,element);
            for(int i=0; i<childs.size(); i++){
                Node neighbor = childs.get(i);
                if(neighbor!=null && !neighbor.visted) {
                    neighbor.visted = true;
                    queue.offer(childs.get(i));
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

        nodes.add(node40);
        nodes.add(node10);
        nodes.add(node20);
        nodes.add(node30);
        nodes.add(node60);
        nodes.add(node50);
        nodes.add(node70);
        int adjacency_matrix[][] = {
                {0,1,1,0,0,0,0}, // Node 1: 40
                {0,0,0,1,0,0,0}, // Node 2 :10
                {0,1,0,1,1,1,0}, // Node 3: 20
                {0,0,0,0,1,0,0}, // Node 4: 30
                {0,0,0,0,0,0,1}, // Node 5: 60
                {0,0,0,0,0,0,1}, // Node 6: 50
                {0,0,0,0,0,0,0}, // Node 7: 70
        };
        System.out.println("The BFS traversal of the graph is ");
        AdjencyMatrixBFS bfsExample = new AdjencyMatrixBFS();
        bfsExample.bfsWithAdjencyMatrix(adjacency_matrix, node40);
    }
}
