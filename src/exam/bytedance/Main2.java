package exam.bytedance;

import java.util.Scanner;

/**
 * @Classname Main2
 * @Description TODO
 * @Date 2019/8/11 19:24
 * @Created by flzhang
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 明文长度为N
        int k = sc.nextInt(); //  右移的次数 K-1， 求明文
        String str=sc.next();
        char[] ans=new char[n];
        for (int i = 0; i < str.length()-k+1; i++) {
            int  c=str.charAt(i)=='1'?1:0;
            for(int j=i-1;j>=0&&j>=i-k+1;j--){
                int t=ans[j]=='1'?1:0;
                c=c^t;
            }
            ans[i]=(c==1?'1':'0');
            System.out.print(c);
        }
        System.out.println();
    }
}
