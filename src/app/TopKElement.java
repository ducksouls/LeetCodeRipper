package app;

import java.util.ArrayList;

import javax.naming.ldap.SortControl;

public class TopKElement {

    /**
     * quick select 选定一个pivot然后分区->小的在左边,大的右边. 如果是pivot 是第top k
     * 的元素,则return,不是则选择左边或者右边继续
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - 1, 0, k);
    }

    public int quickSelect(int[] nums, int max, int min, int k) {
        int pivot = min + (int) (Math.random() * (max - min + 1));
        int pos = nums.length - k;

        ArrayList<Integer> list = new ArrayList<Integer>();

        // 按照pivot分区
        for (int i = min; i <= max; i++) {
            if (nums[pivot] < nums[i] && pivot > i) { // 数比pivot位置的数小,且位置也大于pivot,需要交换位置
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
                pivot = i;
            }
        }
        // 分区有误...
        /**
         * 判断k 在哪一边,依据什么? n - k 可以理解为:完全排序后要返回的结果的位置 如果当前pivot 小于 n - k 说明 结果在大于pivot
         * 的那一边
         */
        if (pos == pivot) {
            return nums[pivot];
        }
        if (pivot < pos) {
            // 返回大的那边
            return quickSelect(nums, max, pivot + 1, k);
        } else {
            // 返回小的那边
            return quickSelect(nums, pivot - 1, min, k);
        }

    }

    public static void main(String[] args) {
        TopKElement so = new TopKElement();
        int result = so.findKthLargest(new int[] { 6, 7, 3 }, 3);
        System.out.println(result);

        // int a = so.quickSelect(new int[] { 3, 2, 1, 5, 6, 4 }, 5, 0, 2);
        // System.out.println(a);
        ;
    }
}