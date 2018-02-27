package multiThread.wait_produce_consume;

/**
 * @Author James Wang
 * @Date 2018/2/6 20:23
 */

public class Thread_P extends Thread{
    private P p;
    public Thread_P(P p){
        super();
        this.p = p;
    }

    @Override
    public void run() {
        int i = 0;
        while (i<1000){
            p.pushService();
            i++;
        }
    }
}
