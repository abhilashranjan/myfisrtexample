package demo.myfirst.example.thread.custom.pool;

/**
 * Created by anya on 1/7/17.
 */
public interface CustomQueue<E> {
    public  void enque(E e);
    public E dequeue();
}
