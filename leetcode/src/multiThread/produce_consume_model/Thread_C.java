package multiThread.produce_consume_model;

/**
 * @Author James Wang
 * @Date 2018/2/6 20:28
 */

public class Thread_C extends Thread{
    private C c;
    public Thread_C(C c){
        super();
        this.c = c;
    }

    @Override
    public void run() {
        int i = 0;
        while (i<1000){
            c.popService();
            i++;
        }
    }
}
