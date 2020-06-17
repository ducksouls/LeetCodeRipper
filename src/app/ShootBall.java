package app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.sound.sampled.SourceDataLine;

public class ShootBall {

    /**
     * 一开始我的思路是,遍历两次,跳过那些已经被射过的气球 时间复杂度是N平方,思路是能走通的,但是时间太长
     * 
     * 左边已经没有气球了； 本次投飞镖能够刺破最多的气球。
     * 
     * 能缩减的点: ->1. 排序后,每个气球的右边界,原来的是求两个气球的相交的长度 ->2. 一箭下去该破的左边是不可能保留有气球,所以一次循环即可搞定
     * 
     * ae > bs
     */

    public int findMinArrowShots(int[][] points) {
        int shoot = 1;
        // 排序很重要
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));
        // 射箭的点位
        int target = points[0][1];
        for (int i = 0; i <= points.length - 1; i++) {
            // 只要保证点位能够在下一个气球的起点后面就能一石二鸟
            // 否则就要在开一箭
            if (target < points[i][0]) {
                shoot++;
                // 射一发后需要更换点位
                target = points[i][1];
            }
        }
        return shoot;
    }

    // [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
    public static void main(String[] args) {
        ShootBall so = new ShootBall();
        int result = so.findMinArrowShots(new int[][] { { 3, 9 }, { 7, 12 }, { 3, 8 }, { 6, 8 }, { 9, 10 }, { 2, 9 },
                { 0, 9 }, { 3, 9 }, { 0, 6 }, { 2, 8 } });
        System.out.println(result);
    }

}