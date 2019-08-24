package exam.bytedance;

import java.util.Scanner;

/**
 * @Classname Main3
 * @Description TODO
 * @Date 2019/8/11 19:35
 * @Created by flzhang
 */
public class Main3
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 人数
        int[] arr=new int[n];
     //   int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
       //     if(arr[i]<min){
        //        min=i;
            //}
        }
        long sum=0;
        int[] monoy=new int[n];
        monoy[0]=100;
      //  int add=100;
        for(int i=1;i<n;i++){
            if(arr[i]<arr[i-1]){
                //todo  迭代选择最小的
                if(monoy[i-1]==100){
                    int k=i-1;
                    monoy[i-1]+=100;
                   for(int j=k;j>0;j--){
                       if(arr[j-1]>arr[j]){
                           monoy[j-1]=monoy[j]+100;
                       }else if(arr[j-1]==arr[j]){
                           monoy[j-1]=monoy[j];
                       } else{
                           break;
                       }
                   }
                }
                monoy[i] = 100;
            }else if(arr[i]==arr[i-1]){
                monoy[i]=monoy[i-1];
            }else{
                monoy[i]=monoy[i-1]+100;
            }
        }
        for(int i=0;i<n;i++){
            sum+=monoy[i];
        }
        System.out.println(sum);
    }
}
