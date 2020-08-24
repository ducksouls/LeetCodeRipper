package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.sound.sampled.SourceDataLine;

public class TopKFrequency {

    public static void main(final String[] args) {
        final TopKFrequency so = new TopKFrequency();
        final int[] result = so.topKFrequent(new int[] { 1, 2 }, 2);
    }

    /**
     * 桶排序 多少个桶->nums.length个 如何分组->值相同的分到同一个桶
     * 
     * ---------以下部分过于麻烦--------- 每个桶中元素的个数排序,选出前k个, 排序,频率相等选哪个的问题不用操心 题目给了限定条件
     * 1.k的取值 是[1,不同元素的个数] 2.前k高的频率,对应的答案是唯一的. 数组中前 k 个高频元素的集合是唯一的
     * 
     */
    public int[] topKFrequent(final int[] nums, int k) {
        // 1. 通过map做桶,<num, 频率>
        final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        Arrays.stream(nums).forEach(x -> {
            map.put(x, map.getOrDefault(x, 0) + 1);
        });

        // 问题来了,map没有顺序,要怎么才能知道哪个数的频率大
        // 且还要满足前k大的频率
        // !用数组,以频率为单位
        List<Integer>[] list = new List[nums.length + 1];
        // 把相同频率的数,放在一起

        // 遍历map
        for (int num : map.keySet()) {
            System.out.println(map.get(num));
            if (list[map.get(num)] == null) {
                list[map.get(num)] = new ArrayList<Integer>();
            }
            list[map.get(num)].add(num);
        }
        System.out.println(list);

        ArrayList<Integer> result = new ArrayList<>();

        // 遍历list
        // 从后往前遍历
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] != null && list[i].size() > 0) {
                if (k > 0) {
                    k -= list[i].size();
                    result.addAll(list[i]);
                } else {
                    int[] resultArr = new int[result.size()];
                    for (int j = 0; j < resultArr.length; j++) {
                        resultArr[j] = result.get(j);
                    }
                    return resultArr;
                }

            }
        }
        int[] resultArr = new int[result.size()];
        for (int j = 0; j < resultArr.length; j++) {
            resultArr[j] = result.get(j);
        }
        return resultArr;
    }

}