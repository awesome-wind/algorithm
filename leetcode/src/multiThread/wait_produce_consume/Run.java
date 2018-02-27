package multiThread.wait_produce_consume;

/**
 * @Author James Wang
 * @Date 2018/2/6 20:29
 */

public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c = new C(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        C c3 = new C(myStack);
        Thread_P thread_p = new Thread_P(p);
        Thread_C thread_c = new Thread_C(c);
        Thread_C thread_c1 = new Thread_C(c1);
        Thread_C thread_c2 = new Thread_C(c2);
        Thread_C thread_c3 = new Thread_C(c3);
        thread_p.start();
        thread_c.start();
        thread_c1.start();
        thread_c2.start();
        thread_c3.start();
    }
}