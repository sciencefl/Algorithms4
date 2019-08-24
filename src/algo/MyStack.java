package algo;

import java.util.Arrays;

/**
 * @Classname MyStack
 * @Description 用数组实现栈
 * @Date 2019/8/21 9:14
 * @Created by flzhang
 */
public class MyStack {
    /**
     * 1. 栈容量的大小
     * 2.无参构造方法。有参构造方法
     * 3. push 和pop 操作
     * 4. isEmpty 和 isFull 操作
     * 5. 扩容操作 enlarge
     */
    private int top=-1; // 栈的大小，也是栈顶元素
    private int DEFAULT_CAP=2;
    public Object[] arr;
    public  MyStack(){
        arr=new Object[DEFAULT_CAP];
    }
    public MyStack(int cap){
        arr=new Object[cap];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==arr.length-1;
    }
    private  void enlarge(){
        int num=arr.length/3;
        if(num==0){
            num=1;
        }
        arr=Arrays.copyOf(arr,arr.length+num);
    }
    public void push(Object V){
        if(isFull()){
            enlarge();
        }
        arr[++top]=V;
    }
    public void pop()throws  Exception{
        if(isEmpty()){
            throw new Exception("The Stack is Empty");
        }
        System.out.println(arr[top--]);
    }
    public void display(){
        for(int i=0;i<=top;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        MyStack myStack= new MyStack();
        System.out.println("Empty:"+myStack.isEmpty());
        System.out.println("Full:"+myStack.isFull());
        myStack.push("aaaaaaa");
        myStack.push("bbbbbbb");
        myStack.push("ccccccc");
        myStack.push("dddddd");
        myStack.display();
        myStack.pop();
        myStack.display();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();


    }
}
