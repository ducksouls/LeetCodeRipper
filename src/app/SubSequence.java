package app;

public class SubSequence {
    public boolean isSubsequence(String s, String t) {
        char[] charArrT = t.toCharArray();
        char[] charArrS = s.toCharArray();
        int i = 0, subI = 0, j = charArrT.length - 1, subJ = charArrS.length - 1;
        if (subI > subJ)
            return true;
        if (subI == subJ)
            return charArrT[subI] == charArrS[subI] ? true : false;
        while (i < j) {
            if (charArrT[i] != charArrS[subI]) {
                i++;
            } else {
                i++;
                subI++;
            }
            if (charArrT[j] != charArrS[subJ]) {
                j--;
            } else {
                j--;
                subJ--;
            }
            if (subI > subJ) {
                return true;
            }
        }
        return false;

    }

    /**
     * 后续挑战:如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T
     * 的子序列。在这种情况下，你会怎样改变代码？
     * 
     * 用空间换时间,因为只要匹配26个字母所以准备一个二维数组dp[n][26]
     * 
     * 表示:t串在当前位置字符后面需要匹配的字符的位置
     * 
     * 在于每个子串匹配时,只要遍历自身,再按照处理好的T串位置比较,如果找不到则说明不是子串
     */
    public boolean isSubsequence2(String s, String t) {
        // 预处理
        t = " " + t; // 开头加一个空字符作为匹配入口
        int n = t.length();
        int[][] dp = new int[n][26]; // 记录每个位置的下一个ch的位置
        for (char ch = 0; ch < 26; ch++) {
            int p = -1;
            for (int i = n - 1; i >= 0; i--) { // 从后往前记录dp
                dp[i][ch] = p;
                if (t.charAt(i) == ch + 'a')
                    p = i;
            }
        }
        // 匹配
        int i = 0;
        for (char ch : s.toCharArray()) { // 跳跃遍历
            i = dp[i][ch - 'a'];
            if (i == -1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SubSequence sb = new SubSequence();
        boolean result = sb.isSubsequence("ace", "abcdefg");
        sb.isSubsequence2("ada", "avecniceday");

    }
}