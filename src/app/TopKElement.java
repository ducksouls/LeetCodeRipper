package app;

import java.util.ArrayList;
import java.util.Random;

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
        // 因为随机数的问题吗?
        // int test = min + (int) (Math.random() * (max - min + 1));
        int pivot = max;
        int pos = nums.length - k;

        // 按照pivot分区
        //
        // for (int i = min; i <= max; i++) {
        // if (nums[pivot] < nums[i] && pivot > i) { // 数比pivot位置的数小,且位置也大于pivot,需要交换位置
        // int temp = nums[pivot];
        // nums[pivot] = nums[i];
        // nums[i] = temp;
        // pivot = i;
        // }
        // }
        // 分区有误...
        int left = min, right = max;
        while (left < right) {
            // 遇到比pivot小的跳过
            while (left < right && nums[left] <= nums[pivot]) {
                left++;
            }
            // 遇到比pivot 大的跳过
            while (left < right && nums[right] >= nums[pivot]) {
                right--;
            }
            TopKElement.swap(nums, left, right);
        }
        TopKElement.swap(nums, left, pivot);

        /**
         * 判断k 在哪一边,依据什么? n - k 可以理解为:完全排序后要返回的结果的位置 如果当前pivot 小于 n - k 说明 结果在大于pivot
         * 的那一边
         */

        if (left < pos) {
            // 返回大的那边
            return quickSelect(nums, max, left + 1, k);
        }

        if (left > pos) {
            // 返回小的那边
            return quickSelect(nums, left - 1, min, k);
        }
        return nums[pos];
    }

    public static int quickSelect2(int[] data, int k, int start, int end) {
        if (k > data.length || start > end) {
            return -1;
        }
        /*
         * 与quick sort 相同的partition算法（分割算法）。
         */
        int pivot = end;
        // Random random_num = new Random(10);
        // int pivot = start + random_num.nextInt(end - start);
        // int pivot = start + (int) (Math.random() * (end - start + 1));

        int left = start;
        int right = end;
        while (left < right) {
            while (data[left] <= data[pivot] && left < right) {
                left++;
            }
            while (data[right] >= data[pivot] && left < right) {
                right--;
            }
            swap(data, left, right);
        }
        swap(data, left, pivot);
        /*
         * 与快速排序相同，只是在recurse时，多了两个判断，即k的判断。因此，只有一个递归调用会执行。 相较于快速排序的期望时间复杂度O(n log
         * n)，快速选择的期望时间复杂度为O(n)。
         */
        if (k - 1 > left) {
            quickSelect2(data, k, left + 1, end);
        }
        if (k - 1 < left) {
            quickSelect2(data, k, start, left - 1);
        }

        return data[k - 1];
    }

    public static void swap(int[] data, int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    public static void main(String[] args) {
        TopKElement so = new TopKElement();
        int result2 = so.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 6);
        System.out.println(result2);

        int[] data = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int result = TopKElement.quickSelect2(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 6, 0, data.length - 1);
        System.out.println(result);

        // int a = so.quickSelect(new int[] { 3, 2, 1, 5, 6, 4 }, 5, 0, 2);
        // System.out.println(a);
        ;
    }
}