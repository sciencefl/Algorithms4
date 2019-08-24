package algo;

/**
 * @Classname CircleQueue
 * @Description TODO
 * @Date 2019/8/21 9:58
 * @Created by flzhang
 */
public class CircleQueue {
    /**
     * 队列的要素
     * 队列的大小
     * 1.无参数构造函数，有参数构造函数
     * 2. isEmpty 和 isFull
     * 3. enqueue 和 dequeue
     * @param args
     */
    public  Object[] arr;
    private int DEFAULT_CAP=16;
    private int head=0;
    private int tail=-1;
    public CircleQueue(){
        arr=new Object[DEFAULT_CAP];
    }
    public CircleQueue(int n){
        arr=new Object[n];
    }
    public static void main(String[] args) {

    }
}
