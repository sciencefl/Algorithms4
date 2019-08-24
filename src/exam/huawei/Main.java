package exam.huawei;

import java.util.Scanner;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/8/14 18:49
 * @Created by flzhang
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 明文长度为N
        int flag = 0; // 0表示从头开始，1：表示匹配 1  2：表示匹配10 3：表示匹配101
        int count = 0; // 表示匹配次数
        int firstPos = -1; // 表示第一次出现的位置
        String str = Integer.toBinaryString(n);
        //       System.out.println(str);
        for (int i = str.length() - 1, k = 0; i >= 0; i--, k++) {
            char ch = str.charAt(i);
            if (ch == '1') {
                if (flag == 0) {
                    flag = 1;
                } else if (flag == 1) {
                    continue;
                } else if (flag == 2) {
                    count++;
                    if (firstPos == -1) {
                        firstPos = k - 2;
                    }
                    flag = 1;
                }
            } else if (ch == '0') {
                if (flag == 0) {
                    continue;
                } else if (flag == 1) {
                    flag = 2;
                } else if (flag == 2) {
                    flag = 0;
                }
            }
        }
        System.out.println(count + " " + firstPos);
    }
}
