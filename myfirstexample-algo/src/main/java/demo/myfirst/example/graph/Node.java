package demo.myfirst.example.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anya on 27/1/18.
 */
public class Node {
    public int data;
    public boolean visited;
    public List<Node> neibhour;

    public Node(int data) {
        this.data = data;
        this.neibhour = new ArrayList<>();
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

    public List<Node> getNeibhour() {
        return neibhour;
    }

    public void setNeibhour(List<Node> neibhour) {
        this.neibhour = neibhour;
    }

    public void addneighbours(Node neighbourNode)
    {
        this.neibhour.add(neighbourNode);
    }
}
