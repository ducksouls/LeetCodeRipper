package app;

public class DoublePointer {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int result = numbers[i] + numbers[j];
            if (result < target) {
                i++;
            } else if (result > target) {
                j--;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }
        return null;
    }
}