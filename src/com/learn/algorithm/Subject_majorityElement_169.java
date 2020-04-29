package com.learn.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lsq
 * @create 2020-04-29 4:10 下午
 * @desc
 **/
public class Subject_majorityElement_169 {

    public int majorityElement(int[] nums) {

        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                if (map.get(nums[i])>nums.length/2){
                    return nums[i];
                }
            }else {
                map.put(nums[i],1);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer)>nums.length/2){
                return integer;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[]={2,2,1,1,1,2,2};
        int i = new Subject_majorityElement_169().majorityElement(arr);
        System.out.println(i);
    }
}