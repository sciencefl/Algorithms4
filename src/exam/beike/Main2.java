package exam.beike;

import java.util.Scanner;

/** AC率 82%  最长 升序列长度
 * @Classname Main2
 * @Description TODO
 * @Date 2019/8/10 19:26
 * @Created by flzhang
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 数量，输入的数均为正整数
        int[] num=new int[n];
        for (int i = 0; i < n; i++) {
            num[i]=sc.nextInt();
        }
        //采用动态规划
        int[] dp=new int[n];
        int count=0;
        for (int i = 0; i < n; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(num[j]<num[i]){
                    dp[i]=maxNum(dp[i],dp[j]+1);
                }
            }
            if(count<dp[i]){
                count=dp[i];
            }
        }
        if(count==1){
            count=0;
        }
        System.out.println(count);
    }
    static int maxNum(int a,int b){
        return a>b?a:b;
    }
}
