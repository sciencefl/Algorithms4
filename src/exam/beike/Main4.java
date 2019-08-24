package exam.beike;

import java.util.Scanner;

/**
 * @Classname Main4
 * @Description TODO
 * @Date 2019/8/10 19:52
 * @Created by flzhang
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 数量，输入的数均为正整数
        int[] qw = new int[n];
        for (int i = 0; i < n; i++) {
            qw[i] = sc.nextInt();
        }
        int l = 0, r = n - 1;
        int count = 0;
        while (l < r) {
            while (l + 1 < n && qw[l + 1] > qw[l]) {
                l++;
            }
            while (r - 1 >= 0 && qw[r - 1] > qw[r]) {
                r--;
            }
            if (l >= r) {
                break;
            }
            if (r - l == 2) {
                int tmp = 0;
                tmp = Math.min(qw[l] - qw[l + 1] + 1, qw[r] - qw[r - 1] + 1);
                count += tmp;
                break;
            }
            if (l + 1 < n && qw[l + 1] <= qw[l]) {
                count += (qw[l] - qw[l + 1] + 1);
                qw[l + 1] = qw[l] + 1;
            }
            if (r - 1 >= 0 && qw[r - 1] <= qw[r]) {
                count += (qw[r] - qw[r - 1] + 1);
                qw[r - 1] = qw[r] + 1;
            }
        }
        System.out.println(count);
    }
}
