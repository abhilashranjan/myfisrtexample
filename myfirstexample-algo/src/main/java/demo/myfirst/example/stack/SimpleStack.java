package demo.myfirst.example.stack;

/**
 * Created by abhilash on 22/10/16.
 */
public class SimpleStack {
    char charr[]=new char[5];
    int top=-1;

    public boolean isEmpty(){
        return charr[0] == '\0';
    }

    public boolean isFull(){
        return charr.length == top;
    }
    public void push(char ch){
        if(!isFull()){
            top++;
            charr[top]=ch;

        }else
            System.out.println("stack is full");
    }
    public char pop(){
        char chh=charr[top];
        if(!isEmpty()){

            charr [top]='\0';
            top--;
        }else{
            System.out.println("stack is empty");
        }
        return  chh;
    }

    public void display(){
        System.out.println();
        for (int i=0; i<charr.length; i++){
            System.out.printf("\t -->"+charr[i]);
        }
    }

    public static void main(String[] args) {
        SimpleStack simpleStack= new SimpleStack();
       // simpleStack.pop();
        simpleStack.push('a');
        simpleStack.push('b');
        simpleStack.push('c');
        simpleStack.push('d');
        simpleStack.push('e');
        simpleStack.display();
        simpleStack.pop();
        simpleStack.display();

    }
}
