package multiThread.produce_consume_model;

/**
 * @Author James Wang
 * @Date 2018/2/6 20:24
 */

public class P {
    private MyStack myStack;
    public P(MyStack myStack){
        super();
        this.myStack = myStack;
    }

    public void pushService(){
        myStack.push();
    }
}
