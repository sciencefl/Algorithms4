package exam.beike;

import java.util.Scanner;

/**
 * @Classname Main1
 * @Description TODO
 * @Date 2019/8/10 19:03
 * @Created by flzhang
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 数量，输入的数均为正整数
        long[] num = new long[n];
        num[0]=sc.nextLong();
        num[1]=sc.nextLong();
        long a1=num[0];
        long a2=num[1];
        long minAbs=abss(abss(a1)-abss(a2));
        for(int i=2;i<n;i++){
            num[i]=sc.nextLong();
            long abs=abss(abss(num[i]-abss(num[i-1])));
            if(abs<minAbs){
                minAbs=abs;
                a1=num[i-1];
                a2=num[i];
            }
        }
        System.out.println(a1+" "+a2);
    }
    static long abss(long n){
        return n>0?n:-n;
    }
}
