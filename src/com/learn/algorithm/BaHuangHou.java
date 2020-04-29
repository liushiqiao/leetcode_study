package com.learn.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author vangoleo
 * @create 2020-04-29 11:47 上午
 * @desc
 **/
public class BaHuangHou {

    static int tot = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int C[] = new int[a];
            List<List<String>> res = new ArrayList<>();
            search(0, a, C, res);
            for (List<String> re : res) {
                System.out.println(re);
            }
            System.out.println("共有" + tot + "种排列！！");
        }
    }

    public static void search(int cur, int n, int C[], List<List<String>> res) {

        if (cur == n) {
            tot++;
            List<String> item = new ArrayList<>();
            for (int i = 0; i < cur; i++) {
                String arr[] = new String[n];
                for (int i1 = 0; i1 < n; i1++) {
                    if (i1 == C[i] - 1) {
                        arr[i1] = "Q";
                    } else {
                        arr[i1] = ".";
                    }
                }
                item.add(Arrays.toString(arr));
            }
            res.add(item);
        } else {
            for (int i = 1; i <= n; i++) {
                boolean ok = true;
                C[cur] = i;
                for (int j = 0; j < cur; j++) {
                    if (C[cur] == C[j] || cur - C[cur] == j - C[j] || cur + C[cur] == j + C[j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    search(cur + 1, n, C,res);
                }
            }
        }
    }

    public static void print(int A[]) {
        int B[] = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int C[] = new int[A.length];
            C[A[i] - 1]++;
            for (int j = 0; j < C.length; j++) {
                if (C[j] != 0) {
                    System.out.print("皇 ");
                } else {
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }

    }

}