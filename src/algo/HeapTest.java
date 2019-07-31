package algo;

import java.util.Arrays;

/**
 * @Classname HeapTest
 * @Description TODO
 * @Date 2019/7/31 20:17
 * @Created by flzhang
 */
public class HeapTest {
    public static void main(String[] args) {
        HeapTest heapTest = new HeapTest(6);
        heapTest.insert(10);
        heapTest.insert(5);
        heapTest.insert(6);
        heapTest.insert(3);
        heapTest.insert(8);
        heapTest.insert(9);
//        heapTest.sort(heapTest.a,heapTest.a.length-1);
        heapTest.buildHeap(heapTest.a,heapTest.a.length-1);
        System.out.println(Arrays.toString(heapTest.a));
        heapTest.removeMax();
        System.out.println(Arrays.toString(heapTest.a));
    }
    /**
     * 堆是什么
     * 1.是一颗完全二叉树。所以适合用数组来存储。
     * 2.堆中的每个节点的值都大于其左右子节点的值。
     */
    int[] a;// 用来存储堆中元素的值
    int n; // 堆的大小
    int count; // 堆中已有元素
    public  HeapTest(int cap){
        a=new int[cap+1];
        n=cap;
        count=0;
    }
    /**
     * 堆排序的步骤：
     * 1.建堆
     * 2.排序 （从数组下标1开始存储）
     *  1)将对顶的元素与最后一个元素交换，然后堆化
     */
    public void sort(int[] a,int count){
        buildHeap(a,count);
        System.out.println(Arrays.toString(a));
        while(count>1){
            swap(a,1,count);
            count--;
            heapify(a,count,1);
        }

    }
    /**
     * 建堆的函数，从后向前的元素顺序，从上向下的堆化操作
     */
    public void buildHeap(int[] a,int count){
        if(a==null||count==0){
            return;
        }
        for(int i=(count>>1);i>=1;i--){
            heapify(a,count,i);
        }
    }

    /**
     *
     * @param a  要堆化的堆
     * @param count 堆的当前大小
     * @param i 要进行堆化的节点
     */
    public void heapify(int[] a,int count,int i){
        if(a==null||count==0){
            return ;
        }
        while(true){
            int maxPos=i;
            if(i*2<=count&&a[i]<a[2*i]) maxPos=2*i;
            if(i*2+1<=count&&a[maxPos]<a[2*i+1]) maxPos=2*i+1;
            if(maxPos==i){
                break;
            }else {
                swap(a,i,maxPos);
                i=maxPos;
            }
        }
    }
    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    /**
     * 增加一个元素
     * @param data 要插入的值
     * @return
     */
    public boolean insert(int data){
        //堆已经满了，无法再放元素
        if(count==n){
            return false ;
        }
        a[++count]=data;
        // 从下向上堆化
        int i=count;
        while(i/2>0&&(a[i]>a[i/2])){
            swap(a,i,i/2);
            i=i/2;
        }
        return true;
    }

    /**
     * 删除堆顶元素
     * @return
     */
    public boolean removeMax(){
        // 空堆，无法删除元素
        if(count==0){
            return false;
        }
        swap(a,1,count);
        count--;
        heapify(a,count,1);
        return true;
    }
}
