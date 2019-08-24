package exam.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/8/11 18:46
 * @Created by flzhang
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 数闹钟的个数
        int[] arr=new int[n];
        int[] time=new int[2];
        for (int i = 0; i < n; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[i]=a*60+b;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int costTime=sc.nextInt();
        time[0]=sc.nextInt();
        time[1]=sc.nextInt();
        int costMinute=time[0]*60+time[1]-costTime;
        int   minClock=0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]<=costMinute){
               minClock=arr[i];
               break;
            }
        }
        System.out.println((int)(minClock/60)+" "+(minClock%60));
    }
}
