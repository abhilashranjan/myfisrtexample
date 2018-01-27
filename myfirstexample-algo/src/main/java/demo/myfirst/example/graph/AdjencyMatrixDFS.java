package demo.myfirst.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by anya on 27/1/18.
 */
public class AdjencyMatrixDFS {

    private static Stack<Node> stack;
    private static List<Node> nodes= new ArrayList<>();
    static class Node{
        int data;
         boolean visited;


        public Node(int data) {
            this.data = data;
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
    }

    public AdjencyMatrixDFS() {
        stack= new Stack<>();
    }

    public static List<Node> getNeighbours(int adj[][], Node x){
        int nodeIndex=-1;
        List<Node> neighbours= new ArrayList<>();
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

    public static void dfs(int adj[][], Node node){
        stack.push(node);
        while (!stack.isEmpty()){
            Node temp= stack.pop();
            System.out.print(temp.data+"\t");
            List<Node> childs= getNeighbours(adj,temp);
            for(int i=0; i<childs.size(); i++){
                Node child=childs.get(i);
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
        System.out.println("The DFS traversal of the graph is ");
        AdjencyMatrixDFS adjencyMatrixDFS= new AdjencyMatrixDFS();
        adjencyMatrixDFS.dfs(adjacency_matrix,node40);
    }
}
