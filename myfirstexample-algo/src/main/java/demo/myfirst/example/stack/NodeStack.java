package demo.myfirst.example.stack;

/**
 * Created by anya on 10/7/17.
 */
public class NodeStack {
    public Node push(Node root, Object data){
        Node newNode=new Node(data);
        if(root==null){
            root=newNode;
        }else{
            newNode.next=root;
            root=newNode;
        }
        return root;
    }

    public Node pop(Node root){
        root=root.next;
        return root;
    }

    public void display(Node root){
        if(root==null){
            return;
        }
        while(root!=null){
            System.out.print("\t"+root.data);
            root= root.next;
        }
    }

    public static void main(String[] args) {
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
