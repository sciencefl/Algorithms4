package exam.pdd;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3{
    static class Task{
        int id;
        int time;
        int waits=0;//表示需要等待的任务数
        LinkedList<Integer> refs=new LinkedList<Integer>();//依赖该任务的任务
        public Task(int id,int time) {
            this.id=id;
            this.time=time;
        }
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        PriorityQueue<Task> can=new PriorityQueue<>(new Comparator<Task>() {//存储可执行任务的优先级队列

            @Override
            public int compare(Task o1, Task o2) {
                if(o1.time<o2.time) return -1;
                if(o1.time>o2.time) return 1;
                if(o1.id<o2.id) return -1;
                if(o1.id>o2.id) return 1;
                return 0;
            }

        });
        int m,n;
        n=s.nextInt();
        m=s.nextInt();
        Task[] tasks=new Task[n+1];
        for(int i=1;i<=n;i++) {
            int time=s.nextInt();
            tasks[i]=new Task(i, time);//创建任务到任务数组
        }
        for (int i = 0; i < m; i++) {
            int ai=s.nextInt();
            int bi=s.nextInt();
            tasks[bi].waits++;
            tasks[ai].refs.add(bi);
        }
        for (int i=1;i<=n;i++) {
            if(tasks[i].waits==0) can.add(tasks[i]);//将可执行的任务加入优先级队列
        }
        Task next=can.poll();
        StringBuilder builder=new StringBuilder();
        builder.append(next.id);
        while(next!=null){
            for (Integer t : next.refs) {
                Task temp=tasks[t];
                temp.waits--;
                if(temp.waits==0) {//将当前任务完成后修改依赖于该任务的任务，将可执行的加入优先级队列
                    can.add(temp);
                }
            }
            next=can.poll();
            if(next!=null) {
                builder.append(" "+next.id);
            }
        }
        System.out.println(builder.toString());

    }
}
