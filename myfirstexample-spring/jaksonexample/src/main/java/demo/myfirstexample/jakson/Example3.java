package demo.myfirstexample.jakson;

/**
 * Created by anya on 22/4/17.
 */
public class Example3 {
    public class X extends Error{
        public X(String message) {
            super(message);
        }

        public X() {
            System.out.println("XX");
        }
    }

    public void executeException(){
        throw new X();
    }

    public static void main(String[] args) {
        Example3 example3= new Example3();
                try{
                    example3.executeException();
                }catch(Exception e){
                    System.out.println("Exacption occour !!!");
                }

    }
}
