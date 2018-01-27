package demo.myfirst.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by anya on 27/1/18.
 */
public class BFSWithGraph {
    private static Queue<Node> queue;
    static class Node{
        int data;
        boolean visited;
        List<Node> neighbours;

        public Node(int data) {
            this.data = data;
            this.neighbours= new ArrayList<>();
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }

    }

    public BFSWithGraph() {
        queue= new LinkedList<>();
    }

    public static void bfs(Node node){
        queue.offer(node);
        while(!queue.isEmpty()){
            Node temp=queue.remove();
            System.out.print(temp.data+"\t");
            List<Node> childs=temp.getNeighbours();
            for(int i=0; i<childs.size(); i++){
                Node child=childs.get(i);
                if(child!=null && !child.visited){
                    child.visited=true;
                    queue.offer(child);
                }
            }
        }
    }

    //  The BFS traversal of the graph is
    //40	10	20	30	60	50	70
    public static void main(String[] args) {
        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);


        node40.getNeighbours().add(node10);
        node40.getNeighbours().add(node20);
        node10.getNeighbours().add(node30);
        node20.getNeighbours().add(node10);
        node20.getNeighbours().add(node30);
        node20.getNeighbours().add(node60);
        node20.getNeighbours().add(node50);
        node30.getNeighbours().add(node60);
        node60.getNeighbours().add(node70);
        node50.getNeighbours().add(node70);
        System.out.println("The BFS traversal of the graph is ");
        BFSWithGraph bfsExample = new BFSWithGraph();
        bfsExample.bfs(node40);

    }
}
