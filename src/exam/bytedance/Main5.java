package exam.bytedance;

/**
 * 给一个 Unix 的绝对路径，将其简化
 * 输入： /home//foo/
 * 答案： /home/foo
 * 输入： /a/./b/../../c/
 * 答案： /c
 * 输入： /a//b////c/d//././/..
 * 答案： /a/b/c
 */

import java.util.Arrays;
import java.util.Scanner;
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String[] strArr=str.split("/");
        System.out.println(Arrays.toString(strArr));
        String[] output=new String[strArr.length];
        int j=0;
        for(int i=0;i<strArr.length;i++){
            System.out.println(j);
            if(strArr[i]=="..") {
                output[--j]=" ";
                continue;
            }else
            if(strArr[i]=="."&&strArr[i]==" "){
                continue;
            } else {
                output[j++]=strArr[i];
            }
        }
        for(int m=0;m<output.length;m++){
            if(output[m]!=null&&output[m]!=" "){
                System.out.print("/"+output[m]);
            }
        }
    }
}
