package demo.myfirst.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by anya on 27/1/18.
 */
public class DFSWithGraph {

    private static Stack<Node> stack;
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

    public DFSWithGraph() {
        stack= new Stack<>();
    }
    public static void dfs(Node node){
        stack.push(node);
        while (!stack.isEmpty()){
            Node temp=stack.pop();
            System.out.print(temp.data+"\t");
            List<Node> childs=temp.getNeighbours();
            for(int i=0; i<childs.size(); i++){
                Node child= childs.get(i);
                if(child!=null && !child.visited){
                    child.visited=true;
                    stack.push(child);
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
        System.out.println("The DFS traversal of the graph is ");
        DFSWithGraph dfsWithGraph= new DFSWithGraph();
        dfsWithGraph.dfs(node40);
    }
}
