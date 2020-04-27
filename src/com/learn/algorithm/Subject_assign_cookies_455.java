package com.learn.algorithm;

import java.util.Arrays;

/**
 * @desc
 * <p>假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有
 * 一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标
 * 是尽可能满足越多数量的孩子，并输出这个最大数值。
 * </p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subject_assign_cookies_455 {

    /**
     * @param g 孩子
     * @param s 饼干
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        //1、先对两个数组排序
        //2、拿两个变量遍历两个数组
        if (g.length<=0||s.length<=0){
            return 0;
        }
        Arrays.sort(g);//孩
        Arrays.sort(s);//糖
        int index_g=0;//孩
        int index_s=0;//糖
        while(index_g<g.length&&index_s<s.length){
            //糖果能满足
            if (s[index_s]>=g[index_g]){
                index_s++;
                index_g++;
            }else {
                index_s++;
            }
        }
        return index_g;
    }

    /**
     * [10,9,8,7]
     * [5,6,7,8]
     * @param args
     */
    public static void main(String[] args) {
        int g[]={10,9,8,7};
        int s[]={5,6,7,8};
        System.out.println(new Subject_assign_cookies_455().findContentChildren(g,s));
    }
}
