package app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class TopKFrequency {

    public static void main(String[] args) {
        TopKFrequency so = new TopKFrequency();
        int[] result = so.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3, 5, 5, 5, 5, 5, 5 }, 2);
    }

    /**
     * 桶排序 多少个桶->nums.length个 如何分组->值相同的分到同一个桶
     * 
     * ---------一下部分过于麻烦--------- 每个桶中元素的个数排序,选出前k个, 排序,频率相等选哪个的问题不用操心 题目给了限定条件 1.
     * k的取值 是[1,不同元素的个数] 2.前k高的频率,对应的答案是唯一的,多个数的频率相同然后选择是不会出现的
     * 
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 通过map做桶,<num, 频率>
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        Arrays.stream(nums).forEach(x -> {
            map.put(x, map.getOrDefault(x, 0) + 1);
        });

        // 问题来了,map没有顺序,要怎么才能知道哪个数的频率大
        // 且还要满足前k大的频率
        // !用数组,以频率为单位

        // 遍历map
        for (int num : map.keySet()) {
            // System.out.println(num);
            // System.out.println("------");
            System.out.println(map.get(num));
        }

        return null;

    }

}