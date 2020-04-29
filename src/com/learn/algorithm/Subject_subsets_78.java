package com.learn.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 求幂集
 */
public class Subject_subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> item = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(item);
        sub(0, item, res, nums);
        return res;
    }

    public void sub(int i, List<Integer> item, List<List<Integer>> res, int[] nums) {
        if (i >= nums.length) {
            return;
        }
        item.add(nums[i]);
        res.add(new ArrayList<>(item));
        sub(i + 1, item, res, nums);
        item.remove(item.size() - 1);
        sub(i + 1, item, res, nums);
    }

    public List<List<Integer>> subsets_weiyu(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int all_size = 1 << nums.length;
        for (int i = 0; i < all_size; i++) {
            List<Integer> item = new ArrayList<>();
            for (int i1 = 0; i1 < nums.length; i1++) {
                if ((i & 1 << i1) != 0) {
                    item.add(nums[i1]);
                }
            }
            res.add(item);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        List<List<Integer>> res = new Subject_subsets_78().subsets(arr);
        System.out.println(new Subject_subsets_78().subsets_weiyu(arr));
    }
}

class kuhao {
    void generate(String item,int n,List<String> res){
        if (item.length()>=n*2){
            res.add(item);
            return;
        }
        generate(item+"(",n,res);
        generate(item+")",n,res);
    }


    void generatezuiz(String item,int left,int right,List<String> res){
        if (left==0&&right==0){
            res.add(item);
            return;
        }
        if (left>0){
            generatezuiz(item+"(",left-1,right,res);
        }
        if (left<right){
            generatezuiz(item+")",left,right-1,res);
        }
    }
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
//        new kuhao().generate("",2,res);
        new kuhao().generatezuiz("",2,2,res);
        System.out.println(res);
    }
}
