package app;

public class PlantFlower {

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

    public static void main(String[] args) {
        PlantFlower so = new PlantFlower();
        boolean b = so.canPlaceFlowers(new int[] { 0, 0, 1, 0, 1 }, 1);
        System.out.println(b);
    }

}