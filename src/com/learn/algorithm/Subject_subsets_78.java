package com.learn.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 求幂集
 */
public class Subject_subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> item =new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(item);
        sub(0,item,res,nums);
        return res;
    }

    public void sub(int i,List<Integer> item,List<List<Integer>> res,int[] nums){
        if (i>=nums.length){
            return;
        }
        item.add(nums[i]);
        res.add(new ArrayList<>(item));
        sub(i+1,item,res,nums);
        item.remove(item.size()-1);
        sub(i+1,item,res,nums);
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        List<List<Integer>> res = new Subject_subsets_78().subsets(arr);
        System.out.println(res);
    }
}
