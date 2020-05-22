package app;

/**
 * 指导思想--->使用二分法去筛选
 * 
 * 结果的判断标准---> x/result == result 问题--->只有8一个特例吗?
 * 
 * 二分法的细节:
 * 
 * mid = r-l/2 + l 循环条件 l <= r ---> mid = r - 1 l < r ---> mid = r l = mid + 1
 */
public class Sqrt {
    public int mySqrt(final int x) {
        int l = 0;
        int r = x;
        int mid = 0;
        if (x <= 1) {
            return x;
        }
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public static void main(final String[] args) {
        Sqrt so = new Sqrt();
        System.out.println(so.mySqrt(2));
        System.out.println(so.mySqrt(3));
    }
}