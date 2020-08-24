package app;

public class TopKElement {

    public static void main(String[] args) {
        TopKElement so = new TopKElement();
        int result2 = so.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 5);
        System.out.println(result2);

        Solution2 so2 = new Solution2();
        int so2result = so2.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 5);
        System.out.println(so2result);
    }

    /**
     * quick select 选定一个pivot然后分区->小的在左边,大的右边. 如果是pivot 是第top k
     * 的元素,则return,不是则选择左边或者右边继续
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - 1, 0, k);
    }

    public int quickSelect(int[] nums, int max, int min, int k) {
        // 因为随机数的问题吗?
        int pivot = max;
        int pos = nums.length - k;

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
            this.swap(nums, left, right);
        }
        this.swap(nums, left, pivot);

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
        return nums[pivot];
    }

    public void swap(int[] data, int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }


}

class Solution2 {

    /**
     * 第k大表示什么?
     * 1. 升序排列后,从右边看,这k个中最小的那个
     * 2. 升序后,左边看n-k个中最小的
     * 
     * 本质: -------小于K元素 -----k ------ 大于k元素--------
     * 
     * 因此:
     * 1.选中前面k个作小顶堆,为什么选前面K个(不符合题意啊)
     * Q: 选后面本质上也可以,一开始我也觉得很怪异,但把两个部分拆开来看
     * 前K个,k位置是目标位置,小顶堆保证了,k位置以后的数据都会大于等于k位置的
     * 所以后面n-k个(目前未知)数据只要满足某个条件,直接返回k位置的数据既是答案
     * 
     * 2. 为什么要后面要大于k中数据
     * Q: 前k个元素和后面n-k 组成了整个数据,现将两边数据兑换位置
     * 由于k 后都是大于k位置的数据,所以只要保证n-k中的每一数据小于k就行
     * 如果大于k位置元素,进行交换顺序,重新构建小顶堆,顶元素依旧会大于换下来的原k位置元素
     */
    public int findKthLargest(int[] nums, int k) {
        //前K个元素原地建小顶堆
        buildHeap(nums, k);
        //遍历剩下元素，比堆顶小，跳过；比堆顶大，交换后重新堆化
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < nums[0]) continue;
            swap(nums, i, 0);
            heapify(nums, k, 0);
        }
        //K个元素的小顶堆的堆顶即是第K大元素
        return nums[0];
    }

    /**
        * 建堆函数
        * 从倒数第一个非叶子节点开始堆化，倒数第一个非叶子节点下标为 K/2-1
        */
    public void buildHeap(int[] a, int k) {
        for (int i = k/2 - 1; i >= 0; i--) {
            heapify(a, k, i);
        }
    }

    /**
        * 堆化函数
        * 父节点下标i，左右子节点的下标分别为 2*i+1 和 2*i+2
        */
    public void heapify(int[] a, int k, int i) {
        //临时变量 minPos 用于存储最小值的下标，先假设父节点最小
        int minPos = i;
        while (true) {
            //和左子节点比较
            if (i*2+1 < k && a[i*2+1] < a[i]) minPos = i*2+1;
            //和右子节点比较
            if (i*2+2 < k && a[i*2+2] < a[minPos]) minPos = i*2+2;
            //如果minPos没有发生变化，说明父节点已经是最小了，直接跳出
            if (minPos == i) break;
            //否则交换
            swap(a, i, minPos);
            //父节点下标进行更新，继续堆化
            i = minPos;
        }
    }

    public void swap(int[] a, int n, int m) {
        int tmp = a[n];
        a[n] = a[m];
        a[m] = tmp;
    }

}
