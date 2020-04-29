package com.learn.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vangoleo
 * @create 2020-04-29 3:37 下午
 * @desc
 **/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] C=new int[n];
        generate(0, n, C, res);
        return res;
    }

    public void generate(int cur,int n,int[] C,List<List<String>> res){

        if(cur>=n){
            //添加值
            List<String> item = new ArrayList<>();
            for (int i = 0; i < cur; i++) {
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append('"');
                for (int i1 = 0; i1 < n; i1++) {
                    if (i1 == C[i] - 1) {
                        stringBuilder.append("Q");
                    } else {
                        stringBuilder.append(".");
                    }
                }
                stringBuilder.append('"');
                item.add(stringBuilder.toString());
            }
            res.add(item);
        }else{
            for(int i=1;i<=n;i++){
                boolean flag=true;
                C[cur]=i;//设置第cur行的皇后
                //判断是否与前面的皇后冲突
                for(int j=0;j<cur;j++){
                    //冲突了
                    if(C[cur]==C[j]||C[cur]+cur==C[j]+j||C[cur]-cur==C[j]-j){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    generate(cur+1,n,C,res);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}