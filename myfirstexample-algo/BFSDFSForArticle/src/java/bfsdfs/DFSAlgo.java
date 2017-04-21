package bfsdfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anya on 6/4/17.
 */
public class DFSAlgo {
    public List<Node> nodes=new ArrayList<>();

    /**
     *
     * @param a
     * @param x
     * @return
     */
    public List<Node> getNeiboughrs(int a[][],Node x){
        int nodeIndex=-1;
        List<Node> neibhours=new ArrayList<>();
        for(int i=0; i<nodes.size();i++){
            if(nodes.get(i).equals(x)){
                nodeIndex=i;
                break;
            }

        }

        if(nodeIndex!=-1){
            for(int j=0; j<a[nodeIndex].length; j++){
                if(a[nodeIndex][j]==1){
                    neibhours.add(nodes.get(j));
                }
            }
        }
    return neibhours;
    }

    public void dfs(int a[][], Node x){
        System.out.println("\t"+x.data);
        List<Node> neiboughers= getNeiboughrs(a,x);
        for (int i = 0; i < neiboughers.size(); i++) {
            Node n=neiboughers.get(i);
            if(n!=null && !n.visted){
                dfs(a,n);
                n.visted=true;
            }
        }
    }

    public static void main(String[] args) {
        DFSAlgo dfsAlgo= new DFSAlgo();
        Node node40=new Node(40);
        Node node10= new Node(10);
        Node node20= new Node(20);
        Node node30= new Node(30);
        Node node60= new Node(60);
        Node node50= new Node(50);
        Node node70= new Node(70);

        dfsAlgo.nodes.add(node40);
        dfsAlgo.nodes.add(node10);
        dfsAlgo.nodes.add(node20);
        dfsAlgo.nodes.add(node30);
        dfsAlgo.nodes.add(node60);
        dfsAlgo.nodes.add(node50);
        dfsAlgo.nodes.add(node70);


        int adjacency_matrix[][] = {
                {0,1,1,0,0,0,0},  // Node 1: 40
                {0,0,0,1,0,0,0},  // Node 2 :10
                {0,1,0,1,1,1,0},  // Node 3: 20
                {0,0,0,0,1,0,0},  // Node 4: 30
                {0,0,0,0,0,0,1},  // Node 5: 60
                {0,0,0,0,0,0,1},  // Node 6: 50
                {0,0,0,0,0,0,0},  // Node 7: 70
        };


        System.out.println("The DFS traversal of the graph using recursion ");
        dfsAlgo.dfs(adjacency_matrix, node40);


    }
    public void clearVisitedFlags()
    {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).visted=false;
        }
    }
}
