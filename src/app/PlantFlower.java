package app;

public class PlantFlower {

    /**
     * 防御式编程思想：在 flowerbed 数组两端各增加一个 0， 这样处理的好处在于不用考虑边界条件，任意位置处只要连续出现三个 0 就可以栽上一棵花。
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i <= flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed.length == 1)
                return true;

            // 头
            if (i == 0 && i + 1 <= flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] != 1) {
                    flowerbed[i] = 1;
                    n--;
                }
            }

            if (i >= 1 && i < flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] != 1) {
                    flowerbed[i] = 1;
                    n--;
                }
            }

            // 尾巴
            if (i == flowerbed.length - 2 && flowerbed[i] == 0 && 0 == flowerbed[i + 1]) {
                flowerbed[i + 1] = 1;
                n--;
            }

        }

        return n > 0 ? false : true;
    }

    /**
     * 为了统一,假设左边多了一个0
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int num = 0, count = 1; // 假设在数组左边添加0，以解决边界问题，令count初始为1
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) { // 每连续三个0种一次花
                num++;
                count = 1;
            }
        }
        if (count == 2) { // 如果最后count为2而不是1，表示最后一个位置可以种花
            num++;
        }
        return n <= num;
    }

    /**
     * 官方答案,贪心加常数优化
     */
    public boolean canPlaceFlowers3(int[] flowerbed, int n) {
        int i = 0;
        int count = 0;
        while (i < flowerbed.length) {
            // 括号中的或利用了java || 运算的特性,即:只要前面条件满足,后面的判断将不会进行
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                count++;
                flowerbed[i] = 1;
            }
            i++;
        }
        return count >= n;
    }

    public static void main(String[] args) {
        PlantFlower so = new PlantFlower();
        boolean b = so.canPlaceFlowers(new int[] { 0, 0, 1, 0, 1 }, 1);
        System.out.println(b);
    }

}